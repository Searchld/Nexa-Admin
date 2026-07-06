<template>
  <div class="sq-upload-page art-full-height">
    <ElCard class="upload-card">
      <template #header>
        <div class="card-header">
          <span>文件上传</span>
          <ElSegmented v-model="mode" :options="modeOptions" />
        </div>
      </template>
      <ElUpload drag :http-request="handleUpload" :show-file-list="false" class="upload-area">
        <ElIcon class="upload-icon"><UploadFilled /></ElIcon>
        <div class="upload-text">拖拽文件到这里，或点击选择文件</div>
        <template #tip>
          <div class="upload-tip">文件保存到旧 sq 上传接口，返回路径可用于旧业务表字段。</div>
        </template>
      </ElUpload>
      <ElDescriptions v-if="filePath" :column="1" border class="result-box">
        <ElDescriptionsItem label="上传结果">
          <ElLink :href="filePath" target="_blank" type="primary">{{ filePath }}</ElLink>
        </ElDescriptionsItem>
      </ElDescriptions>
    </ElCard>
  </div>
</template>

<script setup lang="ts">
  import { UploadFilled } from '@element-plus/icons-vue'
  import type { UploadRequestOptions } from 'element-plus'
  import { uploadSqFile } from '@/api/sq'

  defineOptions({ name: 'SqUpload' })

  const mode = ref<'file' | 'image'>('file')
  const filePath = ref('')
  const modeOptions = [
    { label: '普通文件', value: 'file' },
    { label: '图片', value: 'image' }
  ]

  async function handleUpload(options: UploadRequestOptions) {
    try {
      filePath.value = await uploadSqFile(options.file, mode.value === 'image')
      options.onSuccess(filePath.value)
    } catch (error) {
      options.onError(error as any)
    }
  }
</script>

<style scoped>
  .sq-upload-page {
    display: flex;
    min-height: 0;
    align-items: flex-start;
  }

  .upload-card {
    width: min(760px, 100%);
  }

  .card-header {
    display: flex;
    align-items: center;
    justify-content: space-between;
    gap: 16px;
  }

  .upload-area :deep(.el-upload-dragger) {
    min-height: 220px;
  }

  .upload-icon {
    margin-top: 24px;
    color: var(--el-color-primary);
    font-size: 48px;
  }

  .upload-text {
    margin-top: 12px;
    font-size: 15px;
  }

  .upload-tip {
    color: var(--el-text-color-secondary);
  }

  .result-box {
    margin-top: 20px;
  }
</style>
