-- 旧 sq 模块迁移到 RuoYi Business。可重复执行。
-- 菜单仅初始化权限标识，页面迁移到 Art 后可继续补 component/path。
set @parent_id := 2600;
insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select @parent_id, '旧系统SQ', 0, 99, 'sq', '', '', '', 1, 0, 'M', '0', '0', '', 'tree', 'admin', sysdate(), '旧系统SQ模块目录'
where not exists (select 1 from sys_menu where menu_id = @parent_id or menu_name = '旧系统SQ');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2601, 'aCarsLogsHis:add', @parent_id, 1, '', '', '', '', 1, 0, 'F', '0', '0', 'aCarsLogsHis:add', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'aCarsLogsHis:add');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2602, 'aCarsLogsHis:del', @parent_id, 2, '', '', '', '', 1, 0, 'F', '0', '0', 'aCarsLogsHis:del', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'aCarsLogsHis:del');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2603, 'aCarsLogsHis:edit', @parent_id, 3, '', '', '', '', 1, 0, 'F', '0', '0', 'aCarsLogsHis:edit', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'aCarsLogsHis:edit');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2604, 'aCarsLogsHis:list', @parent_id, 4, '', '', '', '', 1, 0, 'F', '0', '0', 'aCarsLogsHis:list', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'aCarsLogsHis:list');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2605, 'alert:add', @parent_id, 5, '', '', '', '', 1, 0, 'F', '0', '0', 'alert:add', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'alert:add');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2606, 'alert:del', @parent_id, 6, '', '', '', '', 1, 0, 'F', '0', '0', 'alert:del', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'alert:del');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2607, 'alert:edit', @parent_id, 7, '', '', '', '', 1, 0, 'F', '0', '0', 'alert:edit', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'alert:edit');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2608, 'alert:list', @parent_id, 8, '', '', '', '', 1, 0, 'F', '0', '0', 'alert:list', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'alert:list');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2609, 'alertInfo:add', @parent_id, 9, '', '', '', '', 1, 0, 'F', '0', '0', 'alertInfo:add', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'alertInfo:add');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2610, 'alertInfo:del', @parent_id, 10, '', '', '', '', 1, 0, 'F', '0', '0', 'alertInfo:del', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'alertInfo:del');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2611, 'alertInfo:edit', @parent_id, 11, '', '', '', '', 1, 0, 'F', '0', '0', 'alertInfo:edit', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'alertInfo:edit');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2612, 'alertInfo:list', @parent_id, 12, '', '', '', '', 1, 0, 'F', '0', '0', 'alertInfo:list', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'alertInfo:list');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2613, 'alertReason:add', @parent_id, 13, '', '', '', '', 1, 0, 'F', '0', '0', 'alertReason:add', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'alertReason:add');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2614, 'alertReason:del', @parent_id, 14, '', '', '', '', 1, 0, 'F', '0', '0', 'alertReason:del', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'alertReason:del');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2615, 'alertReason:edit', @parent_id, 15, '', '', '', '', 1, 0, 'F', '0', '0', 'alertReason:edit', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'alertReason:edit');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2616, 'alertReason:list', @parent_id, 16, '', '', '', '', 1, 0, 'F', '0', '0', 'alertReason:list', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'alertReason:list');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2617, 'camera:add', @parent_id, 17, '', '', '', '', 1, 0, 'F', '0', '0', 'camera:add', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'camera:add');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2618, 'camera:del', @parent_id, 18, '', '', '', '', 1, 0, 'F', '0', '0', 'camera:del', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'camera:del');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2619, 'camera:edit', @parent_id, 19, '', '', '', '', 1, 0, 'F', '0', '0', 'camera:edit', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'camera:edit');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2620, 'camera:list', @parent_id, 20, '', '', '', '', 1, 0, 'F', '0', '0', 'camera:list', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'camera:list');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2621, 'cars:add', @parent_id, 21, '', '', '', '', 1, 0, 'F', '0', '0', 'cars:add', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'cars:add');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2622, 'cars:del', @parent_id, 22, '', '', '', '', 1, 0, 'F', '0', '0', 'cars:del', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'cars:del');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2623, 'cars:edit', @parent_id, 23, '', '', '', '', 1, 0, 'F', '0', '0', 'cars:edit', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'cars:edit');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2624, 'cars:list', @parent_id, 24, '', '', '', '', 1, 0, 'F', '0', '0', 'cars:list', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'cars:list');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2625, 'carsLogs:add', @parent_id, 25, '', '', '', '', 1, 0, 'F', '0', '0', 'carsLogs:add', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'carsLogs:add');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2626, 'carsLogs:del', @parent_id, 26, '', '', '', '', 1, 0, 'F', '0', '0', 'carsLogs:del', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'carsLogs:del');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2627, 'carsLogs:edit', @parent_id, 27, '', '', '', '', 1, 0, 'F', '0', '0', 'carsLogs:edit', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'carsLogs:edit');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2628, 'carsLogs:list', @parent_id, 28, '', '', '', '', 1, 0, 'F', '0', '0', 'carsLogs:list', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'carsLogs:list');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2629, 'carsOutLogs:add', @parent_id, 29, '', '', '', '', 1, 0, 'F', '0', '0', 'carsOutLogs:add', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'carsOutLogs:add');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2630, 'carsOutLogs:del', @parent_id, 30, '', '', '', '', 1, 0, 'F', '0', '0', 'carsOutLogs:del', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'carsOutLogs:del');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2631, 'carsOutLogs:edit', @parent_id, 31, '', '', '', '', 1, 0, 'F', '0', '0', 'carsOutLogs:edit', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'carsOutLogs:edit');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2632, 'carsOutLogs:list', @parent_id, 32, '', '', '', '', 1, 0, 'F', '0', '0', 'carsOutLogs:list', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'carsOutLogs:list');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2633, 'materialLevel:carsNum', @parent_id, 33, '', '', '', '', 1, 0, 'F', '0', '0', 'materialLevel:carsNum', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'materialLevel:carsNum');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2634, 'materialLevel:countNum', @parent_id, 34, '', '', '', '', 1, 0, 'F', '0', '0', 'materialLevel:countNum', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'materialLevel:countNum');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2635, 'materialLevel:edit', @parent_id, 35, '', '', '', '', 1, 0, 'F', '0', '0', 'materialLevel:edit', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'materialLevel:edit');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2636, 'materialLevel:list', @parent_id, 36, '', '', '', '', 1, 0, 'F', '0', '0', 'materialLevel:list', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'materialLevel:list');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2637, 'materialLevel:teamNum', @parent_id, 37, '', '', '', '', 1, 0, 'F', '0', '0', 'materialLevel:teamNum', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'materialLevel:teamNum');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2638, 'nvr:edit', @parent_id, 38, '', '', '', '', 1, 0, 'F', '0', '0', 'nvr:edit', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'nvr:edit');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2639, 'nvr:list', @parent_id, 39, '', '', '', '', 1, 0, 'F', '0', '0', 'nvr:list', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'nvr:list');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2640, 'team:add', @parent_id, 40, '', '', '', '', 1, 0, 'F', '0', '0', 'team:add', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'team:add');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2641, 'team:del', @parent_id, 41, '', '', '', '', 1, 0, 'F', '0', '0', 'team:del', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'team:del');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2642, 'team:edit', @parent_id, 42, '', '', '', '', 1, 0, 'F', '0', '0', 'team:edit', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'team:edit');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2643, 'team:list', @parent_id, 43, '', '', '', '', 1, 0, 'F', '0', '0', 'team:list', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'team:list');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2644, 'ynCameraRecord:add', @parent_id, 44, '', '', '', '', 1, 0, 'F', '0', '0', 'ynCameraRecord:add', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'ynCameraRecord:add');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2645, 'ynCameraRecord:del', @parent_id, 45, '', '', '', '', 1, 0, 'F', '0', '0', 'ynCameraRecord:del', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'ynCameraRecord:del');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2646, 'ynCameraRecord:edit', @parent_id, 46, '', '', '', '', 1, 0, 'F', '0', '0', 'ynCameraRecord:edit', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'ynCameraRecord:edit');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2647, 'ynCameraRecord:list', @parent_id, 47, '', '', '', '', 1, 0, 'F', '0', '0', 'ynCameraRecord:list', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'ynCameraRecord:list');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2648, 'ynLogsLevel:add', @parent_id, 48, '', '', '', '', 1, 0, 'F', '0', '0', 'ynLogsLevel:add', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'ynLogsLevel:add');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2649, 'ynLogsLevel:del', @parent_id, 49, '', '', '', '', 1, 0, 'F', '0', '0', 'ynLogsLevel:del', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'ynLogsLevel:del');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2650, 'ynLogsLevel:edit', @parent_id, 50, '', '', '', '', 1, 0, 'F', '0', '0', 'ynLogsLevel:edit', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'ynLogsLevel:edit');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2651, 'ynLogsLevel:list', @parent_id, 51, '', '', '', '', 1, 0, 'F', '0', '0', 'ynLogsLevel:list', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'ynLogsLevel:list');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2652, 'ynLogsOut:add', @parent_id, 52, '', '', '', '', 1, 0, 'F', '0', '0', 'ynLogsOut:add', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'ynLogsOut:add');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2653, 'ynLogsOut:del', @parent_id, 53, '', '', '', '', 1, 0, 'F', '0', '0', 'ynLogsOut:del', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'ynLogsOut:del');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2654, 'ynLogsOut:edit', @parent_id, 54, '', '', '', '', 1, 0, 'F', '0', '0', 'ynLogsOut:edit', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'ynLogsOut:edit');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2655, 'ynLogsOut:list', @parent_id, 55, '', '', '', '', 1, 0, 'F', '0', '0', 'ynLogsOut:list', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'ynLogsOut:list');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2656, 'ynRfid:add', @parent_id, 56, '', '', '', '', 1, 0, 'F', '0', '0', 'ynRfid:add', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'ynRfid:add');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2657, 'ynRfid:del', @parent_id, 57, '', '', '', '', 1, 0, 'F', '0', '0', 'ynRfid:del', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'ynRfid:del');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2658, 'ynRfid:edit', @parent_id, 58, '', '', '', '', 1, 0, 'F', '0', '0', 'ynRfid:edit', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'ynRfid:edit');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2659, 'ynRfid:list', @parent_id, 59, '', '', '', '', 1, 0, 'F', '0', '0', 'ynRfid:list', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'ynRfid:list');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2660, 'ynRfidRecord:add', @parent_id, 60, '', '', '', '', 1, 0, 'F', '0', '0', 'ynRfidRecord:add', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'ynRfidRecord:add');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2661, 'ynRfidRecord:del', @parent_id, 61, '', '', '', '', 1, 0, 'F', '0', '0', 'ynRfidRecord:del', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'ynRfidRecord:del');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2662, 'ynRfidRecord:edit', @parent_id, 62, '', '', '', '', 1, 0, 'F', '0', '0', 'ynRfidRecord:edit', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'ynRfidRecord:edit');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2663, 'ynRfidRecord:list', @parent_id, 63, '', '', '', '', 1, 0, 'F', '0', '0', 'ynRfidRecord:list', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'ynRfidRecord:list');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2664, 'ynRfidYdq:add', @parent_id, 64, '', '', '', '', 1, 0, 'F', '0', '0', 'ynRfidYdq:add', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'ynRfidYdq:add');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2665, 'ynRfidYdq:del', @parent_id, 65, '', '', '', '', 1, 0, 'F', '0', '0', 'ynRfidYdq:del', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'ynRfidYdq:del');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2666, 'ynRfidYdq:edit', @parent_id, 66, '', '', '', '', 1, 0, 'F', '0', '0', 'ynRfidYdq:edit', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'ynRfidYdq:edit');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2667, 'ynRfidYdq:list', @parent_id, 67, '', '', '', '', 1, 0, 'F', '0', '0', 'ynRfidYdq:list', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'ynRfidYdq:list');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2668, 'ynSiren:add', @parent_id, 68, '', '', '', '', 1, 0, 'F', '0', '0', 'ynSiren:add', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'ynSiren:add');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2669, 'ynSiren:del', @parent_id, 69, '', '', '', '', 1, 0, 'F', '0', '0', 'ynSiren:del', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'ynSiren:del');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2670, 'ynSiren:edit', @parent_id, 70, '', '', '', '', 1, 0, 'F', '0', '0', 'ynSiren:edit', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'ynSiren:edit');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2671, 'ynSiren:list', @parent_id, 71, '', '', '', '', 1, 0, 'F', '0', '0', 'ynSiren:list', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'ynSiren:list');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2672, 'ynTask:add', @parent_id, 72, '', '', '', '', 1, 0, 'F', '0', '0', 'ynTask:add', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'ynTask:add');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2673, 'ynTask:del', @parent_id, 73, '', '', '', '', 1, 0, 'F', '0', '0', 'ynTask:del', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'ynTask:del');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2674, 'ynTask:edit', @parent_id, 74, '', '', '', '', 1, 0, 'F', '0', '0', 'ynTask:edit', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'ynTask:edit');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2675, 'ynTask:list', @parent_id, 75, '', '', '', '', 1, 0, 'F', '0', '0', 'ynTask:list', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'ynTask:list');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2676, 'ynUser:add', @parent_id, 76, '', '', '', '', 1, 0, 'F', '0', '0', 'ynUser:add', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'ynUser:add');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2677, 'ynUser:del', @parent_id, 77, '', '', '', '', 1, 0, 'F', '0', '0', 'ynUser:del', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'ynUser:del');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2678, 'ynUser:edit', @parent_id, 78, '', '', '', '', 1, 0, 'F', '0', '0', 'ynUser:edit', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'ynUser:edit');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2679, 'ynUser:list', @parent_id, 79, '', '', '', '', 1, 0, 'F', '0', '0', 'ynUser:list', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'ynUser:list');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2680, 'ynUserXj:add', @parent_id, 80, '', '', '', '', 1, 0, 'F', '0', '0', 'ynUserXj:add', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'ynUserXj:add');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2681, 'ynUserXj:del', @parent_id, 81, '', '', '', '', 1, 0, 'F', '0', '0', 'ynUserXj:del', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'ynUserXj:del');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2682, 'ynUserXj:edit', @parent_id, 82, '', '', '', '', 1, 0, 'F', '0', '0', 'ynUserXj:edit', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'ynUserXj:edit');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2683, 'ynUserXj:list', @parent_id, 83, '', '', '', '', 1, 0, 'F', '0', '0', 'ynUserXj:list', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'ynUserXj:list');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2684, 'ynWxDept:add', @parent_id, 84, '', '', '', '', 1, 0, 'F', '0', '0', 'ynWxDept:add', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'ynWxDept:add');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2685, 'ynWxDept:del', @parent_id, 85, '', '', '', '', 1, 0, 'F', '0', '0', 'ynWxDept:del', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'ynWxDept:del');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2686, 'ynWxDept:edit', @parent_id, 86, '', '', '', '', 1, 0, 'F', '0', '0', 'ynWxDept:edit', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'ynWxDept:edit');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2687, 'ynWxDept:list', @parent_id, 87, '', '', '', '', 1, 0, 'F', '0', '0', 'ynWxDept:list', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'ynWxDept:list');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2688, 'ynWxSend:add', @parent_id, 88, '', '', '', '', 1, 0, 'F', '0', '0', 'ynWxSend:add', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'ynWxSend:add');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2689, 'ynWxSend:del', @parent_id, 89, '', '', '', '', 1, 0, 'F', '0', '0', 'ynWxSend:del', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'ynWxSend:del');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2690, 'ynWxSend:edit', @parent_id, 90, '', '', '', '', 1, 0, 'F', '0', '0', 'ynWxSend:edit', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'ynWxSend:edit');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2691, 'ynWxSend:list', @parent_id, 91, '', '', '', '', 1, 0, 'F', '0', '0', 'ynWxSend:list', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'ynWxSend:list');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2692, 'ynWxUser:add', @parent_id, 92, '', '', '', '', 1, 0, 'F', '0', '0', 'ynWxUser:add', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'ynWxUser:add');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2693, 'ynWxUser:del', @parent_id, 93, '', '', '', '', 1, 0, 'F', '0', '0', 'ynWxUser:del', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'ynWxUser:del');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2694, 'ynWxUser:edit', @parent_id, 94, '', '', '', '', 1, 0, 'F', '0', '0', 'ynWxUser:edit', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'ynWxUser:edit');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2695, 'ynWxUser:list', @parent_id, 95, '', '', '', '', 1, 0, 'F', '0', '0', 'ynWxUser:list', '#', 'admin', sysdate(), '旧系统SQ按钮权限'
where not exists (select 1 from sys_menu where perms = 'ynWxUser:list');

