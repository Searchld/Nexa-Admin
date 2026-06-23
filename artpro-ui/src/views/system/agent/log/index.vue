<template>
  <div class="art-full-height">
    <SystemCrudPage
      title="Agent调用日志"
      permission="system:agent:log"
      id-key="toolCallId"
      :fields="fields"
      :list-fn="fetchAgentToolCallList"
      :add-fn="noop"
      :update-fn="noop"
      :remove-fn="noop"
      drawer-size="720px"
    />
  </div>
</template>

<script setup lang="ts">
  import SystemCrudPage from '@/components/business/system-crud-page/index.vue'
  import { fetchAgentToolCallList } from '@/api/system/agent'

  defineOptions({ name: 'SystemAgentLog' })

  const noop = async () => undefined
  const fields = computed(() => [
    { prop: 'toolName', label: '工具名称', search: true, minWidth: 160 },
    { prop: 'userId', label: '用户ID', search: true, width: 100 },
    { prop: 'sessionId', label: '会话ID', width: 110 },
    { prop: 'workflowRunId', label: '运行ID', width: 110 },
    { prop: 'resultSummary', label: '结果摘要', minWidth: 240 },
    { prop: 'errorMsg', label: '错误信息', minWidth: 220 },
    { prop: 'elapsedMs', label: '耗时(ms)', width: 110 },
    { prop: 'argumentsJson', label: '参数', table: false, props: { type: 'textarea', rows: 4 } },
    { prop: 'createTime', label: '调用时间', form: false, minWidth: 170 }
  ])
</script>
