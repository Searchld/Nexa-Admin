<template>
  <div class="art-full-height"
    ><ElSkeleton v-if="loading" :rows="8" animated /><template v-else>
      <ElRow :gutter="16"
        ><ElCol v-for="item in overview" :key="item.label" :span="6"
          ><ElCard class="mb-4"
            ><div class="text-g-500">{{ item.label }}</div
            ><div class="mt-3 text-2xl font-semibold">{{ item.value }}</div></ElCard
          ></ElCol
        ></ElRow
      >
      <ElCard header="Redis 信息"
        ><ElDescriptions :column="2" border
          ><ElDescriptionsItem v-for="item in info" :key="item.label" :label="item.label">{{
            item.value
          }}</ElDescriptionsItem></ElDescriptions
        ></ElCard
      >
      <ElCard class="mt-4" header="命令统计"
        ><ElTable :data="data.commandStats"
          ><ElTableColumn prop="name" label="命令" /><ElTableColumn
            prop="value"
            label="调用次数" /></ElTable
      ></ElCard> </template
  ></div>
</template>
<script setup lang="ts">
  import { fetchCacheInfo } from '@/api/monitor'
  import type { Entity } from '@/api/system/types'
  defineOptions({ name: 'MonitorCache' })
  const loading = ref(true),
    data = ref<Entity>({})
  const overview = computed(() => [
    { label: '缓存键数量', value: data.value.dbSize ?? 0 },
    { label: 'Redis 版本', value: data.value.info?.redis_version ?? '-' },
    { label: '运行天数', value: data.value.info?.uptime_in_days ?? 0 },
    { label: '内存占用', value: data.value.info?.used_memory_human ?? '-' }
  ])
  const info = computed(() => [
    { label: '客户端数量', value: data.value.info?.connected_clients },
    { label: '内存峰值', value: data.value.info?.used_memory_peak_human },
    { label: '网络入口', value: data.value.info?.total_net_input_bytes_human },
    { label: '网络出口', value: data.value.info?.total_net_output_bytes_human }
  ])
  onMounted(async () => {
    try {
      data.value = await fetchCacheInfo()
    } finally {
      loading.value = false
    }
  })
</script>
