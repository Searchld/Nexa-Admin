<template>
  <div class="art-full-height">
    <SystemCrudPage
      ref="page"
      title="知识库"
      permission="system:agent:kb"
      id-key="kbId"
      :fields="fields"
      :list-fn="fetchAgentKbList"
      :get-fn="fetchAgentKb"
      :add-fn="addAgentKb"
      :update-fn="updateAgentKb"
      :remove-fn="removeAgentKb"
      :status-fn="updateAgentKb"
      :actions="actions"
      :defaults="defaults"
      drawer-size="720px"
    />
    <ElDrawer v-model="docVisible" title="知识文档" size="860px">
      <ElUpload
        v-if="currentKbId"
        :auto-upload="false"
        :show-file-list="false"
        accept=".txt,.md,.pdf,.docx,.xlsx"
        :on-change="upload"
      >
        <ElButton type="primary">上传文档</ElButton>
      </ElUpload>
      <ElTable v-loading="docLoading" :data="docs" style="margin-top: 16px">
        <ElTableColumn prop="fileName" label="文件名" min-width="220" show-overflow-tooltip />
        <ElTableColumn prop="fileType" label="类型" width="90" />
        <ElTableColumn prop="parseStatus" label="解析状态" width="120" />
        <ElTableColumn prop="chunkCount" label="切片" width="90" />
        <ElTableColumn prop="errorMsg" label="错误信息" min-width="220" show-overflow-tooltip />
        <ElTableColumn prop="createTime" label="上传时间" width="170" />
        <ElTableColumn label="操作" width="150" align="right">
          <template #default="{ row }">
            <ElButton link type="primary" @click="reindex(row.docId)">重建</ElButton>
            <ElButton link type="danger" @click="removeDoc(row.docId)">删除</ElButton>
          </template>
        </ElTableColumn>
      </ElTable>
    </ElDrawer>
  </div>
</template>

<script setup lang="ts">
  import { ElMessageBox, type UploadFile } from 'element-plus'
  import SystemCrudPage from '@/components/business/system-crud-page/index.vue'
  import {
    addAgentKb,
    fetchAgentKb,
    fetchAgentKbDocuments,
    fetchAgentKbList,
    reindexAgentKbDocument,
    removeAgentKb,
    removeAgentKbDocument,
    updateAgentKb,
    uploadAgentKbDocument
  } from '@/api/system/agent'

  defineOptions({ name: 'SystemAgentKb' })

  const statusOptions = [
    { label: '正常', value: '0' },
    { label: '停用', value: '1' }
  ]
  const visibilityOptions = [
    { label: '私有', value: 'private' },
    { label: '部门', value: 'dept' },
    { label: '公开', value: 'public' }
  ]
  const defaults = { visibility: 'private', status: '0' }
  const fields = computed(() => [
    { prop: 'kbName', label: '知识库名称', required: true, search: true },
    {
      prop: 'visibility',
      label: '可见范围',
      type: 'select',
      options: visibilityOptions,
      dict: visibilityOptions,
      required: true,
      search: true
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
    { prop: 'docCount', label: '文档数', form: false, width: 100 },
    {
      prop: 'description',
      label: '描述',
      table: false,
      span: 24,
      props: { type: 'textarea', rows: 3 }
    },
    { prop: 'remark', label: '备注', table: false, props: { type: 'textarea', rows: 3 } },
    { prop: 'createTime', label: '创建时间', form: false, minWidth: 170 }
  ])
  const docVisible = ref(false)
  const docLoading = ref(false)
  const currentKbId = ref<number>()
  const docs = ref<Record<string, any>[]>([])
  const actions = [
    {
      key: 'documents',
      label: '文档',
      auth: 'system:agent:kb:list',
      icon: 'ri:file-list-3-line',
      handler: async (row: Record<string, any>) => {
        currentKbId.value = row.kbId
        docVisible.value = true
        await loadDocs()
      }
    }
  ]
  async function loadDocs() {
    if (!currentKbId.value) return
    docLoading.value = true
    try {
      docs.value = await fetchAgentKbDocuments(currentKbId.value)
    } finally {
      docLoading.value = false
    }
  }
  async function upload(file: UploadFile) {
    if (!currentKbId.value || !file.raw) return
    await uploadAgentKbDocument(currentKbId.value, file.raw)
    await loadDocs()
  }
  async function reindex(docId: number) {
    await reindexAgentKbDocument(docId)
    await loadDocs()
  }
  async function removeDoc(docId: number) {
    await ElMessageBox.confirm('确定删除该知识文档吗？', '提示', { type: 'warning' })
    await removeAgentKbDocument(docId)
    await loadDocs()
  }
</script>
