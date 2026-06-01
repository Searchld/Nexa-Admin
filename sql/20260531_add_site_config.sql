-- Art 前端站点配置。可重复执行。
update sys_config set config_value = 'image'
where config_key = 'sys.account.captchaType' and (config_value is null or config_value = '');
insert into sys_config(config_name, config_key, config_value, config_type, create_by, create_time, remark)
select '系统名称', 'site.name', 'Art Design Pro', 'Y', 'admin', sysdate(), 'Art 前端站点配置'
where not exists (select 1 from sys_config where config_key = 'site.name');
insert into sys_config(config_name, config_key, config_value, config_type, create_by, create_time, remark)
select '站点简介', 'site.description', '商业化中后台管理系统', 'Y', 'admin', sysdate(), 'Art 前端站点配置'
where not exists (select 1 from sys_config where config_key = 'site.description');
insert into sys_config(config_name, config_key, config_value, config_type, create_by, create_time, remark)
select '登录欢迎标题', 'site.login.title', '欢迎回来', 'Y', 'admin', sysdate(), 'Art 前端站点配置'
where not exists (select 1 from sys_config where config_key = 'site.login.title');
insert into sys_config(config_name, config_key, config_value, config_type, create_by, create_time, remark)
select '登录欢迎描述', 'site.login.description', '输入您的账号和密码登录', 'Y', 'admin', sysdate(), 'Art 前端站点配置'
where not exists (select 1 from sys_config where config_key = 'site.login.description');
insert into sys_config(config_name, config_key, config_value, config_type, create_by, create_time, remark)
select '登录页左侧标题', 'site.login-left-title', '专注用户体验', 'Y', 'admin', sysdate(), 'Art 前端站点配置'
where not exists (select 1 from sys_config where config_key = 'site.login-left-title');
insert into sys_config(config_name, config_key, config_value, config_type, create_by, create_time, remark)
select '登录页左侧描述', 'site.login-left-sub-title', '基于 Art Design Pro 与 RuoYi 构建', 'Y', 'admin', sysdate(), 'Art 前端站点配置'
where not exists (select 1 from sys_config where config_key = 'site.login-left-sub-title');
insert into sys_config(config_name, config_key, config_value, config_type, create_by, create_time, remark)
select '公共水印内容', 'site.watermark.content', '', 'Y', 'admin', sysdate(), 'Art 前端站点配置'
where not exists (select 1 from sys_config where config_key = 'site.watermark.content');
insert into sys_config(config_name, config_key, config_value, config_type, create_by, create_time, remark)
select '水印内容模式', 'site.watermark.mode', 'username', 'Y', 'admin', sysdate(), 'username/site/custom'
where not exists (select 1 from sys_config where config_key = 'site.watermark.mode');
insert into sys_config(config_name, config_key, config_value, config_type, create_by, create_time, remark)
select '水印叠加时间', 'site.watermark.show-time', 'false', 'Y', 'admin', sysdate(), 'Art 前端站点配置'
where not exists (select 1 from sys_config where config_key = 'site.watermark.show-time');
insert into sys_config(config_name, config_key, config_value, config_type, create_by, create_time, remark)
select '主题风格', 'ui.theme.mode', 'auto', 'Y', 'admin', sysdate(), 'auto/light/dark'
where not exists (select 1 from sys_config where config_key = 'ui.theme.mode');
insert into sys_config(config_name, config_key, config_value, config_type, create_by, create_time, remark)
select '菜单布局', 'ui.menu.layout', 'left', 'Y', 'admin', sysdate(), 'left/top/top-left/dual-menu'
where not exists (select 1 from sys_config where config_key = 'ui.menu.layout');
insert into sys_config(config_name, config_key, config_value, config_type, create_by, create_time, remark)
select '菜单风格', 'ui.menu.style', 'design', 'Y', 'admin', sysdate(), 'design/light/dark'
where not exists (select 1 from sys_config where config_key = 'ui.menu.style');
insert into sys_config(config_name, config_key, config_value, config_type, create_by, create_time, remark)
select '系统主题色', 'ui.theme.color', '#5D87FF', 'Y', 'admin', sysdate(), 'Art 前端站点配置'
where not exists (select 1 from sys_config where config_key = 'ui.theme.color');
insert into sys_config(config_name, config_key, config_value, config_type, create_by, create_time, remark)
select '盒子样式', 'ui.box.style', 'border', 'Y', 'admin', sysdate(), 'border/shadow'
where not exists (select 1 from sys_config where config_key = 'ui.box.style');
insert into sys_config(config_name, config_key, config_value, config_type, create_by, create_time, remark)
select '容器宽度', 'ui.container.width', '100%', 'Y', 'admin', sysdate(), '100%/1200px'
where not exists (select 1 from sys_config where config_key = 'ui.container.width');
insert into sys_config(config_name, config_key, config_value, config_type, create_by, create_time, remark)
select '开启公共水印', 'ui.watermark.enabled', 'false', 'Y', 'admin', sysdate(), 'Art 前端站点配置'
where not exists (select 1 from sys_config where config_key = 'ui.watermark.enabled');
insert into sys_config(config_name, config_key, config_value, config_type, create_by, create_time, remark)
select '开启多页签', 'ui.tabs.enabled', 'true', 'Y', 'admin', sysdate(), 'Art 前端站点配置'
where not exists (select 1 from sys_config where config_key = 'ui.tabs.enabled');
insert into sys_config(config_name, config_key, config_value, config_type, create_by, create_time, remark)
select '显示面包屑', 'ui.breadcrumb.enabled', 'true', 'Y', 'admin', sysdate(), 'Art 前端站点配置'
where not exists (select 1 from sys_config where config_key = 'ui.breadcrumb.enabled');
insert into sys_config(config_name, config_key, config_value, config_type, create_by, create_time, remark)
select '菜单手风琴', 'ui.menu.accordion', 'true', 'Y', 'admin', sysdate(), 'Art 前端站点配置'
where not exists (select 1 from sys_config where config_key = 'ui.menu.accordion');
insert into sys_config(config_name, config_key, config_value, config_type, create_by, create_time, remark)
select '访问令牌有效时长', 'security.access-token-hours', '2', 'Y', 'admin', sysdate(), '单位：小时'
where not exists (select 1 from sys_config where config_key = 'security.access-token-hours');
insert into sys_config(config_name, config_key, config_value, config_type, create_by, create_time, remark)
select '登录失败锁定阈值', 'security.max-failed-login-count', '5', 'Y', 'admin', sysdate(), 'Art 前端站点配置'
where not exists (select 1 from sys_config where config_key = 'security.max-failed-login-count');
insert into sys_config(config_name, config_key, config_value, config_type, create_by, create_time, remark)
select '账号锁定时长', 'security.account-lock-minutes', '10', 'Y', 'admin', sysdate(), '单位：分钟'
where not exists (select 1 from sys_config where config_key = 'security.account-lock-minutes');
insert into sys_config(config_name, config_key, config_value, config_type, create_by, create_time, remark)
select '密码最小长度', 'security.password-min-length', '5', 'Y', 'admin', sysdate(), 'Art 前端站点配置'
where not exists (select 1 from sys_config where config_key = 'security.password-min-length');
insert into sys_config(config_name, config_key, config_value, config_type, create_by, create_time, remark)
select '密码最大长度', 'security.password-max-length', '20', 'Y', 'admin', sysdate(), 'Art 前端站点配置'
where not exists (select 1 from sys_config where config_key = 'security.password-max-length');
insert into sys_config(config_name, config_key, config_value, config_type, create_by, create_time, remark)
select '密码要求大写字母', 'security.password-require-uppercase', 'false', 'Y', 'admin', sysdate(), 'Art 前端站点配置'
where not exists (select 1 from sys_config where config_key = 'security.password-require-uppercase');
insert into sys_config(config_name, config_key, config_value, config_type, create_by, create_time, remark)
select '密码要求小写字母', 'security.password-require-lowercase', 'false', 'Y', 'admin', sysdate(), 'Art 前端站点配置'
where not exists (select 1 from sys_config where config_key = 'security.password-require-lowercase');
insert into sys_config(config_name, config_key, config_value, config_type, create_by, create_time, remark)
select '密码要求数字', 'security.password-require-number', 'false', 'Y', 'admin', sysdate(), 'Art 前端站点配置'
where not exists (select 1 from sys_config where config_key = 'security.password-require-number');
insert into sys_config(config_name, config_key, config_value, config_type, create_by, create_time, remark)
select '密码要求特殊字符', 'security.password-require-special', 'false', 'Y', 'admin', sysdate(), 'Art 前端站点配置'
where not exists (select 1 from sys_config where config_key = 'security.password-require-special');
