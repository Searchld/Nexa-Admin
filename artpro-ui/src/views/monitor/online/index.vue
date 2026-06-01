<template>
  <MonitorListPage
    permission="monitor:online"
    id-key="tokenId"
    :fields="fields"
    :list-fn="fetchOnlineList"
    :remove-fn="forceLogout"
  />
</template>
<script setup lang="ts">
  import MonitorListPage from '@/components/business/monitor-list-page/index.vue'
  import { fetchOnlineList, forceLogout } from '@/api/monitor'
  defineOptions({ name: 'MonitorOnline' })
  const fields = [
    { prop: 'tokenId', label: '会话编号', minWidth: 230 },
    { prop: 'userName', label: '用户名称', search: true },
    { prop: 'deptName', label: '部门' },
    { prop: 'ipaddr', label: '登录地址', search: true },
    { prop: 'loginLocation', label: '登录地点' },
    { prop: 'browser', label: '浏览器' },
    { prop: 'os', label: '操作系统' },
    { prop: 'loginTime', label: '登录时间', minWidth: 170 }
  ]
</script>
