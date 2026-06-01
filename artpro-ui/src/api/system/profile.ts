import request from '@/utils/http'
import type { Entity } from './types'

export interface Profile extends Entity {
  userId?: number
  userName?: string
  nickName?: string
  email?: string
  phonenumber?: string
  sex?: string
  avatar?: string
}

export const fetchProfile = () => request.get<Profile>({ url: '/system/user/profile' })
export const updateProfile = (data: Profile) =>
  request.put<void>({ url: '/system/user/profile', data, showSuccessMessage: true })
export const updatePassword = (oldPassword: string, newPassword: string) =>
  request.put<void>({
    url: '/system/user/profile/updatePwd',
    data: { oldPassword, newPassword },
    showSuccessMessage: true
  })
export const uploadProfileAvatar = (file: File) => {
  const data = new FormData()
  data.append('avatarfile', file)
  return request.post<{ imgUrl: string }>({
    url: '/system/user/profile/avatar',
    data,
    showSuccessMessage: true
  })
}

export function resolveAvatarUrl(avatar?: string) {
  if (!avatar) return ''
  if (/^(https?:|data:|blob:)/.test(avatar)) return avatar
  return `${import.meta.env.VITE_API_URL}${avatar.startsWith('/') ? '' : '/'}${avatar}`
}