insert into sys_config(config_name, config_key, config_value, config_type, create_by, create_time, remark)
select 'SQ迁移配置-sq.mqtt.enabled', 'sq.mqtt.enabled', 'false', 'Y', 'admin', sysdate(), '旧SQ模块外部集成配置'
where not exists (select 1 from sys_config where config_key = 'sq.mqtt.enabled');

insert into sys_config(config_name, config_key, config_value, config_type, create_by, create_time, remark)
select 'SQ迁移配置-sq.mqtt.url', 'sq.mqtt.url', '', 'Y', 'admin', sysdate(), '旧SQ模块外部集成配置'
where not exists (select 1 from sys_config where config_key = 'sq.mqtt.url');

insert into sys_config(config_name, config_key, config_value, config_type, create_by, create_time, remark)
select 'SQ迁移配置-sq.mqtt.username', 'sq.mqtt.username', '', 'Y', 'admin', sysdate(), '旧SQ模块外部集成配置'
where not exists (select 1 from sys_config where config_key = 'sq.mqtt.username');

insert into sys_config(config_name, config_key, config_value, config_type, create_by, create_time, remark)
select 'SQ迁移配置-sq.mqtt.password', 'sq.mqtt.password', '', 'Y', 'admin', sysdate(), '旧SQ模块外部集成配置'
where not exists (select 1 from sys_config where config_key = 'sq.mqtt.password');

