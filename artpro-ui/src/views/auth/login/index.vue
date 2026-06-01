<template>
  <div class="flex w-full h-screen">
    <LoginLeftView />
    <div class="relative flex-1">
      <AuthTopBar />
      <div class="auth-right-wrap">
        <div class="form">
          <h3 class="title">{{ getSiteConfig('site.login.title', $t('login.title')) }}</h3>
          <p class="sub-title">{{
            getSiteConfig('site.login.description', $t('login.subTitle'))
          }}</p>
          <ElForm
            ref="formRef"
            :model="formData"
            :rules="rules"
            @keyup.enter="handleSubmit"
            style="margin-top: 25px"
          >
            <ElFormItem prop="username">
              <ElInput
                v-model.trim="formData.username"
                class="custom-height"
                :placeholder="$t('login.placeholder.username')"
              />
            </ElFormItem>
            <ElFormItem prop="password">
              <ElInput
                v-model.trim="formData.password"
                class="custom-height"
                type="password"
                autocomplete="off"
                show-password
                :placeholder="$t('login.placeholder.password')"
              />
            </ElFormItem>
            <ElFormItem
              v-if="captchaInfo.captchaEnabled && captchaInfo.captchaType === 'image'"
              prop="code"
            >
              <div class="captcha-row">
                <ElInput
                  v-model.trim="formData.code"
                  class="custom-height captcha-input"
                  placeholder="请输入验证码"
                />
                <button
                  class="captcha-image-wrap"
                  type="button"
                  title="点击刷新验证码"
                  @click="loadCaptcha"
                >
                  <img class="captcha-image" :src="captchaImage" alt="验证码" />
                </button>
              </div>
            </ElFormItem>
            <div
              v-if="captchaInfo.captchaEnabled && captchaInfo.captchaType === 'slider'"
              class="relative pb-5 mt-6"
            >
              <div
                class="relative z-[2] overflow-hidden select-none rounded-lg border border-transparent tad-300"
                :class="{ '!border-[#FF4E4F]': !isPassing && isClickPass }"
              >
                <ArtDragVerify
                  ref="dragVerify"
                  v-model:value="isPassing"
                  :text="$t('login.sliderText')"
                  :successText="$t('login.sliderSuccessText')"
                  textColor="var(--art-gray-700)"
                  progressBarBg="var(--main-color)"
                  :background="isDark ? '#26272F' : '#F1F1F4'"
                  handlerBg="var(--default-box-color)"
                />
              </div>
              <p
                class="absolute top-0 z-[1] px-px mt-2 text-xs text-[#f56c6c] tad-300"
                :class="{ 'translate-y-10': !isPassing && isClickPass }"
                >{{ $t('login.placeholder.slider') }}</p
              >
            </div>
            <div class="flex-cb mt-2 text-sm">
              <ElCheckbox v-model="formData.rememberPassword">{{
                $t('login.rememberPwd')
              }}</ElCheckbox>
            </div>
            <div style="margin-top: 30px">
              <ElButton
                class="w-full custom-height"
                type="primary"
                :loading="loading"
                v-ripple
                @click="handleSubmit"
                >{{ $t('login.btnText') }}</ElButton
              >
            </div>
            <div v-if="captchaInfo.registerEnabled" class="mt-5 text-sm text-gray-600">
              <span>{{ $t('login.noAccount') }}</span>
              <RouterLink class="text-theme" :to="{ name: 'Register' }">{{
                $t('login.register')
              }}</RouterLink>
            </div>
          </ElForm>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
  import AppConfig from '@/config'
  import { useUserStore } from '@/store/modules/user'
  import { useI18n } from 'vue-i18n'
  import { fetchCaptcha, fetchLogin, type CaptchaInfo } from '@/api/auth'
  import { ElNotification, type FormInstance, type FormRules } from 'element-plus'
  import { useSettingStore } from '@/store/modules/setting'
  import { getSiteConfig, loadSiteConfig } from '@/utils/site-config'

  defineOptions({ name: 'Login' })

  const { isDark } = storeToRefs(useSettingStore())
  const { t } = useI18n()
  const userStore = useUserStore()
  const router = useRouter()
  const route = useRoute()
  const formRef = ref<FormInstance>()
  const dragVerify = ref<{ reset: () => void }>()
  const loading = ref(false)
  const isPassing = ref(false)
  const isClickPass = ref(false)
  const captchaInfo = reactive<CaptchaInfo>({
    captchaEnabled: true,
    captchaType: 'slider',
    registerEnabled: false
  })
  const captchaImage = computed(() =>
    captchaInfo.img ? `data:image/gif;base64,${captchaInfo.img}` : ''
  )
  const formData = reactive({
    username: '',
    password: '',
    code: '',
    uuid: '',
    rememberPassword: true
  })
  const rules = computed<FormRules>(() => ({
    username: [{ required: true, message: t('login.placeholder.username'), trigger: 'blur' }],
    password: [{ required: true, message: t('login.placeholder.password'), trigger: 'blur' }],
    code: [
      { required: captchaInfo.captchaType === 'image', message: '请输入验证码', trigger: 'blur' }
    ]
  }))

  onMounted(async () => {
    await loadSiteConfig().catch(() => undefined)
    await loadCaptcha()
  })

  async function loadCaptcha() {
    Object.assign(captchaInfo, await fetchCaptcha())
    formData.code = ''
    formData.uuid = captchaInfo.uuid || ''
  }

  async function handleSubmit() {
    if (!formRef.value) return
    try {
      await formRef.value.validate()
      if (captchaInfo.captchaEnabled && captchaInfo.captchaType === 'slider' && !isPassing.value) {
        isClickPass.value = true
        return
      }
      loading.value = true
      const { token, refreshToken } = await fetchLogin({
        username: formData.username,
        password: formData.password,
        code: formData.code,
        uuid: formData.uuid
      })
      userStore.setToken(token, refreshToken)
      userStore.setLoginStatus(true)
      ElNotification({
        title: t('login.success.title'),
        type: 'success',
        message: `${t('login.success.message')}, ${getSiteConfig('site.name', AppConfig.systemInfo.name)}!`
      })
      await router.push((route.query.redirect as string) || '/')
    } catch {
      await loadCaptcha()
      dragVerify.value?.reset()
    } finally {
      loading.value = false
    }
  }
</script>

<style scoped>
  @import './style.css';
</style>
