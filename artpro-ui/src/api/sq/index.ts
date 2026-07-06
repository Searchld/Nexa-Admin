import { add, get, list, remove, update } from '@/api/system/base'
import type { Entity, Query } from '@/api/system/types'
import request from '@/utils/http'

export interface SqCrudApi {
  list: (params: Query) => Promise<{ rows: Entity[]; total: number }>
  get: (id: number | string) => Promise<Entity>
  add: (data: Entity) => Promise<unknown>
  update: (data: Entity) => Promise<unknown>
  remove: (ids: number | string) => Promise<unknown>
  exportUrl: string
}

export function createSqCrudApi(root: string): SqCrudApi {
  return {
    list: (params: Query) => list(`${root}/list`, params),
    get: (id: number | string) => get<Entity>(`${root}/${id}`),
    add: (data: Entity) => add(root, data),
    update: (data: Entity) => update(root, data),
    remove: (ids: number | string) => remove(`${root}/${ids}`),
    exportUrl: `${root}/export`
  }
}

export const sqApis = {
  cars: createSqCrudApi('/api/cars'),
  camera: createSqCrudApi('/api/camera'),
  alert: createSqCrudApi('/api/alert'),
  alertInfo: createSqCrudApi('/api/alertInfo'),
  alertReason: createSqCrudApi('/api/alertReason'),
  team: createSqCrudApi('/api/team'),
  carsLogs: createSqCrudApi('/api/carsLogs'),
  carsOutLogs: createSqCrudApi('/api/carsOutLogs'),
  aCarsLogsHis: createSqCrudApi('/api/aCarsLogsHis'),
  ynUser: createSqCrudApi('/api/ynUser'),
  ynUserXj: createSqCrudApi('/api/ynUserXj'),
  ynWxUser: createSqCrudApi('/api/ynWxUser'),
  ynWxDept: createSqCrudApi('/api/ynWxDept'),
  ynWxSend: createSqCrudApi('/api/ynWxSend'),
  ynTask: createSqCrudApi('/api/ynTask'),
  ynSiren: createSqCrudApi('/api/ynSiren'),
  ynRfid: createSqCrudApi('/api/ynRfid'),
  ynRfidYdq: createSqCrudApi('/api/ynRfidYdq'),
  ynRfidRecord: createSqCrudApi('/api/ynRfidRecord'),
  ynCameraRecord: createSqCrudApi('/api/ynCameraRecord'),
  ynLogsLevel: createSqCrudApi('/api/ynLogsLevel'),
  ynLogsOut: createSqCrudApi('/api/ynLogsOut')
}

export function uploadSqFile(file: File, image = false) {
  const data = new FormData()
  data.append('file', file)
  return request.post<string>({
    url: image ? '/api/upload/img/updFile' : '/api/upload/updFile',
    data,
    showSuccessMessage: true
  })
}