insert into sys_config(config_name, config_key, config_value, config_type, create_by, create_time, remark)
select 'SQ迁移配置-sq.mqtt.client-id', 'sq.mqtt.client-id', 'nexa-sq', 'Y', 'admin', sysdate(), '旧SQ模块外部集成配置'
where not exists (select 1 from sys_config where config_key = 'sq.mqtt.client-id');

insert into sys_config(config_name, config_key, config_value, config_type, create_by, create_time, remark)
select 'SQ迁移配置-sq.mqtt.default-topic', 'sq.mqtt.default-topic', 'recording', 'Y', 'admin', sysdate(), '旧SQ模块外部集成配置'
where not exists (select 1 from sys_config where config_key = 'sq.mqtt.default-topic');

insert into sys_config(config_name, config_key, config_value, config_type, create_by, create_time, remark)
select 'SQ迁移配置-sq.media.enabled', 'sq.media.enabled', 'false', 'Y', 'admin', sysdate(), '旧SQ模块外部集成配置'
where not exists (select 1 from sys_config where config_key = 'sq.media.enabled');

insert into sys_config(config_name, config_key, config_value, config_type, create_by, create_time, remark)
select 'SQ迁移配置-sq.media.base-url', 'sq.media.base-url', '', 'Y', 'admin', sysdate(), '旧SQ模块外部集成配置'
where not exists (select 1 from sys_config where config_key = 'sq.media.base-url');

