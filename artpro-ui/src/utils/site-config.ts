import { reactive } from 'vue'
import AppConfig from '@/config'
import { fetchSiteConfig } from '@/api/system/config'
import { useSettingStore } from '@/store/modules/setting'
import { ContainerWidthEnum, MenuThemeEnum, MenuTypeEnum, SystemThemeEnum } from '@/enums/appEnum'

export const siteConfig = reactive<Record<string, string>>({
  'site.name': AppConfig.systemInfo.name,
  'site.description': '商业化中后台管理系统',
  'site.login.title': '欢迎回来',
  'site.login.description': '输入您的账号和密码登录',
  'site.login-left-title': '专注用户体验',
  'site.login-left-sub-title': '基于 Art Design Pro 与 RuoYi 构建',
  'site.watermark.content': '',
  'site.watermark.mode': 'username',
  'site.watermark.show-time': 'false'
})

export const getSiteConfig = (key: string, fallback = '') => siteConfig[key] || fallback

export async function loadSiteConfig() {
  Object.assign(siteConfig, await fetchSiteConfig())
  AppConfig.systemInfo.name = getSiteConfig('site.name', AppConfig.systemInfo.name)
  const settingStore = useSettingStore()
  const themeMode = getSiteConfig('ui.theme.mode')
  settingStore.$patch({
    menuType: (getSiteConfig('ui.menu.layout') || settingStore.menuType) as MenuTypeEnum,
    menuThemeType: (getSiteConfig('ui.menu.style') || settingStore.menuThemeType) as MenuThemeEnum,
    systemThemeType: (themeMode || settingStore.systemThemeType) as SystemThemeEnum,
    systemThemeMode: (themeMode || settingStore.systemThemeMode) as SystemThemeEnum,
    boxBorderMode:
      getSiteConfig('ui.box.style', settingStore.boxBorderMode ? 'border' : 'shadow') === 'border',
    containerWidth: (getSiteConfig('ui.container.width') ||
      settingStore.containerWidth) as ContainerWidthEnum,
    watermarkVisible:
      getSiteConfig('ui.watermark.enabled', String(settingStore.watermarkVisible)) === 'true',
    showWorkTab: getSiteConfig('ui.tabs.enabled', String(settingStore.showWorkTab)) === 'true',
    showCrumbs: getSiteConfig('ui.breadcrumb.enabled', String(settingStore.showCrumbs)) === 'true',
    uniqueOpened: getSiteConfig('ui.menu.accordion', String(settingStore.uniqueOpened)) === 'true'
  })
  const themeColor = getSiteConfig('ui.theme.color')
  if (themeColor) settingStore.setElementTheme(themeColor)
}
