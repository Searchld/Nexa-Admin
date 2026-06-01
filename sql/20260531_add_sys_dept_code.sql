alter table sys_dept
  add column dept_code varchar(64) not null default '' comment '部门编码' after dept_name;

update sys_dept
set dept_code = concat('DEPT_', dept_id)
where dept_code is null or dept_code = '';