insert into sys_config(config_name, config_key, config_value, config_type, create_by, create_time, remark)
select 'SQ迁移配置-sq.media.snapshot-path', 'sq.media.snapshot-path', '', 'Y', 'admin', sysdate(), '旧SQ模块外部集成配置'
where not exists (select 1 from sys_config where config_key = 'sq.media.snapshot-path');

insert into sys_config(config_name, config_key, config_value, config_type, create_by, create_time, remark)
select 'SQ迁移配置-sq.media.record-path', 'sq.media.record-path', '', 'Y', 'admin', sysdate(), '旧SQ模块外部集成配置'
where not exists (select 1 from sys_config where config_key = 'sq.media.record-path');

insert into sys_config(config_name, config_key, config_value, config_type, create_by, create_time, remark)
select 'SQ迁移配置-sq.media.ffmpeg-path', 'sq.media.ffmpeg-path', 'ffmpeg', 'Y', 'admin', sysdate(), '旧SQ模块外部集成配置'
where not exists (select 1 from sys_config where config_key = 'sq.media.ffmpeg-path');

insert into sys_config(config_name, config_key, config_value, config_type, create_by, create_time, remark)
select 'SQ迁移配置-sq.wx.enabled', 'sq.wx.enabled', 'false', 'Y', 'admin', sysdate(), '旧SQ模块外部集成配置'
where not exists (select 1 from sys_config where config_key = 'sq.wx.enabled');

