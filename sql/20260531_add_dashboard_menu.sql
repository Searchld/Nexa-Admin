-- Art Dashboard menus served by RuoYi /getRouters.
-- Reserved menu IDs 9000-9003 avoid collisions with the built-in RuoYi menu range.

update sys_menu set order_num = 2 where menu_id = 1 and parent_id = 0;
update sys_menu set order_num = 3 where menu_id = 2 and parent_id = 0;
update sys_menu set order_num = 4 where menu_id = 3 and parent_id = 0;
update sys_menu set order_num = 5 where menu_id = 4 and parent_id = 0;

insert into sys_menu
  (menu_id, menu_name, parent_id, order_num, path, component, query, route_name,
   is_frame, is_cache, menu_type, visible, status, perms, icon,
   create_by, create_time, update_by, update_time, remark)
select
  9000, '仪表盘', 0, 1, 'dashboard', null, '', 'Dashboard',
  1, 0, 'M', '0', '0', '', 'dashboard',
  'admin', sysdate(), '', null, '仪表盘目录'
where not exists (select 1 from sys_menu where menu_id = 9000);

insert into sys_menu
  (menu_id, menu_name, parent_id, order_num, path, component, query, route_name,
   is_frame, is_cache, menu_type, visible, status, perms, icon,
   create_by, create_time, update_by, update_time, remark)
select
  9001, '工作台', 9000, 1, 'console', 'dashboard/console/index', '', 'Console',
  1, 1, 'C', '0', '0', '', 'console',
  'admin', sysdate(), '', null, '仪表盘工作台菜单'
where not exists (select 1 from sys_menu where menu_id = 9001);

insert into sys_menu
  (menu_id, menu_name, parent_id, order_num, path, component, query, route_name,
   is_frame, is_cache, menu_type, visible, status, perms, icon,
   create_by, create_time, update_by, update_time, remark)
select
  9002, '分析页', 9000, 2, 'analysis', 'dashboard/analysis/index', '', 'Analysis',
  1, 1, 'C', '0', '0', '', 'analysis',
  'admin', sysdate(), '', null, '仪表盘分析页菜单'
where not exists (select 1 from sys_menu where menu_id = 9002);

insert into sys_menu
  (menu_id, menu_name, parent_id, order_num, path, component, query, route_name,
   is_frame, is_cache, menu_type, visible, status, perms, icon,
   create_by, create_time, update_by, update_time, remark)
select
  9003, '电子商务', 9000, 3, 'ecommerce', 'dashboard/ecommerce/index', '', 'Ecommerce',
  1, 1, 'C', '0', '0', '', 'ecommerce',
  'admin', sysdate(), '', null, '仪表盘电子商务菜单'
where not exists (select 1 from sys_menu where menu_id = 9003);

insert into sys_role_menu (role_id, menu_id)
select role.role_id, menu.menu_id
from sys_role role
join sys_menu menu on menu.menu_id in (9000, 9001, 9002, 9003)
where not exists (
  select 1
  from sys_role_menu role_menu
  where role_menu.role_id = role.role_id
    and role_menu.menu_id = menu.menu_id
);
