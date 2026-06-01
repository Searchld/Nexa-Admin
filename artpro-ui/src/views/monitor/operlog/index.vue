<template>
  <MonitorListPage
    permission="monitor:operlog"
    id-key="operId"
    :fields="fields"
    :list-fn="fetchOperLogList"
    :remove-fn="removeOperLog"
    :clean-fn="cleanOperLogs"
    export-url="/monitor/operlog/export"
  />
</template>
<script setup lang="ts">
  import MonitorListPage from '@/components/business/monitor-list-page/index.vue'
  import { cleanOperLogs, fetchOperLogList, removeOperLog } from '@/api/monitor'
  import { useDict } from '@/hooks/core/useDict'
  defineOptions({ name: 'MonitorOperlog' })
  const { dict } = useDict('sys_oper_type', 'sys_common_status')
  const fields = computed(() => [
    { prop: 'operId', label: '日志编号', width: 90 },
    { prop: 'title', label: '系统模块', search: true },
    { prop: 'businessType', label: '操作类型', dict: dict.sys_oper_type },
    { prop: 'operName', label: '操作人员', search: true },
    { prop: 'operIp', label: '操作地址' },
    { prop: 'operLocation', label: '操作地点' },
    { prop: 'status', label: '状态', dict: dict.sys_common_status },
    { prop: 'operTime', label: '操作时间', minWidth: 170 }
  ])
</script>
