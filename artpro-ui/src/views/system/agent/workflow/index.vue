<template>
  <div class="art-full-height">
    <SystemCrudPage
      title="Agent工作流"
      permission="system:agent:workflow"
      id-key="workflowId"
      :fields="fields"
      :list-fn="fetchAgentWorkflowList"
      :get-fn="fetchAgentWorkflow"
      :add-fn="addAgentWorkflow"
      :update-fn="updateAgentWorkflow"
      :remove-fn="removeAgentWorkflow"
      :status-fn="updateAgentWorkflow"
      :actions="actions"
      :defaults="defaults"
      drawer-size="860px"
    />
  </div>
</template>

<script setup lang="ts">
  import { ElMessageBox } from 'element-plus'
  import SystemCrudPage from '@/components/business/system-crud-page/index.vue'
  import {
    addAgentWorkflow,
    fetchAgentWorkflow,
    fetchAgentWorkflowList,
    removeAgentWorkflow,
    runAgentWorkflow,
    updateAgentWorkflow
  } from '@/api/system/agent'

  defineOptions({ name: 'SystemAgentWorkflow' })

  const statusOptions = [
    { label: '正常', value: '0' },
    { label: '停用', value: '1' }
  ]
  const defaults = {
    status: '0',
    version: 1,
    definitionJson: JSON.stringify(
      {
        nodes: [
          { id: 'input', type: 'input' },
          { id: 'output', type: 'output' }
        ]
      },
      null,
      2
    )
  }
  const fields = computed(() => [
    { prop: 'workflowName', label: '工作流名称', required: true, search: true },
    { prop: 'version', label: '版本', type: 'number', width: 90 },
    {
      prop: 'status',
      label: '状态',
      type: 'select',
      options: statusOptions,
      dict: statusOptions,
      required: true,
      search: true
    },
    {
      prop: 'definitionJson',
      label: '节点定义',
      table: false,
      span: 24,
      props: { type: 'textarea', rows: 12 }
    },
    { prop: 'remark', label: '备注', table: false, props: { type: 'textarea', rows: 3 } },
    { prop: 'createTime', label: '创建时间', form: false, minWidth: 170 }
  ])
  const actions = [
    {
      key: 'run',
      label: '运行',
      auth: 'system:agent:workflow:run',
      icon: 'ri:play-circle-line',
      handler: async (row: Record<string, any>) => {
        const input = await ElMessageBox.prompt('请输入工作流输入', '运行工作流', {
          confirmButtonText: '运行',
          cancelButtonText: '取消'
        })
        await runAgentWorkflow(row.workflowId, { input: input.value })
      }
    }
  ]
</script>
