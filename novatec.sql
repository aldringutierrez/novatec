-- Table: public.tarjeta

-- DROP TABLE IF EXISTS public.tarjeta;

CREATE TABLE IF NOT EXISTS public.tarjeta
(
    id bigint,
    numero bigint,
    nombre_titular character varying(200) COLLATE pg_catalog."default",
    fecha_vence date,
    estado_activacion character varying(1) COLLATE pg_catalog."default",
    estado_bloqueo character varying(1) COLLATE pg_catalog."default",
    saldo numeric(10,0)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.tarjeta
    OWNER to postgres;
	
	
	
	
-- Table: public.transaccion

-- DROP TABLE IF EXISTS public.transaccion;

CREATE TABLE IF NOT EXISTS public.transaccion
(
    transaccion_id bigint,
    tipo character varying(1) COLLATE pg_catalog."default",
    estado character varying(1) COLLATE pg_catalog."default",
    fecha_tran timestamp without time zone,
    valor numeric(10,0),
    tarjeta_id bigint
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.transaccion
    OWNER to postgres;	
