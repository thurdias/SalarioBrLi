create table crg_cargo(
crg_id number not null,
crg_nome varchar(50),
crg_salario double,
constraint crg_cargo_pk primary key(crg_id)
);

create table col_colaborador(
col_id number not null,
col_idcargo number,
col_nome varchar2(50),
constraint col_colaborador_pk primary key(col_id)
);