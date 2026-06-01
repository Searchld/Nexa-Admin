<template>
  <div class="flex w-full h-screen"
    ><LoginLeftView /><div class="relative flex-1"
      ><AuthTopBar /><div class="auth-right-wrap"
        ><div class="form">
          <h3 class="title">{{ $t('register.title') }}</h3>
          <ElForm ref="formRef" :model="form" :rules="rules" class="mt-7.5">
            <ElFormItem prop="username"
              ><ElInput
                v-model.trim="form.username"
                class="custom-height"
                :placeholder="$t('register.placeholder.username')"
            /></ElFormItem>
            <ElFormItem prop="password"
              ><ElInput
                v-model.trim="form.password"
                class="custom-height"
                type="password"
                show-password
                :placeholder="$t('register.placeholder.password')"
            /></ElFormItem>
            <ElFormItem prop="confirmPassword"
              ><ElInput
                v-model.trim="form.confirmPassword"
                class="custom-height"
                type="password"
                show-password
                :placeholder="$t('register.placeholder.confirmPassword')"
            /></ElFormItem>
            <ElFormItem v-if="captcha.captchaEnabled && captcha.captchaType === 'image'" prop="code"
              ><div class="flex w-full gap-3"
                ><ElInput v-model="form.code" placeholder="请输入验证码" /><img
                  class="h-10 cursor-pointer"
                  :src="image"
                  @click="loadCaptcha" /></div
            ></ElFormItem>
            <ArtDragVerify
              v-if="captcha.captchaEnabled && captcha.captchaType === 'slider'"
              ref="drag"
              v-model:value="passed"
            />
            <ElButton
              class="w-full mt-6 custom-height"
              type="primary"
              :loading="loading"
              @click="register"
              >注册</ElButton
            >
            <div class="mt-5 text-sm"
              ><RouterLink class="text-theme" :to="{ name: 'Login' }">{{
                $t('register.toLogin')
              }}</RouterLink></div
            >
          </ElForm>
        </div></div
      ></div
    ></div
  >
</template>
<script setup lang="ts">
  import { fetchCaptcha, fetchRegister, type CaptchaInfo } from '@/api/auth'
  import type { FormInstance, FormRules } from 'element-plus'
  const router = useRouter()
  const formRef = ref<FormInstance>()
  const captcha = reactive<CaptchaInfo>({
    captchaEnabled: true,
    captchaType: 'slider',
    registerEnabled: false
  })
  const form = reactive({ username: '', password: '', confirmPassword: '', code: '', uuid: '' })
  const passed = ref(false)
  const loading = ref(false)
  const image = computed(() => (captcha.img ? `data:image/gif;base64,${captcha.img}` : ''))
  const rules: FormRules = {
    username: [{ required: true, message: '请输入用户名' }],
    password: [{ required: true, message: '请输入密码' }],
    confirmPassword: [
      {
        required: true,
        validator: (_rule, value, callback) =>
          callback(value === form.password ? undefined : new Error('两次密码输入不一致'))
      }
    ],
    code: [{ required: true, message: '请输入验证码' }]
  }
  onMounted(loadCaptcha)
  async function loadCaptcha() {
    Object.assign(captcha, await fetchCaptcha())
    form.code = ''
    form.uuid = captcha.uuid || ''
  }
  async function register() {
    await formRef.value?.validate()
    if (captcha.captchaEnabled && captcha.captchaType === 'slider' && !passed.value) return
    loading.value = true
    try {
      await fetchRegister(form)
      await router.push({ name: 'Login' })
    } finally {
      loading.value = false
    }
  }
</script>
<style scoped>
  @import '../login/style.css';
</style>
