<template>
  <div class="art-full-height">
    <SystemCrudPage
      ref="page"
      title="Agent应用"
      permission="system:agent:app"
      id-key="appId"
      :fields="fields"
      :list-fn="fetchAgentAppList"
      :get-fn="fetchAgentApp"
      :add-fn="addAgentApp"
      :update-fn="updateAgentApp"
      :remove-fn="removeAgentApp"
      :status-fn="updateAgentApp"
      :actions="actions"
      :defaults="defaults"
      drawer-size="820px"
    />
  </div>
</template>

<script setup lang="ts">
  import { ElMessage } from 'element-plus'
  import SystemCrudPage from '@/components/business/system-crud-page/index.vue'
  import {
    addAgentApp,
    fetchAgentApp,
    fetchAgentAppList,
    removeAgentApp,
    testAgentApp,
    updateAgentApp
  } from '@/api/system/agent'

  defineOptions({ name: 'SystemAgentApp' })

  const page = ref<{ refreshData: () => void }>()
  const statusOptions = [
    { label: '正常', value: '0' },
    { label: '停用', value: '1' }
  ]
  const typeOptions = [
    { label: '聊天', value: 'chat' },
    { label: 'Agent', value: 'agent' },
    { label: '工作流', value: 'workflow' }
  ]
  const yesNoOptions = [
    { label: '否', value: '0' },
    { label: '是', value: '1' }
  ]
  const defaults = {
    appType: 'chat',
    status: '0',
    isDefault: '0',
    temperature: 0.7,
    maxTokens: 2048,
    systemPrompt: '你是 Nexa Admin 内置的业务 Agent，回答要准确、简洁，并遵守系统权限边界。'
  }
  const fields = computed(() => [
    { prop: 'appName', label: '应用名称', required: true, search: true },
    {
      prop: 'appType',
      label: '类型',
      type: 'select',
      options: typeOptions,
      dict: typeOptions,
      required: true,
      search: true
    },
    { prop: 'modelCode', label: '模型标识', required: true, search: true },
    { prop: 'baseUrl', label: 'API Base URL', required: true, minWidth: 220 },
    {
      prop: 'apiKey',
      label: 'API Key',
      table: false,
      required: true,
      props: { type: 'password', showPassword: true, autocomplete: 'new-password' }
    },
    { prop: 'embeddingModelCode', label: 'Embedding模型', table: false },
    { prop: 'embeddingBaseUrl', label: 'Embedding URL', table: false },
    {
      prop: 'embeddingApiKey',
      label: 'Embedding Key',
      table: false,
      props: { type: 'password', showPassword: true, autocomplete: 'new-password' }
    },
    {
      prop: 'isDefault',
      label: '默认',
      type: 'select',
      options: yesNoOptions,
      dict: yesNoOptions,
      required: true
    },
    {
      prop: 'status',
      label: '状态',
      type: 'select',
      options: statusOptions,
      dict: statusOptions,
      required: true,
      search: true
    },
    { prop: 'temperature', label: 'Temperature', type: 'number', table: false },
    { prop: 'maxTokens', label: '最大Token', type: 'number', table: false },
    { prop: 'bindModule', label: '绑定模块', table: false },
    {
      prop: 'systemPrompt',
      label: '系统提示词',
      table: false,
      span: 24,
      props: { type: 'textarea', rows: 4 }
    },
    { prop: 'remark', label: '备注', table: false, props: { type: 'textarea', rows: 3 } },
    { prop: 'createTime', label: '创建时间', form: false, minWidth: 170 }
  ])
  const actions = [
    {
      key: 'test',
      label: '测试连接',
      auth: 'system:agent:app:test',
      icon: 'ri:link',
      handler: async (row: Record<string, any>) => {
        await testAgentApp(row.appId)
        ElMessage.success('连接成功')
        page.value?.refreshData()
      }
    }
  ]
</script>
