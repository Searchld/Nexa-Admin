<template>
  <div class="art-full-height">
    <ElRow :gutter="16">
      <ElCol :lg="15" :span="24">
        <ElCard>
          <template #header>基本资料</template>
          <ArtForm
            ref="profileFormRef"
            v-model="profile"
            :items="profileItems"
            :rules="profileRules"
            :show-submit="false"
            :show-reset="false"
          />
          <ElButton type="primary" :loading="savingProfile" @click="saveProfile">保存资料</ElButton>
        </ElCard>
      </ElCol>
      <ElCol :lg="9" :span="24">
        <ElCard>
          <template #header>头像</template>
          <div class="flex flex-col items-center gap-4">
            <ElAvatar :size="120" :src="avatarUrl" />
            <ElUpload :show-file-list="false" accept="image/*" :http-request="uploadAvatar">
              <ElButton type="primary">上传头像</ElButton>
            </ElUpload>
          </div>
        </ElCard>
        <ElCard class="mt-4">
          <template #header>修改密码</template>
          <ArtForm
            ref="passwordFormRef"
            v-model="password"
            :items="passwordItems"
            :rules="passwordRules"
            :show-submit="false"
            :show-reset="false"
          />
          <ElButton type="primary" :loading="savingPassword" @click="savePassword"
            >修改密码</ElButton
          >
        </ElCard>
      </ElCol>
    </ElRow>
  </div>
</template>

<script setup lang="ts">
  import type { UploadRequestOptions } from 'element-plus'
  import {
    fetchProfile,
    resolveAvatarUrl,
    updatePassword,
    updateProfile,
    uploadProfileAvatar,
    type Profile
  } from '@/api/system/profile'
  import { useUserStore } from '@/store/modules/user'

  defineOptions({ name: 'SystemUserCenter' })
  const userStore = useUserStore()
  const profileFormRef = ref<{ validate: () => Promise<boolean> }>()
  const passwordFormRef = ref<{ validate: () => Promise<boolean> }>()
  const profile = reactive<Profile>({})
  const password = reactive({ oldPassword: '', newPassword: '', confirmPassword: '' })
  const savingProfile = ref(false),
    savingPassword = ref(false)
  const avatarUrl = computed(() => resolveAvatarUrl(profile.avatar))
  const profileItems = [
    { key: 'userName', label: '登录账号', type: 'input', props: { disabled: true } },
    { key: 'nickName', label: '用户昵称', type: 'input' },
    { key: 'phonenumber', label: '手机号码', type: 'input' },
    { key: 'email', label: '邮箱', type: 'input' },
    {
      key: 'sex',
      label: '性别',
      type: 'select',
      props: {
        options: [
          { label: '男', value: '0' },
          { label: '女', value: '1' },
          { label: '未知', value: '2' }
        ]
      }
    }
  ]
  const passwordItems = [
    {
      key: 'oldPassword',
      label: '旧密码',
      type: 'input',
      props: { type: 'password', showPassword: true }
    },
    {
      key: 'newPassword',
      label: '新密码',
      type: 'input',
      props: { type: 'password', showPassword: true }
    },
    {
      key: 'confirmPassword',
      label: '确认密码',
      type: 'input',
      props: { type: 'password', showPassword: true }
    }
  ]
  const profileRules = {
    nickName: [{ required: true, message: '请输入用户昵称' }],
    email: [{ type: 'email', message: '请输入正确的邮箱地址' }]
  }
  const passwordRules = {
    oldPassword: [{ required: true, message: '请输入旧密码' }],
    newPassword: [{ required: true, min: 5, max: 20, message: '新密码长度为 5 到 20 个字符' }],
    confirmPassword: [
      {
        validator: (_rule: unknown, value: string, callback: (error?: Error) => void) =>
          value === password.newPassword ? callback() : callback(new Error('两次输入的密码不一致'))
      }
    ]
  }
  onMounted(async () => Object.assign(profile, await fetchProfile()))
  async function saveProfile() {
    await profileFormRef.value?.validate()
    savingProfile.value = true
    try {
      await updateProfile(profile)
      userStore.setUserInfo({ ...userStore.info, ...profile } as Api.Auth.UserInfo)
    } finally {
      savingProfile.value = false
    }
  }
  async function savePassword() {
    await passwordFormRef.value?.validate()
    savingPassword.value = true
    try {
      await updatePassword(password.oldPassword, password.newPassword)
      Object.assign(password, { oldPassword: '', newPassword: '', confirmPassword: '' })
    } finally {
      savingPassword.value = false
    }
  }
  async function uploadAvatar(options: UploadRequestOptions) {
    const result = await uploadProfileAvatar(options.file)
    profile.avatar = result.imgUrl
    userStore.setUserInfo({ ...userStore.info, avatar: result.imgUrl } as Api.Auth.UserInfo)
  }
</script>
