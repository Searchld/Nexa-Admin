interface CrudField {
  prop: string
  label: string
  type?: string
  width?: number
  minWidth?: number
  required?: boolean
  hidden?: boolean
  table?: boolean
  form?: boolean
  search?: boolean
  span?: number
  options?: Array<Record<string, any>>
  dict?: Array<Record<string, any>>
  props?: Record<string, any>
  render?: any
}

export type SqModuleKey =
  | 'cars'
  | 'camera'
  | 'alert'
  | 'alertInfo'
  | 'alertReason'
  | 'team'
  | 'carsLogs'
  | 'carsOutLogs'
  | 'aCarsLogsHis'
  | 'ynUser'
  | 'ynUserXj'
  | 'ynWxUser'
  | 'ynWxDept'
  | 'ynWxSend'
  | 'ynTask'
  | 'ynSiren'
  | 'ynRfid'
  | 'ynRfidYdq'
  | 'ynRfidRecord'
  | 'ynCameraRecord'
  | 'ynLogsLevel'
  | 'ynLogsOut'

interface SqModuleConfig {
  title: string
  permission: string
  idKey?: string
  drawerSize?: string
  defaults?: Record<string, unknown>
  fields: CrudField[]
}

const auditFields: CrudField[] = [
  { prop: 'status', label: '状态', search: true, width: 100 },
  { prop: 'createTime', label: '创建时间', form: false, minWidth: 160 },
  { prop: 'updateTime', label: '更新时间', form: false, minWidth: 160 }
]

const logFields: CrudField[] = [
  { prop: 'name', label: '溜井名称', search: true, minWidth: 140 },
  { prop: 'cars', label: '车辆', search: true, minWidth: 120 },
  { prop: 'ctype', label: '车辆类型', search: true, minWidth: 120 },
  { prop: 'shitype', label: '矿种', search: true, minWidth: 120 },
  { prop: 'company', label: '中段', search: true, minWidth: 120 },
  { prop: 'fulls', label: '满载', minWidth: 100 },
  { prop: 'bigs', label: '大块', minWidth: 100 },
  { prop: 'yiwu', label: '异物', minWidth: 100 },
  { prop: 'water', label: '水', minWidth: 90 },
  { prop: 'mud', label: '泥', minWidth: 90 },
  { prop: 'createdate', label: '识别时间', form: false, minWidth: 160 },
  ...auditFields
]

