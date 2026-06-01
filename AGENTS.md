# AGENTS.md

## 项目定位

本项目是将 Art Design Pro / artpro-ui 前端 适配到 RuoYi 后台框架。

核心目标：

- 前端使用 Art Design Pro / artpro-ui
- 后端复用 RuoYi
- 尽量不改 RuoYi 后端业务逻辑
- 权限体系继续使用 RuoYi RBAC、菜单权限、按钮权限、数据权限
- 通过前端适配、菜单转换、页面补齐完成整合

---

## 最高优先级规则

### 1. 优先使用 Art 封装

开发页面时必须优先使用 Art 已有封装：

text src/components/* src/hooks/* src/layouts/* src/router/* src/store/* 

优先使用 Art 项目内已有组件、Hooks、布局、表格、表单、弹窗能力。

禁止在已有 Art 封装可用时，擅自重写：

text 表格 表单 弹窗 分页 搜索区域 布局 权限逻辑 上传组件 

### 2. 不要混用 UI 风格

禁止把页面写成 RuoYi-Vue 原始风格。

禁止优先使用裸 el-table + el-form + el-dialog 重写页面。

如果项目已有：

vue <ProTable /> <ProSearch /> <ProForm /> 

则必须优先使用这些封装。

Element Plus 只在 Art 没有对应封装时使用，例如：

vue <el-tree /> <el-tree-select /> <el-upload /> 

### 3. 后端尽量不改

禁止重写：

text RuoYi RBAC RuoYi JWT RuoYi 菜单权限 RuoYi 数据权限 RuoYi 用户/角色/菜单/部门/字典表结构 

优先复用：

text /system/* /monitor/* /tool/* /common/* 

禁止新增重复接口，例如：

text /system/user2/* /system/role2/* 

---

## 技术栈

### 前端

text Vue 3 TypeScript Vite Art Design Pro / artpro-ui Element Plus Pinia Vue Router 

### 后端

text RuoYi Spring Boot Spring Security JWT MyBatis PageHelper MySQL Redis 

---

## 总体适配策略

采用：

text Art 前端：backend 权限模式 RuoYi 后端：保留原有 RBAC / 菜单 / 权限 / 字典 / 日志 / 文件 / 定时任务 / 代码生成 适配方式：前端接口适配 + 菜单路由转换 + 缺失页面补齐 

不建议：

text 不重写 RuoYi 权限系统 不重新设计菜单表 不破坏 RuoYi 原接口路径 不把 Art 改成纯前端静态权限 不大规模修改后端 Controller 

---

## 环境配置

Art 前端必须使用后端权限模式：

env VITE_ACCESS_MODE=backend 

接口地址按实际后端配置：

env VITE_API_URL=http://localhost:8080 

---

## 登录与权限适配

### 登录

复用 RuoYi：

text POST /login 

RuoYi 默认返回：

json {   "code": 200,   "msg": "操作成功",   "token": "xxx" } 

前端需要兼容 token 字段。

请求头统一使用：

text Authorization: Bearer ${token} 

### 用户信息

复用 RuoYi：

text GET /getInfo 

RuoYi 返回：

json {   "user": {},   "roles": [],   "permissions": [] } 

前端映射为：

ts {   userInfo: user,   roles,   buttons: permissions } 

### 登出

复用：

text POST /logout 

登出后清理：

text token userInfo roles buttons menus tabs dynamicRoutes 

---

## 菜单路由适配

复用 RuoYi：

text GET /getRouters 

需要转换为 Art 动态路由结构：

ts {   id,   name,   path,   component,   meta: {     title,     icon,     keepAlive,     isHide,     authList   },   children } 

字段映射：

text menuId    -> id menuName  -> meta.title path      -> path component -> component icon      -> meta.icon visible   -> meta.isHide isCache   -> meta.keepAlive children  -> children 

菜单类型：

text M 目录 -> 父级菜单 C 菜单 -> 页面路由 F 按钮 -> 不生成路由，合并进父级 meta.authList 

按钮权限示例：

ts meta: {   authList: [     { title: '新增', authMark: 'system:user:add' },     { title: '修改', authMark: 'system:user:edit' },     { title: '删除', authMark: 'system:user:remove' }   ] } 

组件路径转换：

text system/user/index -> /system/user/index monitor/job/index -> /monitor/job/index tool/gen/index    -> /tool/gen/index 

动态组件加载必须使用 Vite 支持的方式：

ts const modules = import.meta.glob('/src/views/**/*.vue')  function loadView(component: string) {   return modules[`/src/views${component}.vue`] } 

