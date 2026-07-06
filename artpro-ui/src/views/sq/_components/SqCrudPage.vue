<template>
  <div class="art-full-height">
    <SystemCrudPage
      :title="config.title"
      :permission="config.permission"
      :id-key="config.idKey || 'id'"
      :fields="config.fields"
      :list-fn="api.list"
      :get-fn="api.get"
      :add-fn="api.add"
      :update-fn="api.update"
      :remove-fn="api.remove"
      :export-url="api.exportUrl"
      :defaults="config.defaults || {}"
      :drawer-size="config.drawerSize || '760px'"
      remove-permission="del"
      export-permission="list"
    />
  </div>
</template>

<script setup lang="ts">
  import SystemCrudPage from '@/components/business/system-crud-page/index.vue'
  import { sqApis } from '@/api/sq'
  import { sqModuleConfigs, type SqModuleKey } from '../config'

  const props = defineProps<{ moduleKey: SqModuleKey }>()
  const config = computed(() => sqModuleConfigs[props.moduleKey])
  const api = computed(() => sqApis[props.moduleKey])
</script>