export const sqModuleConfigs: Record<SqModuleKey, SqModuleConfig> = {
  cars: {
    title: '车辆管理',
    permission: 'cars',
    drawerSize: '760px',
    defaults: { status: '0', isDeleted: '0' },
    fields: [
      { prop: 'carsNum', label: '车辆编号', required: true, search: true, minWidth: 140 },
      { prop: 'ctype', label: '车辆类型', search: true, minWidth: 120 },
      { prop: 'carsXh', label: '车辆型号', search: true, minWidth: 140 },
      { prop: 'carsComp', label: '所属单位', minWidth: 140 },
      { prop: 'teamid', label: '所属工区', type: 'number', minWidth: 120 },
      { prop: 'rfid', label: 'RFID标签', minWidth: 140 },
      { prop: 'carsW', label: '载重(t)', minWidth: 110 },
      { prop: 'volume', label: '满载体积', minWidth: 120 },
      ...auditFields
    ]
  },
  camera: {
    title: '摄像头管理',
    permission: 'camera',
    drawerSize: '920px',
    defaults: { status: '0', isDeleted: '0' },
    fields: [
      { prop: 'lname', label: '溜井名称', required: true, search: true, minWidth: 150 },
      { prop: 'shitype', label: '矿种名称', search: true, minWidth: 130 },
      { prop: 'shitypename', label: '矿种种类', minWidth: 130 },
      { prop: 'company', label: '所属中段', search: true, minWidth: 140 },
      { prop: 'tname', label: '所属单位', minWidth: 130 },
      { prop: 'mine', label: '所属工区', minWidth: 130 },
      { prop: 'channel', label: '通道号', minWidth: 110 },
      { prop: 'serverUrl', label: '直播流通道', props: { type: 'textarea', rows: 3 }, minWidth: 220, span: 24 },
      { prop: 'serverUrl2', label: '直播流通道2', props: { type: 'textarea', rows: 3 }, minWidth: 220, span: 24 },
      { prop: 'allQuantity', label: '溜井高度', minWidth: 120 },
      { prop: 'rad', label: '溜井半径', minWidth: 120 },
      ...auditFields
    ]
  },
  alert: {
    title: '报警记录',
    permission: 'alert',
    drawerSize: '820px',
    fields: [
      { prop: 'name', label: '溜井名称', search: true, minWidth: 150 },
      { prop: 'ip', label: '摄像头IP', search: true, minWidth: 140 },
      { prop: 'statusName', label: '报警类型', minWidth: 150 },
      { prop: 'state', label: '处理状态', search: true, minWidth: 110 },
      { prop: 'img', label: '报警图片', table: false, span: 24 },
      { prop: 'handle', label: '处理记录', props: { type: 'textarea', rows: 3 }, minWidth: 180, span: 24 },
      { prop: 'handleTime', label: '处理时间', form: false, minWidth: 160 },
      ...auditFields
    ]
  },
  alertInfo: {
    title: '报警信息配置',
    permission: 'alertInfo',
    fields: [
      { prop: 'name', label: '名称', required: true, search: true, minWidth: 140 },
      { prop: 'level', label: '级别', search: true, minWidth: 100 },
      { prop: 'types', label: '类型', minWidth: 120 },
      { prop: 'voice', label: '语音', minWidth: 160 },
      { prop: 'text', label: '文本', props: { type: 'textarea', rows: 3 }, minWidth: 180, span: 24 },
      { prop: 'isSend', label: '是否发送', minWidth: 110 },
      { prop: 'isReceive', label: '是否接收', minWidth: 110 },
      { prop: 'isopen', label: '是否开启', minWidth: 110 },
      ...auditFields
    ]
  },
  alertReason: {
    title: '报警原因',
    permission: 'alertReason',
    fields: [
      { prop: 'alert', label: '报警ID', search: true, minWidth: 120 },
      { prop: 'reason', label: '报警原因', required: true, props: { type: 'textarea', rows: 3 }, minWidth: 220, span: 24 },
      { prop: 'createUserName', label: '创建人', form: false, minWidth: 120 },
      { prop: 'flag', label: '标识', minWidth: 100 },
      ...auditFields
    ]
  },
  team: {
    title: '施工团队',
    permission: 'team',
    defaults: { status: '0', isDeleted: '0' },
    fields: [
      { prop: 'tname', label: '所属单位', required: true, search: true, minWidth: 140 },
      { prop: 'mine', label: '所属工区', required: true, search: true, minWidth: 140 },
      { prop: 'tnameuser', label: '所属中段', search: true, minWidth: 140 },
      ...auditFields
    ]
  },
  carsLogs: { title: '车辆入库日志', permission: 'carsLogs', drawerSize: '900px', fields: logFields },
  carsOutLogs: { title: '车辆出库日志', permission: 'carsOutLogs', drawerSize: '900px', fields: logFields },
  aCarsLogsHis: { title: '历史车辆日志', permission: 'aCarsLogsHis', drawerSize: '900px', fields: logFields },
  ynUser: {
    title: 'AI报警记录',
    permission: 'ynUser',
    drawerSize: '860px',
    fields: [
      { prop: 'name', label: '名称', search: true, minWidth: 140 },
      { prop: 'ip', label: 'IP', search: true, minWidth: 140 },
      { prop: 'type', label: '类型', search: true, minWidth: 110 },
      { prop: 'scene', label: '场景', minWidth: 140 },
      { prop: 'status', label: '状态', search: true, minWidth: 100 },
      { prop: 'picture', label: '图片', table: false, span: 24 },
      { prop: 'video', label: '视频', table: false, span: 24 },
      { prop: 'instruction', label: '指令', minWidth: 160 },
      { prop: 'handle', label: '处理记录', props: { type: 'textarea', rows: 3 }, span: 24 },
      { prop: 'warningTime', label: '报警时间', form: false, minWidth: 160 },
      { prop: 'handleTime', label: '处理时间', form: false, minWidth: 160 }
    ]
  },
  ynUserXj: {
    title: '巡检报警记录',
    permission: 'ynUserXj',
    drawerSize: '860px',
    fields: [
      { prop: 'name', label: '名称', search: true, minWidth: 140 },
      { prop: 'ip', label: 'IP', search: true, minWidth: 140 },
      { prop: 'type', label: '类型', search: true, minWidth: 110 },
      { prop: 'scene', label: '场景', minWidth: 140 },
      { prop: 'status', label: '状态', search: true, minWidth: 100 },
      { prop: 'picture', label: '图片', table: false, span: 24 },
      { prop: 'video', label: '视频', table: false, span: 24 },
      { prop: 'instruction', label: '指令', minWidth: 160 },
      { prop: 'handle', label: '处理记录', props: { type: 'textarea', rows: 3 }, span: 24 },
      { prop: 'warningTime', label: '报警时间', form: false, minWidth: 160 },
      { prop: 'handleTime', label: '处理时间', form: false, minWidth: 160 }
    ]
  },
  ynWxUser: {
    title: '企业微信用户',
    permission: 'ynWxUser',
    drawerSize: '860px',
    fields: [
      { prop: 'id', label: 'ID', search: true, form: false, width: 90 },
      { prop: 'deptId', label: '部门ID', search: true, minWidth: 120 },
      { prop: 'username', label: '用户名', search: true, minWidth: 140 },
      { prop: 'nickName', label: '昵称', search: true, minWidth: 140 },
      { prop: 'gender', label: '性别', minWidth: 90 },
      { prop: 'phone', label: '手机号码', minWidth: 140 },
      { prop: 'email', label: '邮箱', minWidth: 160 },
      { prop: 'enabled', label: '状态', search: true, minWidth: 100 }
    ]
  },
  ynWxDept: {
    title: '企业微信部门',
    permission: 'ynWxDept',
    fields: [
      { prop: 'name', label: '部门名称', required: true, search: true, minWidth: 160 },
      { prop: 'pid', label: '父级ID', type: 'number', minWidth: 110 },
      { prop: 'subCount', label: '子部门数', type: 'number', minWidth: 110 },
      { prop: 'deptSort', label: '排序', type: 'number', minWidth: 100 },
      { prop: 'enabled', label: '启用', minWidth: 100 },
      { prop: 'type', label: '类型', minWidth: 120 }
    ]
  },
  ynWxSend: {
    title: '企业微信发送配置',
    permission: 'ynWxSend',
    fields: [
      { prop: 'types', label: '类型', type: 'number', search: true, minWidth: 100 },
      { prop: 'sendUser', label: '发送用户', search: true, minWidth: 160 },
      { prop: 'isSend', label: '是否发送', minWidth: 110 },
      { prop: 'level', label: '级别', minWidth: 100 },
      { prop: 'tname', label: '部门', minWidth: 140 },
      { prop: 'userName', label: '用户名', minWidth: 140 },
      { prop: 'deptId', label: '部门ID', minWidth: 120 },
      ...auditFields
    ]
  },
  ynTask: {
    title: '任务管理',
    permission: 'ynTask',
    fields: [
      { prop: 'name', label: '任务名称', required: true, search: true, minWidth: 160 },
      { prop: 'lname', label: '溜井名称', search: true, minWidth: 140 },
      { prop: 'channel', label: '通道', minWidth: 100 },
      { prop: 'status', label: '状态', search: true, minWidth: 100 },
      { prop: 'startTime', label: '开始时间', minWidth: 160 },
      { prop: 'endTime', label: '结束时间', minWidth: 160 },
      { prop: 'createTime', label: '创建时间', form: false, minWidth: 160 }
    ]
  },
  ynSiren: {
    title: '声光报警器',
    permission: 'ynSiren',
    fields: [
      { prop: 'name', label: '名称', search: true, minWidth: 140 },
      { prop: 'location', label: '位置', search: true, minWidth: 160 },
      { prop: 'ip', label: 'IP', search: true, minWidth: 140 },
      { prop: 'flag', label: '标识', minWidth: 100 },
      { prop: 'cameras', label: '摄像头', minWidth: 160 },
      { prop: 'volume', label: '音量', minWidth: 90 },
      { prop: 'isWarning', label: '报警中', minWidth: 100 },
      { prop: 'status', label: '状态', search: true, minWidth: 100 }
    ]
  },
  ynRfid: {
    title: 'RFID标签',
    permission: 'ynRfid',
    fields: [
      { prop: 'location', label: '位置', search: true, minWidth: 160 },
      { prop: 'tagId', label: '标签ID', search: true, minWidth: 150 },
      { prop: 'status', label: '状态', search: true, minWidth: 100 },
      { prop: 'mark', label: '备注', minWidth: 180 },
      { prop: 'parentId', label: '父级ID', type: 'number', minWidth: 110 },
      { prop: 'createTime', label: '创建时间', form: false, minWidth: 160 }
    ]
  },
  ynRfidYdq: {
    title: 'RFID阅读器',
    permission: 'ynRfidYdq',
    fields: [
      { prop: 'name', label: '名称', search: true, minWidth: 140 },
      { prop: 'location', label: '位置', search: true, minWidth: 160 },
      { prop: 'ip', label: 'IP', search: true, minWidth: 140 },
      { prop: 'username', label: '用户名', minWidth: 120 },
      { prop: 'psw', label: '密码', table: false },
      { prop: 'port', label: '端口', minWidth: 90 },
      { prop: 'tname', label: '部门', minWidth: 140 },
      { prop: 'status', label: '状态', search: true, minWidth: 100 },
      { prop: 'mark', label: '备注', minWidth: 180 }
    ]
  },
  ynRfidRecord: {
    title: 'RFID读取记录',
    permission: 'ynRfidRecord',
    fields: [
      { prop: 'ip', label: 'IP', search: true, minWidth: 140 },
      { prop: 'cid', label: '卡号', search: true, minWidth: 140 },
      { prop: 'tname', label: '部门', minWidth: 140 },
      { prop: 'createTime', label: '创建时间', form: false, minWidth: 160 }
    ]
  },
  ynCameraRecord: {
    title: '摄像头开关记录',
    permission: 'ynCameraRecord',
    fields: [
      { prop: 'channelId', label: '通道ID', search: true, minWidth: 130 },
      { prop: 'lname', label: '溜井名称', search: true, minWidth: 150 },
      { prop: 'isOpen', label: '是否开启', search: true, minWidth: 100 },
      { prop: 'carmip', label: '摄像头IP', minWidth: 140 },
      { prop: 'type', label: '类型', minWidth: 100 },
      { prop: 'createTime', label: '创建时间', form: false, minWidth: 160 }
    ]
  },
  ynLogsLevel: {
    title: '料位日志',
    permission: 'ynLogsLevel',
    fields: [
      { prop: 'dates', label: '日期', search: true, minWidth: 130 },
      { prop: 'lname', label: '溜井名称', search: true, minWidth: 150 },
      { prop: 'times', label: '次数', type: 'number', minWidth: 100 },
      { prop: 'cars', label: '车辆数', type: 'number', minWidth: 100 },
      { prop: 'heights', label: '高度', minWidth: 120 }
    ]
  },
  ynLogsOut: {
    title: '出矿日志',
    permission: 'ynLogsOut',
    drawerSize: '920px',
    fields: [
      { prop: 'ydNo', label: '运单号', search: true, minWidth: 150 },
      { prop: 'leader', label: '负责人', search: true, minWidth: 120 },
      { prop: 'plateNumber', label: '车牌号', search: true, minWidth: 140 },
      { prop: 'taskTime', label: '任务时间', minWidth: 140 },
      { prop: 'team', label: '班组', minWidth: 120 },
      { prop: 'vehicles', label: '车辆', minWidth: 120 },
      { prop: 'mineralType', label: '矿种', minWidth: 120 },
      { prop: 'wellingPoint', label: '放矿点', minWidth: 140 },
      { prop: 'unloadingPoint', label: '卸矿点', minWidth: 140 },
      { prop: 'totalTonnage', label: '总吨位', minWidth: 120 },
      { prop: 'progress', label: '进度', minWidth: 120 }
    ]
  }
}
