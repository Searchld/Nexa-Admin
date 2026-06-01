<template>
  <div class="art-full-height">
    <ElTabs v-model="activeTab" class="config-tabs h-full">
      <ElTabPane label="站点配置" name="site">
        <ElCard>
          <ElTabs v-model="siteTab">
            <ElTabPane
              v-for="group in groups"
              :key="group.name"
              :label="group.label"
              :name="group.name"
            >
              <ArtForm
                v-model="siteForm"
                :items="group.items"
                :show-submit="false"
                :show-reset="false"
                label-width="130px"
              />
            </ElTabPane>
          </ElTabs>
          <ElButton
            v-if="hasAuth('system:config:edit')"
            type="primary"
            :loading="saving"
            @click="saveSite"
          >
            保存站点配置
          </ElButton>
        </ElCard>
      </ElTabPane>
      <ElTabPane label="参数列表" name="list">
        <SystemCrudPage
          ref="page"
          title="参数"
          permission="system:config"
          id-key="configId"
          :fields="fields"
          :list-fn="fetchConfigList"
          :get-fn="fetchConfig"
          :add-fn="addConfig"
          :update-fn="updateConfig"
          :remove-fn="removeConfig"
          export-url="/system/config/export"
          :defaults="{ configType: 'N' }"
        >
          <template #toolbar="{ refresh }">
            <ElButton v-if="hasAuth('system:config:remove')" @click="clear(refresh)"
              >刷新缓存</ElButton
            >
          </template>
        </SystemCrudPage>
      </ElTabPane>
    </ElTabs>
  </div>
</template>

