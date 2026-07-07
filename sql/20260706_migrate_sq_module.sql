-- 清空“旧系统SQ”目录下的所有子孙菜单，只保留根目录。
-- 用于后续按模块重新迁移。可重复执行。

set @sq_root := (
    select menu_id
    from sys_menu
    where menu_name = '旧系统SQ'
    order by menu_id
    limit 1
);

insert into sys_menu
    (menu_id, menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select 2600, '旧系统SQ', 0, 99, 'sq', '', '', 'SqLegacy', 1, 0, 'M', '0', '0', '', 'ri:archive-stack-line', 'admin', sysdate(), '旧系统SQ迁移占位目录'
where @sq_root is null
  and not exists (select 1 from sys_menu where menu_id = 2600);

insert into sys_menu
    (menu_name, parent_id, order_num, path, component, query, route_name, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, remark)
select '旧系统SQ', 0, 99, 'sq', '', '', 'SqLegacy', 1, 0, 'M', '0', '0', '', 'ri:archive-stack-line', 'admin', sysdate(), '旧系统SQ迁移占位目录'
where @sq_root is null
  and not exists (select 1 from sys_menu where menu_name = '旧系统SQ')
  and exists (select 1 from sys_menu where menu_id = 2600);

set @sq_root := (
    select menu_id
    from sys_menu
    where menu_name = '旧系统SQ'
    order by menu_id
    limit 1
);

drop temporary table if exists tmp_sq_menu_delete;

create temporary table tmp_sq_menu_delete (
    menu_id bigint not null primary key
);

insert ignore into tmp_sq_menu_delete(menu_id)
with recursive sq_menu_tree as (
    select menu_id
    from sys_menu
    where parent_id = @sq_root

    union all

    select child.menu_id
    from sys_menu child
    inner join sq_menu_tree parent on child.parent_id = parent.menu_id
)
select menu_id
from sq_menu_tree;

delete role_menu
from sys_role_menu role_menu
inner join tmp_sq_menu_delete deleted_menu on deleted_menu.menu_id = role_menu.menu_id;

delete menu
from sys_menu menu
inner join tmp_sq_menu_delete deleted_menu on deleted_menu.menu_id = menu.menu_id;

update sys_menu
set parent_id = 0,
    order_num = 99,
    path = 'sq',
    component = '',
    query = '',
    route_name = 'SqLegacy',
    is_frame = 1,
    is_cache = 0,
    menu_type = 'M',
    visible = '0',
    status = '0',
    perms = '',
    icon = 'ri:archive-stack-line',
    update_by = 'admin',
    update_time = sysdate(),
    remark = '旧系统SQ迁移占位目录'
where menu_id = @sq_root;

drop temporary table if exists tmp_sq_menu_delete;
