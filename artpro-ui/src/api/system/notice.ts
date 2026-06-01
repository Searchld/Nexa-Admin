import { add, get, list, remove, update } from './base'
import type { Entity, Query } from './types'
const root = '/system/notice'
export const fetchNoticeList = (params: Query) => list(`${root}/list`, params)
export const fetchNotice = (id: number) => get<Entity>(`${root}/${id}`)
export const addNotice = (data: Entity) => add(root, data)
export const updateNotice = (data: Entity) => update(root, data)
export const removeNotice = (ids: string | number) => remove(`${root}/${ids}`)
export const fetchNoticeReadUsers = (params: Query) => list(`${root}/readUsers/list`, params)