<script setup lang="ts">
  import { ElMessage, ElMessageBox } from 'element-plus'
  import SystemCrudPage from '@/components/business/system-crud-page/index.vue'
  import {
    addConfig,
    fetchConfig,
    fetchConfigList,
    fetchSiteConfig,
    refreshConfigCache,
    removeConfig,
    updateConfig,
    updateSiteConfig
  } from '@/api/system/config'
  import { useDict } from '@/hooks/core/useDict'
  import { useAuth } from '@/hooks/core/useAuth'
  import { useSettingStore } from '@/store/modules/setting'
  import { loadSiteConfig } from '@/utils/site-config'
  import { ContainerWidthEnum, MenuThemeEnum, MenuTypeEnum, SystemThemeEnum } from '@/enums/appEnum'

  defineOptions({ name: 'SystemConfig' })
  const { hasAuth } = useAuth()
  const { dict } = useDict('sys_yes_no')
  const settingStore = useSettingStore()
  const activeTab = ref('site'),
    siteTab = ref('identity'),
    saving = ref(false)
  const siteForm = reactive<Record<string, any>>({})
  const keyOf = (key: string) => key.replaceAll('.', '__').replaceAll('-', '_')
  const option = (label: string, value: string) => ({ label, value })
  const field = (key: string, label: string, type = 'input', props: Record<string, any> = {}) => ({
    key: keyOf(key),
    label,
    type,
    span: 12,
    props: { clearable: true, ...props }
  })
  const yesNo = [option('是', 'true'), option('否', 'false')]
  const groups = [
    {
      name: 'identity',
      label: '系统标识',
      items: [
        field('site.name', '系统名称'),
        field('site.description', '站点简介'),
        field('site.login.title', '登录欢迎标题'),
        field('site.login.description', '登录欢迎描述'),
        field('site.login-left-title', '登录左侧标题'),
        field('site.login-left-sub-title', '登录左侧描述'),
        field('site.watermark.mode', '水印内容', 'select', {
          options: [
            option('当前用户名', 'username'),
            option('站点名称', 'site'),
            option('自定义文本', 'custom')
          ]
        }),
        field('site.watermark.content', '自定义水印文本'),
        field('site.watermark.show-time', '叠加当前时间', 'select', { options: yesNo })
      ]
    },
    {
      name: 'appearance',
      label: '界面风格',
      items: [
        field('ui.theme.mode', '主题风格', 'select', {
          options: [option('跟随系统', 'auto'), option('亮色', 'light'), option('暗色', 'dark')]
        }),
        field('ui.menu.layout', '菜单布局', 'select', {
          options: [
            option('左侧菜单', 'left'),
            option('顶部菜单', 'top'),
            option('顶部 + 左侧', 'top-left'),
            option('双栏菜单', 'dual-menu')
          ]
        }),
        field('ui.menu.style', '菜单风格', 'select', {
          options: [option('设计风格', 'design'), option('亮色', 'light'), option('暗色', 'dark')]
        }),
        field('ui.theme.color', '系统主题色'),
        field('ui.box.style', '盒子样式', 'select', {
          options: [option('边框', 'border'), option('阴影', 'shadow')]
        }),
        field('ui.container.width', '容器宽度', 'select', {
          options: [option('全屏', '100%'), option('定宽', '1200px')]
        }),
        field('ui.watermark.enabled', '公共水印', 'select', { options: yesNo }),
        field('ui.tabs.enabled', '多页签', 'select', { options: yesNo }),
        field('ui.breadcrumb.enabled', '面包屑', 'select', { options: yesNo }),
        field('ui.menu.accordion', '菜单手风琴', 'select', { options: yesNo })
      ]
    },
    {
      name: 'security',
      label: '登录与安全',
      items: [
        field('sys.account.captchaType', '验证码类型', 'select', {
          options: [option('滑块验证码', 'slider'), option('图片验证码', 'image')]
        }),
        field('sys.account.registerUser', '开放用户注册', 'select', { options: yesNo }),
        field('security.access-token-hours', '令牌有效时长（小时）', 'number'),
        field('security.max-failed-login-count', '失败锁定阈值', 'number'),
        field('security.account-lock-minutes', '账号锁定时长（分钟）', 'number'),
        field('security.password-min-length', '密码最小长度', 'number'),
        field('security.password-max-length', '密码最大长度', 'number'),
        field('security.password-require-uppercase', '要求大写字母', 'select', { options: yesNo }),
        field('security.password-require-lowercase', '要求小写字母', 'select', { options: yesNo }),
        field('security.password-require-number', '要求数字', 'select', { options: yesNo }),
        field('security.password-require-special', '要求特殊字符', 'select', { options: yesNo })
      ]
    }
  ]
  const defaults: Record<string, string> = {
    'site.name': 'Art Design Pro',
    'site.description': '商业化中后台管理系统',
    'site.login.title': '欢迎回来',
    'site.login.description': '输入您的账号和密码登录',
    'site.login-left-title': '专注用户体验',
    'site.login-left-sub-title': '基于 Art Design Pro 与 RuoYi 构建',
    'site.watermark.content': '',
    'site.watermark.mode': 'username',
    'site.watermark.show-time': 'false',
    'ui.theme.mode': 'auto',
    'ui.menu.layout': 'left',
    'ui.menu.style': 'design',
    'ui.theme.color': '#5D87FF',
    'ui.box.style': 'border',
    'ui.container.width': '100%',
    'ui.watermark.enabled': 'false',
    'ui.tabs.enabled': 'true',
    'ui.breadcrumb.enabled': 'true',
    'ui.menu.accordion': 'true',
    'sys.account.captchaType': 'slider',
    'sys.account.registerUser': 'false',
    'security.access-token-hours': '2',
    'security.max-failed-login-count': '5',
    'security.account-lock-minutes': '10',
    'security.password-min-length': '5',
    'security.password-max-length': '20',
    'security.password-require-uppercase': 'false',
    'security.password-require-lowercase': 'false',
    'security.password-require-number': 'false',
    'security.password-require-special': 'false'
  }
  const originalKeys = groups
    .flatMap((group) => group.items)
    .map((item) => {
      const match = Object.keys(defaults).find((key) => keyOf(key) === item.key)
      return match!
    })
  async function loadSite() {
    const received = await fetchSiteConfig()
    const values = Object.fromEntries(
      Object.entries(defaults).map(([key, defaultValue]) => [key, received[key] || defaultValue])
    )
    originalKeys.forEach((key) => {
      const value = values[key]
      siteForm[keyOf(key)] =
        key.startsWith('security.') && !key.includes('require-') ? Number(value) : value
    })
  }
  async function saveSite() {
    saving.value = true
    try {
      const values = Object.fromEntries(
        originalKeys.map((key) => [key, String(siteForm[keyOf(key)] ?? '')])
      )
      await updateSiteConfig(values)
      settingStore.$patch({
        menuType: values['ui.menu.layout'] as MenuTypeEnum,
        menuThemeType: values['ui.menu.style'] as MenuThemeEnum,
        systemThemeType: values['ui.theme.mode'] as SystemThemeEnum,
        systemThemeMode: values['ui.theme.mode'] as SystemThemeEnum,
        boxBorderMode: values['ui.box.style'] === 'border',
        containerWidth: values['ui.container.width'] as ContainerWidthEnum,
        watermarkVisible: values['ui.watermark.enabled'] === 'true',
        showWorkTab: values['ui.tabs.enabled'] === 'true',
        showCrumbs: values['ui.breadcrumb.enabled'] === 'true',
        uniqueOpened: values['ui.menu.accordion'] === 'true'
      })
      settingStore.setElementTheme(values['ui.theme.color'])
      await loadSiteConfig()
      ElMessage.success('站点配置已保存')
    } finally {
      saving.value = false
    }
  }
  const fields = computed(() => [
    { prop: 'configName', label: '参数名称', required: true, search: true },
    { prop: 'configKey', label: '参数键名', required: true, search: true },
    { prop: 'configValue', label: '参数键值', required: true },
    {
      prop: 'configType',
      label: '系统内置',
      type: 'select',
      options: dict.sys_yes_no,
      dict: dict.sys_yes_no,
      search: true
    },
    { prop: 'remark', label: '备注', table: false },
    { prop: 'createTime', label: '创建时间', form: false }
  ])
  async function clear(refresh: () => void) {
    await ElMessageBox.confirm('确定刷新参数缓存吗？', '提示', { type: 'warning' })
    await refreshConfigCache()
    refresh()
  }
  onMounted(loadSite)
</script>

<style scoped>
  .config-tabs {
    display: flex;
    flex-direction: column;
    min-height: 0;
  }

  .config-tabs :deep(.el-tabs__content) {
    flex: 1;
    min-height: 0;
    overflow: hidden;
  }

  .config-tabs :deep(.el-tab-pane) {
    height: 100%;
    min-height: 0;
  }

  .config-tabs :deep(.system-crud-page) {
    height: 100%;
  }
</style>