insert into sys_config(config_name, config_key, config_value, config_type, create_by, create_time, remark)
select 'SQ迁移配置-sq.wx.corp-id', 'sq.wx.corp-id', '', 'Y', 'admin', sysdate(), '旧SQ模块外部集成配置'
where not exists (select 1 from sys_config where config_key = 'sq.wx.corp-id');

insert into sys_config(config_name, config_key, config_value, config_type, create_by, create_time, remark)
select 'SQ迁移配置-sq.wx.secret', 'sq.wx.secret', '', 'Y', 'admin', sysdate(), '旧SQ模块外部集成配置'
where not exists (select 1 from sys_config where config_key = 'sq.wx.secret');

insert into sys_config(config_name, config_key, config_value, config_type, create_by, create_time, remark)
select 'SQ迁移配置-sq.wx.agent-id', 'sq.wx.agent-id', '', 'Y', 'admin', sysdate(), '旧SQ模块外部集成配置'
where not exists (select 1 from sys_config where config_key = 'sq.wx.agent-id');

insert into sys_config(config_name, config_key, config_value, config_type, create_by, create_time, remark)
select 'SQ迁移配置-sq.websocket.enabled', 'sq.websocket.enabled', 'false', 'Y', 'admin', sysdate(), '旧SQ模块外部集成配置'
where not exists (select 1 from sys_config where config_key = 'sq.websocket.enabled');

insert into sys_config(config_name, config_key, config_value, config_type, create_by, create_time, remark)
select 'SQ迁移配置-sq.upload.file-path', 'sq.upload.file-path', '', 'Y', 'admin', sysdate(), '旧SQ模块外部集成配置'
where not exists (select 1 from sys_config where config_key = 'sq.upload.file-path');

insert into sys_config(config_name, config_key, config_value, config_type, create_by, create_time, remark)
select 'SQ迁移配置-sq.upload.image-path', 'sq.upload.image-path', '', 'Y', 'admin', sysdate(), '旧SQ模块外部集成配置'
where not exists (select 1 from sys_config where config_key = 'sq.upload.image-path');