禁止：

ts import('@/views/' + component) 

---

## 通用响应适配

普通响应兼容：

json {   "code": 200,   "msg": "操作成功",   "data": {} } 

分页响应兼容：

json {   "code": 200,   "msg": "查询成功",   "rows": [],   "total": 100 } 

Art 表格统一读取：

text rows total 

---

## 权限规范

按钮权限统一使用 RuoYi 权限标识：

vue v-auth="'system:user:add'" 

或者：

ts hasAuth('system:user:add') 

常见权限格式：

text system:user:list system:user:add system:user:edit system:user:remove system:role:list system:menu:list system:dept:list monitor:job:list tool:gen:list 

---

## 字典规范

复用 RuoYi 字典接口：

text GET /system/dict/data/type/{dictType} 

前端需要统一封装：

text 字典缓存 DictTag 字典下拉选项 状态标签渲染 

常用字典：

text sys_normal_disable sys_user_sex sys_show_hide sys_yes_no sys_job_status sys_job_group sys_oper_type sys_common_status 

---

## 文件上传与导入导出

上传接口：

text POST /common/upload 

要求：

text 字段名：file 请求头：Authorization: Bearer ${token} 

导出接口复用 RuoYi：

text POST /xxx/export 

前端统一封装：

ts download(url, params, filename) 

---

## 页面开发原则

开发任何页面前必须先搜索：

text 1. 项目已有页面实现 2. Art 已有组件 3. Art 已有 Hooks 4. 项目已有 API 封装 5. 项目已有权限实现 

找到已有实现时：

text 优先复用 禁止重复封装 禁止另起一套风格 

CRUD 页面统一结构：

text 查询区域 工具栏 表格 分页 新增/修改弹窗 

操作要求：

text 增删改成功后刷新列表 删除必须二次确认 表单提交前必须校验 列表查询支持重置 表格必须有 loading 按钮必须做权限控制 

---

## API 文件规划

建议按模块拆分：

text src/api/login.ts src/api/menu.ts src/api/system/user.ts src/api/system/role.ts src/api/system/menu.ts src/api/system/dept.ts src/api/system/post.ts src/api/system/dict.ts src/api/system/config.ts src/api/system/notice.ts src/api/monitor/online.ts src/api/monitor/job.ts src/api/monitor/operlog.ts src/api/monitor/logininfor.ts src/api/monitor/server.ts src/api/monitor/cache.ts src/api/tool/gen.ts 

---

## 需要补齐的页面范围

### 系统管理

text 用户管理 角色管理 菜单管理 部门管理 岗位管理 字典管理 参数设置 通知公告 

### 系统监控

text 在线用户 定时任务 操作日志 登录日志 服务监控 缓存监控 

### 系统工具

text 代码生成 API 文档 

### 个人中心

text 基本资料 修改密码 修改头像 

详细接口清单不要写在 AGENTS.md 中，放到：

text docs/ruoyi-art-plan.md 

---

## 开发顺序

### 第一阶段：基础可登录

text 1. 配置 VITE_ACCESS_MODE=backend 2. 适配 /login 3. 适配 /getInfo 4. 适配 /logout 5. 适配 token 请求头 6. 适配 /getRouters 菜单转换 7. 适配按钮权限 v-auth 

### 第二阶段：系统管理

text 用户管理 角色管理 菜单管理 部门管理 岗位管理 字典管理 参数设置 通知公告 

### 第三阶段：系统监控

text 在线用户 操作日志 登录日志 定时任务 服务监控 缓存监控 

### 第四阶段：系统工具

text 代码生成 API 文档 

### 第五阶段：公共能力

text 字典缓存 导入导出 文件上传 个人中心 图标选择器 富文本编辑器 

---

## 最终验收标准

text RuoYi 后端不改或极少改动 Art 前端可以正常登录 动态菜单来自 RuoYi 页面按钮权限来自 RuoYi permissions 系统管理页面可用 系统监控页面可用 系统工具页面可用 文件上传可用 导入导出可用 个人中心可用 刷新页面不 404 无权限按钮自动隐藏 后端权限注解继续生效 UI 风格保持 Art Design Pro 一致 
