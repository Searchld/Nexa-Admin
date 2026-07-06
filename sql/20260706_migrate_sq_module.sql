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

-- Art 前端 sq 普通页面菜单初始化（不含大屏）
set @sq_parent_id := (select menu_id from sys_menu where path = 'sq' and menu_type = 'M' limit 1);

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2801, '车辆管理', @sq_parent_id, 1, 'car', '/sq/car', '', 'SqCars', 1, 0, 'C', '0', '0', 'cars:list', 'ri:truck-line', 'admin', sysdate(), '旧 sq 模块 Art 页面菜单'
where @sq_parent_id is not null and not exists (select 1 from sys_menu where parent_id = @sq_parent_id and path = 'car' and menu_type = 'C');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28011, '查看', 2801, 1, '', '', '', '', 1, 0, 'F', '0', '0', 'cars:query', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2801) and not exists (select 1 from sys_menu where parent_id = 2801 and perms = 'cars:query');
update sys_menu set parent_id = 2801, menu_name = '查看' where perms = 'cars:query' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28012, '新增', 2801, 2, '', '', '', '', 1, 0, 'F', '0', '0', 'cars:add', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2801) and not exists (select 1 from sys_menu where parent_id = 2801 and perms = 'cars:add');
update sys_menu set parent_id = 2801, menu_name = '新增' where perms = 'cars:add' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28013, '修改', 2801, 3, '', '', '', '', 1, 0, 'F', '0', '0', 'cars:edit', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2801) and not exists (select 1 from sys_menu where parent_id = 2801 and perms = 'cars:edit');
update sys_menu set parent_id = 2801, menu_name = '修改' where perms = 'cars:edit' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28014, '删除', 2801, 4, '', '', '', '', 1, 0, 'F', '0', '0', 'cars:del', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2801) and not exists (select 1 from sys_menu where parent_id = 2801 and perms = 'cars:del');
update sys_menu set parent_id = 2801, menu_name = '删除' where perms = 'cars:del' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2802, '摄像头管理', @sq_parent_id, 2, 'camera', '/sq/camera', '', 'SqCamera', 1, 0, 'C', '0', '0', 'camera:list', 'ri:vidicon-line', 'admin', sysdate(), '旧 sq 模块 Art 页面菜单'
where @sq_parent_id is not null and not exists (select 1 from sys_menu where parent_id = @sq_parent_id and path = 'camera' and menu_type = 'C');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28021, '查看', 2802, 1, '', '', '', '', 1, 0, 'F', '0', '0', 'camera:query', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2802) and not exists (select 1 from sys_menu where parent_id = 2802 and perms = 'camera:query');
update sys_menu set parent_id = 2802, menu_name = '查看' where perms = 'camera:query' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28022, '新增', 2802, 2, '', '', '', '', 1, 0, 'F', '0', '0', 'camera:add', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2802) and not exists (select 1 from sys_menu where parent_id = 2802 and perms = 'camera:add');
update sys_menu set parent_id = 2802, menu_name = '新增' where perms = 'camera:add' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28023, '修改', 2802, 3, '', '', '', '', 1, 0, 'F', '0', '0', 'camera:edit', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2802) and not exists (select 1 from sys_menu where parent_id = 2802 and perms = 'camera:edit');
update sys_menu set parent_id = 2802, menu_name = '修改' where perms = 'camera:edit' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28024, '删除', 2802, 4, '', '', '', '', 1, 0, 'F', '0', '0', 'camera:del', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2802) and not exists (select 1 from sys_menu where parent_id = 2802 and perms = 'camera:del');
update sys_menu set parent_id = 2802, menu_name = '删除' where perms = 'camera:del' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2803, '报警记录', @sq_parent_id, 3, 'alert', '/sq/alert', '', 'SqAlert', 1, 0, 'C', '0', '0', 'alert:list', 'ri:alarm-warning-line', 'admin', sysdate(), '旧 sq 模块 Art 页面菜单'
where @sq_parent_id is not null and not exists (select 1 from sys_menu where parent_id = @sq_parent_id and path = 'alert' and menu_type = 'C');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28031, '查看', 2803, 1, '', '', '', '', 1, 0, 'F', '0', '0', 'alert:query', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2803) and not exists (select 1 from sys_menu where parent_id = 2803 and perms = 'alert:query');
update sys_menu set parent_id = 2803, menu_name = '查看' where perms = 'alert:query' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28032, '新增', 2803, 2, '', '', '', '', 1, 0, 'F', '0', '0', 'alert:add', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2803) and not exists (select 1 from sys_menu where parent_id = 2803 and perms = 'alert:add');
update sys_menu set parent_id = 2803, menu_name = '新增' where perms = 'alert:add' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28033, '修改', 2803, 3, '', '', '', '', 1, 0, 'F', '0', '0', 'alert:edit', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2803) and not exists (select 1 from sys_menu where parent_id = 2803 and perms = 'alert:edit');
update sys_menu set parent_id = 2803, menu_name = '修改' where perms = 'alert:edit' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28034, '删除', 2803, 4, '', '', '', '', 1, 0, 'F', '0', '0', 'alert:del', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2803) and not exists (select 1 from sys_menu where parent_id = 2803 and perms = 'alert:del');
update sys_menu set parent_id = 2803, menu_name = '删除' where perms = 'alert:del' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2804, '报警信息配置', @sq_parent_id, 4, 'alert-info', '/sq/alertInfo', '', 'SqAlertInfo', 1, 0, 'C', '0', '0', 'alertInfo:list', 'ri:notification-3-line', 'admin', sysdate(), '旧 sq 模块 Art 页面菜单'
where @sq_parent_id is not null and not exists (select 1 from sys_menu where parent_id = @sq_parent_id and path = 'alert-info' and menu_type = 'C');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28041, '查看', 2804, 1, '', '', '', '', 1, 0, 'F', '0', '0', 'alertInfo:query', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2804) and not exists (select 1 from sys_menu where parent_id = 2804 and perms = 'alertInfo:query');
update sys_menu set parent_id = 2804, menu_name = '查看' where perms = 'alertInfo:query' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28042, '新增', 2804, 2, '', '', '', '', 1, 0, 'F', '0', '0', 'alertInfo:add', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2804) and not exists (select 1 from sys_menu where parent_id = 2804 and perms = 'alertInfo:add');
update sys_menu set parent_id = 2804, menu_name = '新增' where perms = 'alertInfo:add' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28043, '修改', 2804, 3, '', '', '', '', 1, 0, 'F', '0', '0', 'alertInfo:edit', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2804) and not exists (select 1 from sys_menu where parent_id = 2804 and perms = 'alertInfo:edit');
update sys_menu set parent_id = 2804, menu_name = '修改' where perms = 'alertInfo:edit' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28044, '删除', 2804, 4, '', '', '', '', 1, 0, 'F', '0', '0', 'alertInfo:del', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2804) and not exists (select 1 from sys_menu where parent_id = 2804 and perms = 'alertInfo:del');
update sys_menu set parent_id = 2804, menu_name = '删除' where perms = 'alertInfo:del' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2805, '报警原因', @sq_parent_id, 5, 'alert-reason', '/sq/alertReason', '', 'SqAlertReason', 1, 0, 'C', '0', '0', 'alertReason:list', 'ri:file-list-3-line', 'admin', sysdate(), '旧 sq 模块 Art 页面菜单'
where @sq_parent_id is not null and not exists (select 1 from sys_menu where parent_id = @sq_parent_id and path = 'alert-reason' and menu_type = 'C');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28051, '查看', 2805, 1, '', '', '', '', 1, 0, 'F', '0', '0', 'alertReason:query', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2805) and not exists (select 1 from sys_menu where parent_id = 2805 and perms = 'alertReason:query');
update sys_menu set parent_id = 2805, menu_name = '查看' where perms = 'alertReason:query' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28052, '新增', 2805, 2, '', '', '', '', 1, 0, 'F', '0', '0', 'alertReason:add', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2805) and not exists (select 1 from sys_menu where parent_id = 2805 and perms = 'alertReason:add');
update sys_menu set parent_id = 2805, menu_name = '新增' where perms = 'alertReason:add' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28053, '修改', 2805, 3, '', '', '', '', 1, 0, 'F', '0', '0', 'alertReason:edit', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2805) and not exists (select 1 from sys_menu where parent_id = 2805 and perms = 'alertReason:edit');
update sys_menu set parent_id = 2805, menu_name = '修改' where perms = 'alertReason:edit' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28054, '删除', 2805, 4, '', '', '', '', 1, 0, 'F', '0', '0', 'alertReason:del', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2805) and not exists (select 1 from sys_menu where parent_id = 2805 and perms = 'alertReason:del');
update sys_menu set parent_id = 2805, menu_name = '删除' where perms = 'alertReason:del' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2806, '施工团队', @sq_parent_id, 6, 'team', '/sq/team', '', 'SqTeam', 1, 0, 'C', '0', '0', 'team:list', 'ri:group-line', 'admin', sysdate(), '旧 sq 模块 Art 页面菜单'
where @sq_parent_id is not null and not exists (select 1 from sys_menu where parent_id = @sq_parent_id and path = 'team' and menu_type = 'C');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28061, '查看', 2806, 1, '', '', '', '', 1, 0, 'F', '0', '0', 'team:query', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2806) and not exists (select 1 from sys_menu where parent_id = 2806 and perms = 'team:query');
update sys_menu set parent_id = 2806, menu_name = '查看' where perms = 'team:query' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28062, '新增', 2806, 2, '', '', '', '', 1, 0, 'F', '0', '0', 'team:add', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2806) and not exists (select 1 from sys_menu where parent_id = 2806 and perms = 'team:add');
update sys_menu set parent_id = 2806, menu_name = '新增' where perms = 'team:add' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28063, '修改', 2806, 3, '', '', '', '', 1, 0, 'F', '0', '0', 'team:edit', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2806) and not exists (select 1 from sys_menu where parent_id = 2806 and perms = 'team:edit');
update sys_menu set parent_id = 2806, menu_name = '修改' where perms = 'team:edit' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28064, '删除', 2806, 4, '', '', '', '', 1, 0, 'F', '0', '0', 'team:del', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2806) and not exists (select 1 from sys_menu where parent_id = 2806 and perms = 'team:del');
update sys_menu set parent_id = 2806, menu_name = '删除' where perms = 'team:del' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2807, '车辆入库日志', @sq_parent_id, 7, 'cars-logs', '/sq/carsLogs', '', 'SqCarsLogs', 1, 0, 'C', '0', '0', 'carsLogs:list', 'ri:login-box-line', 'admin', sysdate(), '旧 sq 模块 Art 页面菜单'
where @sq_parent_id is not null and not exists (select 1 from sys_menu where parent_id = @sq_parent_id and path = 'cars-logs' and menu_type = 'C');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28071, '查看', 2807, 1, '', '', '', '', 1, 0, 'F', '0', '0', 'carsLogs:query', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2807) and not exists (select 1 from sys_menu where parent_id = 2807 and perms = 'carsLogs:query');
update sys_menu set parent_id = 2807, menu_name = '查看' where perms = 'carsLogs:query' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28072, '新增', 2807, 2, '', '', '', '', 1, 0, 'F', '0', '0', 'carsLogs:add', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2807) and not exists (select 1 from sys_menu where parent_id = 2807 and perms = 'carsLogs:add');
update sys_menu set parent_id = 2807, menu_name = '新增' where perms = 'carsLogs:add' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28073, '修改', 2807, 3, '', '', '', '', 1, 0, 'F', '0', '0', 'carsLogs:edit', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2807) and not exists (select 1 from sys_menu where parent_id = 2807 and perms = 'carsLogs:edit');
update sys_menu set parent_id = 2807, menu_name = '修改' where perms = 'carsLogs:edit' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28074, '删除', 2807, 4, '', '', '', '', 1, 0, 'F', '0', '0', 'carsLogs:del', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2807) and not exists (select 1 from sys_menu where parent_id = 2807 and perms = 'carsLogs:del');
update sys_menu set parent_id = 2807, menu_name = '删除' where perms = 'carsLogs:del' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2808, '车辆出库日志', @sq_parent_id, 8, 'cars-out-logs', '/sq/carsOutLogs', '', 'SqCarsOutLogs', 1, 0, 'C', '0', '0', 'carsOutLogs:list', 'ri:logout-box-line', 'admin', sysdate(), '旧 sq 模块 Art 页面菜单'
where @sq_parent_id is not null and not exists (select 1 from sys_menu where parent_id = @sq_parent_id and path = 'cars-out-logs' and menu_type = 'C');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28081, '查看', 2808, 1, '', '', '', '', 1, 0, 'F', '0', '0', 'carsOutLogs:query', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2808) and not exists (select 1 from sys_menu where parent_id = 2808 and perms = 'carsOutLogs:query');
update sys_menu set parent_id = 2808, menu_name = '查看' where perms = 'carsOutLogs:query' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28082, '新增', 2808, 2, '', '', '', '', 1, 0, 'F', '0', '0', 'carsOutLogs:add', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2808) and not exists (select 1 from sys_menu where parent_id = 2808 and perms = 'carsOutLogs:add');
update sys_menu set parent_id = 2808, menu_name = '新增' where perms = 'carsOutLogs:add' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28083, '修改', 2808, 3, '', '', '', '', 1, 0, 'F', '0', '0', 'carsOutLogs:edit', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2808) and not exists (select 1 from sys_menu where parent_id = 2808 and perms = 'carsOutLogs:edit');
update sys_menu set parent_id = 2808, menu_name = '修改' where perms = 'carsOutLogs:edit' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28084, '删除', 2808, 4, '', '', '', '', 1, 0, 'F', '0', '0', 'carsOutLogs:del', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2808) and not exists (select 1 from sys_menu where parent_id = 2808 and perms = 'carsOutLogs:del');
update sys_menu set parent_id = 2808, menu_name = '删除' where perms = 'carsOutLogs:del' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2809, '历史车辆日志', @sq_parent_id, 9, 'cars-logs-his', '/sq/aCarsLogsHis', '', 'SqACarsLogsHis', 1, 0, 'C', '0', '0', 'aCarsLogsHis:list', 'ri:history-line', 'admin', sysdate(), '旧 sq 模块 Art 页面菜单'
where @sq_parent_id is not null and not exists (select 1 from sys_menu where parent_id = @sq_parent_id and path = 'cars-logs-his' and menu_type = 'C');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28091, '查看', 2809, 1, '', '', '', '', 1, 0, 'F', '0', '0', 'aCarsLogsHis:query', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2809) and not exists (select 1 from sys_menu where parent_id = 2809 and perms = 'aCarsLogsHis:query');
update sys_menu set parent_id = 2809, menu_name = '查看' where perms = 'aCarsLogsHis:query' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28092, '新增', 2809, 2, '', '', '', '', 1, 0, 'F', '0', '0', 'aCarsLogsHis:add', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2809) and not exists (select 1 from sys_menu where parent_id = 2809 and perms = 'aCarsLogsHis:add');
update sys_menu set parent_id = 2809, menu_name = '新增' where perms = 'aCarsLogsHis:add' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28093, '修改', 2809, 3, '', '', '', '', 1, 0, 'F', '0', '0', 'aCarsLogsHis:edit', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2809) and not exists (select 1 from sys_menu where parent_id = 2809 and perms = 'aCarsLogsHis:edit');
update sys_menu set parent_id = 2809, menu_name = '修改' where perms = 'aCarsLogsHis:edit' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28094, '删除', 2809, 4, '', '', '', '', 1, 0, 'F', '0', '0', 'aCarsLogsHis:del', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2809) and not exists (select 1 from sys_menu where parent_id = 2809 and perms = 'aCarsLogsHis:del');
update sys_menu set parent_id = 2809, menu_name = '删除' where perms = 'aCarsLogsHis:del' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2810, 'AI报警记录', @sq_parent_id, 10, 'yn-user', '/sq/ynUser', '', 'SqYnUser', 1, 0, 'C', '0', '0', 'ynUser:list', 'ri:user-warning-line', 'admin', sysdate(), '旧 sq 模块 Art 页面菜单'
where @sq_parent_id is not null and not exists (select 1 from sys_menu where parent_id = @sq_parent_id and path = 'yn-user' and menu_type = 'C');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28101, '查看', 2810, 1, '', '', '', '', 1, 0, 'F', '0', '0', 'ynUser:query', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2810) and not exists (select 1 from sys_menu where parent_id = 2810 and perms = 'ynUser:query');
update sys_menu set parent_id = 2810, menu_name = '查看' where perms = 'ynUser:query' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28102, '新增', 2810, 2, '', '', '', '', 1, 0, 'F', '0', '0', 'ynUser:add', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2810) and not exists (select 1 from sys_menu where parent_id = 2810 and perms = 'ynUser:add');
update sys_menu set parent_id = 2810, menu_name = '新增' where perms = 'ynUser:add' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28103, '修改', 2810, 3, '', '', '', '', 1, 0, 'F', '0', '0', 'ynUser:edit', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2810) and not exists (select 1 from sys_menu where parent_id = 2810 and perms = 'ynUser:edit');
update sys_menu set parent_id = 2810, menu_name = '修改' where perms = 'ynUser:edit' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28104, '删除', 2810, 4, '', '', '', '', 1, 0, 'F', '0', '0', 'ynUser:del', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2810) and not exists (select 1 from sys_menu where parent_id = 2810 and perms = 'ynUser:del');
update sys_menu set parent_id = 2810, menu_name = '删除' where perms = 'ynUser:del' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2811, '巡检报警记录', @sq_parent_id, 11, 'yn-user-xj', '/sq/ynUserXj', '', 'SqYnUserXj', 1, 0, 'C', '0', '0', 'ynUserXj:list', 'ri:shield-user-line', 'admin', sysdate(), '旧 sq 模块 Art 页面菜单'
where @sq_parent_id is not null and not exists (select 1 from sys_menu where parent_id = @sq_parent_id and path = 'yn-user-xj' and menu_type = 'C');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28111, '查看', 2811, 1, '', '', '', '', 1, 0, 'F', '0', '0', 'ynUserXj:query', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2811) and not exists (select 1 from sys_menu where parent_id = 2811 and perms = 'ynUserXj:query');
update sys_menu set parent_id = 2811, menu_name = '查看' where perms = 'ynUserXj:query' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28112, '新增', 2811, 2, '', '', '', '', 1, 0, 'F', '0', '0', 'ynUserXj:add', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2811) and not exists (select 1 from sys_menu where parent_id = 2811 and perms = 'ynUserXj:add');
update sys_menu set parent_id = 2811, menu_name = '新增' where perms = 'ynUserXj:add' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28113, '修改', 2811, 3, '', '', '', '', 1, 0, 'F', '0', '0', 'ynUserXj:edit', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2811) and not exists (select 1 from sys_menu where parent_id = 2811 and perms = 'ynUserXj:edit');
update sys_menu set parent_id = 2811, menu_name = '修改' where perms = 'ynUserXj:edit' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28114, '删除', 2811, 4, '', '', '', '', 1, 0, 'F', '0', '0', 'ynUserXj:del', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2811) and not exists (select 1 from sys_menu where parent_id = 2811 and perms = 'ynUserXj:del');
update sys_menu set parent_id = 2811, menu_name = '删除' where perms = 'ynUserXj:del' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2812, '企业微信用户', @sq_parent_id, 12, 'yn-wx-user', '/sq/ynWxUser', '', 'SqYnWxUser', 1, 0, 'C', '0', '0', 'ynWxUser:list', 'ri:wechat-line', 'admin', sysdate(), '旧 sq 模块 Art 页面菜单'
where @sq_parent_id is not null and not exists (select 1 from sys_menu where parent_id = @sq_parent_id and path = 'yn-wx-user' and menu_type = 'C');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28121, '查看', 2812, 1, '', '', '', '', 1, 0, 'F', '0', '0', 'ynWxUser:query', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2812) and not exists (select 1 from sys_menu where parent_id = 2812 and perms = 'ynWxUser:query');
update sys_menu set parent_id = 2812, menu_name = '查看' where perms = 'ynWxUser:query' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28122, '新增', 2812, 2, '', '', '', '', 1, 0, 'F', '0', '0', 'ynWxUser:add', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2812) and not exists (select 1 from sys_menu where parent_id = 2812 and perms = 'ynWxUser:add');
update sys_menu set parent_id = 2812, menu_name = '新增' where perms = 'ynWxUser:add' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28123, '修改', 2812, 3, '', '', '', '', 1, 0, 'F', '0', '0', 'ynWxUser:edit', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2812) and not exists (select 1 from sys_menu where parent_id = 2812 and perms = 'ynWxUser:edit');
update sys_menu set parent_id = 2812, menu_name = '修改' where perms = 'ynWxUser:edit' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28124, '删除', 2812, 4, '', '', '', '', 1, 0, 'F', '0', '0', 'ynWxUser:del', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2812) and not exists (select 1 from sys_menu where parent_id = 2812 and perms = 'ynWxUser:del');
update sys_menu set parent_id = 2812, menu_name = '删除' where perms = 'ynWxUser:del' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2813, '企业微信部门', @sq_parent_id, 13, 'yn-wx-dept', '/sq/ynWxDept', '', 'SqYnWxDept', 1, 0, 'C', '0', '0', 'ynWxDept:list', 'ri:organization-chart', 'admin', sysdate(), '旧 sq 模块 Art 页面菜单'
where @sq_parent_id is not null and not exists (select 1 from sys_menu where parent_id = @sq_parent_id and path = 'yn-wx-dept' and menu_type = 'C');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28131, '查看', 2813, 1, '', '', '', '', 1, 0, 'F', '0', '0', 'ynWxDept:query', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2813) and not exists (select 1 from sys_menu where parent_id = 2813 and perms = 'ynWxDept:query');
update sys_menu set parent_id = 2813, menu_name = '查看' where perms = 'ynWxDept:query' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28132, '新增', 2813, 2, '', '', '', '', 1, 0, 'F', '0', '0', 'ynWxDept:add', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2813) and not exists (select 1 from sys_menu where parent_id = 2813 and perms = 'ynWxDept:add');
update sys_menu set parent_id = 2813, menu_name = '新增' where perms = 'ynWxDept:add' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28133, '修改', 2813, 3, '', '', '', '', 1, 0, 'F', '0', '0', 'ynWxDept:edit', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2813) and not exists (select 1 from sys_menu where parent_id = 2813 and perms = 'ynWxDept:edit');
update sys_menu set parent_id = 2813, menu_name = '修改' where perms = 'ynWxDept:edit' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28134, '删除', 2813, 4, '', '', '', '', 1, 0, 'F', '0', '0', 'ynWxDept:del', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2813) and not exists (select 1 from sys_menu where parent_id = 2813 and perms = 'ynWxDept:del');
update sys_menu set parent_id = 2813, menu_name = '删除' where perms = 'ynWxDept:del' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2814, '企业微信发送配置', @sq_parent_id, 14, 'yn-wx-send', '/sq/ynWxSend', '', 'SqYnWxSend', 1, 0, 'C', '0', '0', 'ynWxSend:list', 'ri:send-plane-line', 'admin', sysdate(), '旧 sq 模块 Art 页面菜单'
where @sq_parent_id is not null and not exists (select 1 from sys_menu where parent_id = @sq_parent_id and path = 'yn-wx-send' and menu_type = 'C');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28141, '查看', 2814, 1, '', '', '', '', 1, 0, 'F', '0', '0', 'ynWxSend:query', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2814) and not exists (select 1 from sys_menu where parent_id = 2814 and perms = 'ynWxSend:query');
update sys_menu set parent_id = 2814, menu_name = '查看' where perms = 'ynWxSend:query' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28142, '新增', 2814, 2, '', '', '', '', 1, 0, 'F', '0', '0', 'ynWxSend:add', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2814) and not exists (select 1 from sys_menu where parent_id = 2814 and perms = 'ynWxSend:add');
update sys_menu set parent_id = 2814, menu_name = '新增' where perms = 'ynWxSend:add' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28143, '修改', 2814, 3, '', '', '', '', 1, 0, 'F', '0', '0', 'ynWxSend:edit', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2814) and not exists (select 1 from sys_menu where parent_id = 2814 and perms = 'ynWxSend:edit');
update sys_menu set parent_id = 2814, menu_name = '修改' where perms = 'ynWxSend:edit' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28144, '删除', 2814, 4, '', '', '', '', 1, 0, 'F', '0', '0', 'ynWxSend:del', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2814) and not exists (select 1 from sys_menu where parent_id = 2814 and perms = 'ynWxSend:del');
update sys_menu set parent_id = 2814, menu_name = '删除' where perms = 'ynWxSend:del' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2815, '任务管理', @sq_parent_id, 15, 'yn-task', '/sq/ynTask', '', 'SqYnTask', 1, 0, 'C', '0', '0', 'ynTask:list', 'ri:task-line', 'admin', sysdate(), '旧 sq 模块 Art 页面菜单'
where @sq_parent_id is not null and not exists (select 1 from sys_menu where parent_id = @sq_parent_id and path = 'yn-task' and menu_type = 'C');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28151, '查看', 2815, 1, '', '', '', '', 1, 0, 'F', '0', '0', 'ynTask:query', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2815) and not exists (select 1 from sys_menu where parent_id = 2815 and perms = 'ynTask:query');
update sys_menu set parent_id = 2815, menu_name = '查看' where perms = 'ynTask:query' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28152, '新增', 2815, 2, '', '', '', '', 1, 0, 'F', '0', '0', 'ynTask:add', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2815) and not exists (select 1 from sys_menu where parent_id = 2815 and perms = 'ynTask:add');
update sys_menu set parent_id = 2815, menu_name = '新增' where perms = 'ynTask:add' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28153, '修改', 2815, 3, '', '', '', '', 1, 0, 'F', '0', '0', 'ynTask:edit', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2815) and not exists (select 1 from sys_menu where parent_id = 2815 and perms = 'ynTask:edit');
update sys_menu set parent_id = 2815, menu_name = '修改' where perms = 'ynTask:edit' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28154, '删除', 2815, 4, '', '', '', '', 1, 0, 'F', '0', '0', 'ynTask:del', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2815) and not exists (select 1 from sys_menu where parent_id = 2815 and perms = 'ynTask:del');
update sys_menu set parent_id = 2815, menu_name = '删除' where perms = 'ynTask:del' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2816, '声光报警器', @sq_parent_id, 16, 'siren', '/sq/siren', '', 'SqSiren', 1, 0, 'C', '0', '0', 'ynSiren:list', 'ri:volume-vibrate-line', 'admin', sysdate(), '旧 sq 模块 Art 页面菜单'
where @sq_parent_id is not null and not exists (select 1 from sys_menu where parent_id = @sq_parent_id and path = 'siren' and menu_type = 'C');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28161, '查看', 2816, 1, '', '', '', '', 1, 0, 'F', '0', '0', 'ynSiren:query', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2816) and not exists (select 1 from sys_menu where parent_id = 2816 and perms = 'ynSiren:query');
update sys_menu set parent_id = 2816, menu_name = '查看' where perms = 'ynSiren:query' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28162, '新增', 2816, 2, '', '', '', '', 1, 0, 'F', '0', '0', 'ynSiren:add', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2816) and not exists (select 1 from sys_menu where parent_id = 2816 and perms = 'ynSiren:add');
update sys_menu set parent_id = 2816, menu_name = '新增' where perms = 'ynSiren:add' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28163, '修改', 2816, 3, '', '', '', '', 1, 0, 'F', '0', '0', 'ynSiren:edit', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2816) and not exists (select 1 from sys_menu where parent_id = 2816 and perms = 'ynSiren:edit');
update sys_menu set parent_id = 2816, menu_name = '修改' where perms = 'ynSiren:edit' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28164, '删除', 2816, 4, '', '', '', '', 1, 0, 'F', '0', '0', 'ynSiren:del', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2816) and not exists (select 1 from sys_menu where parent_id = 2816 and perms = 'ynSiren:del');
update sys_menu set parent_id = 2816, menu_name = '删除' where perms = 'ynSiren:del' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2817, 'RFID标签', @sq_parent_id, 17, 'yn-rfid', '/sq/ynRfid', '', 'SqYnRfid', 1, 0, 'C', '0', '0', 'ynRfid:list', 'ri:rfid-line', 'admin', sysdate(), '旧 sq 模块 Art 页面菜单'
where @sq_parent_id is not null and not exists (select 1 from sys_menu where parent_id = @sq_parent_id and path = 'yn-rfid' and menu_type = 'C');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28171, '查看', 2817, 1, '', '', '', '', 1, 0, 'F', '0', '0', 'ynRfid:query', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2817) and not exists (select 1 from sys_menu where parent_id = 2817 and perms = 'ynRfid:query');
update sys_menu set parent_id = 2817, menu_name = '查看' where perms = 'ynRfid:query' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28172, '新增', 2817, 2, '', '', '', '', 1, 0, 'F', '0', '0', 'ynRfid:add', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2817) and not exists (select 1 from sys_menu where parent_id = 2817 and perms = 'ynRfid:add');
update sys_menu set parent_id = 2817, menu_name = '新增' where perms = 'ynRfid:add' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28173, '修改', 2817, 3, '', '', '', '', 1, 0, 'F', '0', '0', 'ynRfid:edit', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2817) and not exists (select 1 from sys_menu where parent_id = 2817 and perms = 'ynRfid:edit');
update sys_menu set parent_id = 2817, menu_name = '修改' where perms = 'ynRfid:edit' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28174, '删除', 2817, 4, '', '', '', '', 1, 0, 'F', '0', '0', 'ynRfid:del', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2817) and not exists (select 1 from sys_menu where parent_id = 2817 and perms = 'ynRfid:del');
update sys_menu set parent_id = 2817, menu_name = '删除' where perms = 'ynRfid:del' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2818, 'RFID阅读器', @sq_parent_id, 18, 'yn-rfid-ydq', '/sq/ynRfidYdq', '', 'SqYnRfidYdq', 1, 0, 'C', '0', '0', 'ynRfidYdq:list', 'ri:scan-line', 'admin', sysdate(), '旧 sq 模块 Art 页面菜单'
where @sq_parent_id is not null and not exists (select 1 from sys_menu where parent_id = @sq_parent_id and path = 'yn-rfid-ydq' and menu_type = 'C');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28181, '查看', 2818, 1, '', '', '', '', 1, 0, 'F', '0', '0', 'ynRfidYdq:query', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2818) and not exists (select 1 from sys_menu where parent_id = 2818 and perms = 'ynRfidYdq:query');
update sys_menu set parent_id = 2818, menu_name = '查看' where perms = 'ynRfidYdq:query' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28182, '新增', 2818, 2, '', '', '', '', 1, 0, 'F', '0', '0', 'ynRfidYdq:add', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2818) and not exists (select 1 from sys_menu where parent_id = 2818 and perms = 'ynRfidYdq:add');
update sys_menu set parent_id = 2818, menu_name = '新增' where perms = 'ynRfidYdq:add' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28183, '修改', 2818, 3, '', '', '', '', 1, 0, 'F', '0', '0', 'ynRfidYdq:edit', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2818) and not exists (select 1 from sys_menu where parent_id = 2818 and perms = 'ynRfidYdq:edit');
update sys_menu set parent_id = 2818, menu_name = '修改' where perms = 'ynRfidYdq:edit' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28184, '删除', 2818, 4, '', '', '', '', 1, 0, 'F', '0', '0', 'ynRfidYdq:del', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2818) and not exists (select 1 from sys_menu where parent_id = 2818 and perms = 'ynRfidYdq:del');
update sys_menu set parent_id = 2818, menu_name = '删除' where perms = 'ynRfidYdq:del' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2819, 'RFID读取记录', @sq_parent_id, 19, 'yn-rfid-record', '/sq/ynRfidRecord', '', 'SqYnRfidRecord', 1, 0, 'C', '0', '0', 'ynRfidRecord:list', 'ri:file-search-line', 'admin', sysdate(), '旧 sq 模块 Art 页面菜单'
where @sq_parent_id is not null and not exists (select 1 from sys_menu where parent_id = @sq_parent_id and path = 'yn-rfid-record' and menu_type = 'C');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28191, '查看', 2819, 1, '', '', '', '', 1, 0, 'F', '0', '0', 'ynRfidRecord:query', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2819) and not exists (select 1 from sys_menu where parent_id = 2819 and perms = 'ynRfidRecord:query');
update sys_menu set parent_id = 2819, menu_name = '查看' where perms = 'ynRfidRecord:query' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28192, '新增', 2819, 2, '', '', '', '', 1, 0, 'F', '0', '0', 'ynRfidRecord:add', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2819) and not exists (select 1 from sys_menu where parent_id = 2819 and perms = 'ynRfidRecord:add');
update sys_menu set parent_id = 2819, menu_name = '新增' where perms = 'ynRfidRecord:add' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28193, '修改', 2819, 3, '', '', '', '', 1, 0, 'F', '0', '0', 'ynRfidRecord:edit', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2819) and not exists (select 1 from sys_menu where parent_id = 2819 and perms = 'ynRfidRecord:edit');
update sys_menu set parent_id = 2819, menu_name = '修改' where perms = 'ynRfidRecord:edit' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28194, '删除', 2819, 4, '', '', '', '', 1, 0, 'F', '0', '0', 'ynRfidRecord:del', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2819) and not exists (select 1 from sys_menu where parent_id = 2819 and perms = 'ynRfidRecord:del');
update sys_menu set parent_id = 2819, menu_name = '删除' where perms = 'ynRfidRecord:del' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2820, '摄像头开关记录', @sq_parent_id, 20, 'yn-camera-record', '/sq/ynCameraRecord', '', 'SqYnCameraRecord', 1, 0, 'C', '0', '0', 'ynCameraRecord:list', 'ri:video-on-line', 'admin', sysdate(), '旧 sq 模块 Art 页面菜单'
where @sq_parent_id is not null and not exists (select 1 from sys_menu where parent_id = @sq_parent_id and path = 'yn-camera-record' and menu_type = 'C');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28201, '查看', 2820, 1, '', '', '', '', 1, 0, 'F', '0', '0', 'ynCameraRecord:query', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2820) and not exists (select 1 from sys_menu where parent_id = 2820 and perms = 'ynCameraRecord:query');
update sys_menu set parent_id = 2820, menu_name = '查看' where perms = 'ynCameraRecord:query' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28202, '新增', 2820, 2, '', '', '', '', 1, 0, 'F', '0', '0', 'ynCameraRecord:add', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2820) and not exists (select 1 from sys_menu where parent_id = 2820 and perms = 'ynCameraRecord:add');
update sys_menu set parent_id = 2820, menu_name = '新增' where perms = 'ynCameraRecord:add' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28203, '修改', 2820, 3, '', '', '', '', 1, 0, 'F', '0', '0', 'ynCameraRecord:edit', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2820) and not exists (select 1 from sys_menu where parent_id = 2820 and perms = 'ynCameraRecord:edit');
update sys_menu set parent_id = 2820, menu_name = '修改' where perms = 'ynCameraRecord:edit' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28204, '删除', 2820, 4, '', '', '', '', 1, 0, 'F', '0', '0', 'ynCameraRecord:del', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2820) and not exists (select 1 from sys_menu where parent_id = 2820 and perms = 'ynCameraRecord:del');
update sys_menu set parent_id = 2820, menu_name = '删除' where perms = 'ynCameraRecord:del' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2821, '料位日志', @sq_parent_id, 21, 'yn-logs-level', '/sq/ynLogsLevel', '', 'SqYnLogsLevel', 1, 0, 'C', '0', '0', 'ynLogsLevel:list', 'ri:bar-chart-2-line', 'admin', sysdate(), '旧 sq 模块 Art 页面菜单'
where @sq_parent_id is not null and not exists (select 1 from sys_menu where parent_id = @sq_parent_id and path = 'yn-logs-level' and menu_type = 'C');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28211, '查看', 2821, 1, '', '', '', '', 1, 0, 'F', '0', '0', 'ynLogsLevel:query', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2821) and not exists (select 1 from sys_menu where parent_id = 2821 and perms = 'ynLogsLevel:query');
update sys_menu set parent_id = 2821, menu_name = '查看' where perms = 'ynLogsLevel:query' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28212, '新增', 2821, 2, '', '', '', '', 1, 0, 'F', '0', '0', 'ynLogsLevel:add', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2821) and not exists (select 1 from sys_menu where parent_id = 2821 and perms = 'ynLogsLevel:add');
update sys_menu set parent_id = 2821, menu_name = '新增' where perms = 'ynLogsLevel:add' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28213, '修改', 2821, 3, '', '', '', '', 1, 0, 'F', '0', '0', 'ynLogsLevel:edit', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2821) and not exists (select 1 from sys_menu where parent_id = 2821 and perms = 'ynLogsLevel:edit');
update sys_menu set parent_id = 2821, menu_name = '修改' where perms = 'ynLogsLevel:edit' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28214, '删除', 2821, 4, '', '', '', '', 1, 0, 'F', '0', '0', 'ynLogsLevel:del', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2821) and not exists (select 1 from sys_menu where parent_id = 2821 and perms = 'ynLogsLevel:del');
update sys_menu set parent_id = 2821, menu_name = '删除' where perms = 'ynLogsLevel:del' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2822, '出矿日志', @sq_parent_id, 22, 'yn-logs-out', '/sq/ynLogsOut', '', 'SqYnLogsOut', 1, 0, 'C', '0', '0', 'ynLogsOut:list', 'ri:file-chart-line', 'admin', sysdate(), '旧 sq 模块 Art 页面菜单'
where @sq_parent_id is not null and not exists (select 1 from sys_menu where parent_id = @sq_parent_id and path = 'yn-logs-out' and menu_type = 'C');

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28221, '查看', 2822, 1, '', '', '', '', 1, 0, 'F', '0', '0', 'ynLogsOut:query', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2822) and not exists (select 1 from sys_menu where parent_id = 2822 and perms = 'ynLogsOut:query');
update sys_menu set parent_id = 2822, menu_name = '查看' where perms = 'ynLogsOut:query' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28222, '新增', 2822, 2, '', '', '', '', 1, 0, 'F', '0', '0', 'ynLogsOut:add', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2822) and not exists (select 1 from sys_menu where parent_id = 2822 and perms = 'ynLogsOut:add');
update sys_menu set parent_id = 2822, menu_name = '新增' where perms = 'ynLogsOut:add' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28223, '修改', 2822, 3, '', '', '', '', 1, 0, 'F', '0', '0', 'ynLogsOut:edit', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2822) and not exists (select 1 from sys_menu where parent_id = 2822 and perms = 'ynLogsOut:edit');
update sys_menu set parent_id = 2822, menu_name = '修改' where perms = 'ynLogsOut:edit' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 28224, '删除', 2822, 4, '', '', '', '', 1, 0, 'F', '0', '0', 'ynLogsOut:del', '#', 'admin', sysdate(), '旧 sq 模块按钮权限'
where exists (select 1 from sys_menu where menu_id = 2822) and not exists (select 1 from sys_menu where parent_id = 2822 and perms = 'ynLogsOut:del');
update sys_menu set parent_id = 2822, menu_name = '删除' where perms = 'ynLogsOut:del' and parent_id = @sq_parent_id;

insert into sys_menu(menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2823, '文件上传', @sq_parent_id, 23, 'upload', '/sq/upload', '', 'SqUpload', 1, 0, 'C', '0', '0', '', 'ri:upload-cloud-2-line', 'admin', sysdate(), '旧 sq 模块 Art 页面菜单'
where @sq_parent_id is not null and not exists (select 1 from sys_menu where parent_id = @sq_parent_id and path = 'upload' and menu_type = 'C');

