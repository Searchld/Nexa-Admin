import { watch } from 'vue'
import { useSettingStore } from '@/store/modules/setting'
import { storeToRefs } from 'pinia'
import { updateSiteConfig } from '@/api/system/config'
import { SystemThemeEnum } from '@/enums/appEnum'

/**
 * 监听设置面板变更并同步到后端
 */
export function useSettingsSync() {
  const settingStore = useSettingStore()

  const {
    menuType,
    menuThemeType,
    systemThemeType,
    systemThemeMode,
    boxBorderMode,
    uniqueOpened,
    showWorkTab,
    showCrumbs,
    containerWidth,
    systemThemeColor,
    watermarkVisible,
    showSettingGuide,
    colorWeak
  } = storeToRefs(settingStore)

  /** 将 store 值映射为后端站点配置键值对 */
  const toSiteConfig = (): Record<string, string> => {
    const themeModeMap: Record<string, string> = {
      [SystemThemeEnum.LIGHT]: 'light',
      [SystemThemeEnum.DARK]: 'dark',
      [SystemThemeEnum.AUTO]: 'auto'
    }
    return {
      'ui.menu.layout': String(menuType.value || ''),
      'ui.menu.style': String(menuThemeType.value || ''),
      'ui.theme.mode': themeModeMap[systemThemeType.value] || 'auto',
      'ui.theme.color': systemThemeColor.value,
      'ui.box.style': boxBorderMode.value ? 'border' : 'shadow',
      'ui.container.width': String(containerWidth.value || '100%'),
      'ui.tabs.enabled': String(showWorkTab.value),
      'ui.breadcrumb.enabled': String(showCrumbs.value),
      'ui.menu.accordion': String(uniqueOpened.value),
      'ui.watermark.enabled': String(watermarkVisible.value)
    }
  }

  /** 防抖定时器 */
  let debounceTimer: ReturnType<typeof setTimeout> | null = null

  /** 批量同步到后端 */
  const syncToBackend = () => {
    if (debounceTimer) clearTimeout(debounceTimer)
    debounceTimer = setTimeout(async () => {
      try {
        await updateSiteConfig(toSiteConfig())
      } catch (e) {
        console.error('[SettingsSync] 同步设置到后端失败', e)
      }
    }, 800)
  }

  /** 启动监听 */
  const startSync = () => {
    watch(
      [menuType, menuThemeType, systemThemeType, systemThemeMode, boxBorderMode, uniqueOpened, showWorkTab, showCrumbs, containerWidth, systemThemeColor, watermarkVisible],
      syncToBackend,
      { deep: false }
    )
  }

  return { startSync }
}
