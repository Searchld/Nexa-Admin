import request from '@/utils/http'
import { add, get, list, remove, update } from './base'
import type { Entity, Query } from './types'

const appRoot = '/system/agent/app'
const kbRoot = '/system/agent/kb'
const workflowRoot = '/system/agent/workflow'
const logRoot = '/system/agent/tool-call'

export interface AgentApp extends Entity {
  appId: number
  appName: string
  appType: string
  modelCode: string
  status: string
}

export interface AgentKnowledgeBase extends Entity {
  kbId: number
  kbName: string
  visibility: string
  status: string
  docCount?: number
}

export interface AgentWorkflow extends Entity {
  workflowId: number
  workflowName: string
  status: string
  version: number
}

export const fetchAgentAppList = (params: Query) => list<AgentApp>(`${appRoot}/list`, params)
export const fetchAgentApp = (id: number) => get<AgentApp>(`${appRoot}/${id}`)
export const addAgentApp = (data: Entity) => add(appRoot, data)
export const updateAgentApp = (data: Entity) => update(appRoot, data)
export const removeAgentApp = (id: number | string) => remove(`${appRoot}/${id}`)
export const testAgentApp = (id: number) =>
  request.post<void>({ url: `${appRoot}/${id}/test`, showSuccessMessage: true })

export const fetchAgentKbList = (params: Query) =>
  list<AgentKnowledgeBase>(`${kbRoot}/list`, params)
export const fetchAgentKb = (id: number) => get<AgentKnowledgeBase>(`${kbRoot}/${id}`)
export const fetchAgentKbOptions = () =>
  request.get<AgentKnowledgeBase[]>({ url: `${kbRoot}/options` })
export const addAgentKb = (data: Entity) => add(kbRoot, data)
export const updateAgentKb = (data: Entity) => update(kbRoot, data)
export const removeAgentKb = (id: number | string) => remove(`${kbRoot}/${id}`)
export const fetchAgentKbDocuments = (kbId: number) =>
  request.get<Entity[]>({ url: `${kbRoot}/${kbId}/documents` })
export const uploadAgentKbDocument = (kbId: number, file: File) => {
  const data = new FormData()
  data.append('file', file)
  return request.post<Entity>({
    url: `${kbRoot}/${kbId}/documents/upload`,
    data,
    showSuccessMessage: true,
    timeout: 120000
  })
}
export const reindexAgentKbDocument = (docId: number) =>
  request.post<Entity>({ url: `${kbRoot}/documents/${docId}/reindex`, showSuccessMessage: true })
export const removeAgentKbDocument = (docId: number | string) =>
  request.del<void>({ url: `${kbRoot}/documents/${docId}`, showSuccessMessage: true })

export const fetchAgentWorkflowList = (params: Query) =>
  list<AgentWorkflow>(`${workflowRoot}/list`, params)
export const fetchAgentWorkflow = (id: number) => get<AgentWorkflow>(`${workflowRoot}/${id}`)
export const addAgentWorkflow = (data: Entity) => add(workflowRoot, data)
export const updateAgentWorkflow = (data: Entity) => update(workflowRoot, data)
export const removeAgentWorkflow = (id: number | string) => remove(`${workflowRoot}/${id}`)
export const runAgentWorkflow = (id: number, input: Entity) =>
  request.post<Entity>({ url: `${workflowRoot}/${id}/run`, data: input, showSuccessMessage: true })
export const fetchAgentWorkflowRuns = (params: Query) =>
  request.get<{ rows: Entity[]; total: number }>({ url: `${workflowRoot}/runs`, params })

export const fetchAgentToolCallList = (params: Query) => list<Entity>(`${logRoot}/list`, params)
