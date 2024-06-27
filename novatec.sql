drop table tarjeta;

create table tarjeta (
	tarjeta_id			bigint,
	numero				bigint,
	nombre_titular		varchar(200),
	fecha_vence			date,
	estado_activacion	varchar(1),
	estado_bloqueo		varchar(1),
	saldo				numeric(10)
);

drop table transaccion;

create table transaccion (
	transaccion_id		bigint,
	tipo				varchar(200),    -- compra, aunulacion
	fecha_tran			date,
	valor				numeric(10)
);

insert into tarjeta values (1,1,'aldrin',CURRENT_TIMESTAMP,'N','N',0);
insert into tarjeta values (2,1234567890123456,'sofia',CURRENT_TIMESTAMP,'N','N',0);

select * from tarjeta

update tarjeta set tarjeta_id = 1020301234567801 where tarjeta_id = 1
update tarjeta set tarjeta_id = 1234567890123456 where tarjeta_id = 2


select *
from tarjeta;

delete from tarjeta where numero is null;

select * from product

create table product (
productId numeric,
productName	varchar(100),
price		numeric,
quantity	numeric
)

insert into product values (1,10,'arroz',5);
insert into product values (2,15,'papa',7);
insert into product values (3,20,'carne',9);
insert into product values (4,25,'ahuyama',11);



select *
from persona

insert into persona values(1,'aldrin')
insert into persona values(2,'sofia')


select * from product

create table product (
productId numeric,
productName	varchar(100),
price		numeric,
quantity	numeric
)

insert into product values (1,10,'arroz',5);
insert into product values (2,15,'papa',7);
insert into product values (3,20,'carne',9);
insert into product values (4,25,'ahuyama',11);



select *
from persona

insert into persona values(1,'aldrin')
insert into persona values(2,'sofia')


        long ahora = new Date().getTime();
        long tmp1 = tarjeta.getTransacciones().get(0).getFechaTran().getTime();
        long tmp2 = tarjeta.getTransacciones().get(1).getFechaTran().getTime();

        log.info("ahora = : {}", ahora);
        log.info("tmp1 = : {}", tmp1);
        log.info("tmp2 = : {}", tmp2);
        log.info("ahora-tmp1 = : {}  ", ahora-tmp1);
        log.info("ahora-tmp2 = : {}  ", ahora-tmp2);


        tmp1 = ahora-tmp1;
        tmp2 = ahora-tmp2;

        if (86400000-tmp1<0)
            log.info("tmp1 mas de 24h  {} ",86400000-tmp1);
        if (86400000-tmp2<0)
            log.info("tmp2 mas de 24h  {} ",86400000-tmp2);




drop table tarjeta;

create table tarjeta (
	tarjeta_id			bigint,
	numero				bigint,
	nombre_titular		varchar(200),
	fecha_vence			date,
	estado_activacion	varchar(1),
	estado_bloqueo		varchar(1),
	saldo				numeric(10)
);

drop table transaccion;

create table transaccion (
	transaccion_id		bigint,
	tipo				varchar(1),    -- compra 'C'
	estado				varchar(1),    -- aunulado 'A'
	fecha_tran			timestamp,
	valor				numeric(10),
	tarjeta_id			bigint
);

select * from tarjeta order by id desc
select * from transaccion

insert into tarjeta values (1,1,'aldrin',CURRENT_TIMESTAMP,'N','N',0);
insert into tarjeta values (2,1234567890123456,'sofia',CURRENT_TIMESTAMP,'N','N',0);

select * from tarjeta;
select now()-fecha_tran,qq.* from transaccion qq;
select to_char(fecha_tran,'yyyy-mm-dd hh:mi') from transaccion;

update tarjeta set tarjeta_id = 1020301234567801 where tarjeta_id = 1
update tarjeta set tarjeta_id = 1234567890123456 where tarjeta_id = 2


select *
from tarjeta;

delete from tarjeta where numero is null;

select * from product

create table product (
productId numeric,
productName	varchar(100),
price		numeric,
quantity	numeric
)

insert into product values (1,10,'arroz',5);
insert into product values (2,15,'papa',7);
insert into product values (3,20,'carne',9);
insert into product values (4,25,'ahuyama',11);



select *
from persona

insert into persona values(1,'aldrin')
insert into persona values(2,'sofia')


select * from product

create table product (
productId numeric,
productName	varchar(100),
price		numeric,
quantity	numeric
)

insert into product values (1,10,'arroz',5);
insert into product values (2,15,'papa',7);
insert into product values (3,20,'carne',9);
insert into product values (4,25,'ahuyama',11);



select *
from persona

insert into persona values(1,'aldrin')
insert into persona values(2,'sofia')