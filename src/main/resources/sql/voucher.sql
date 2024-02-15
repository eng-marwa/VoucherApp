-- Table: public.voucher

-- DROP TABLE IF EXISTS public.voucher;

CREATE TABLE IF NOT EXISTS public.voucher
(
    id integer NOT NULL DEFAULT nextval('voucher_id_seq'::regclass),
    code character varying(20) COLLATE pg_catalog."default",
    discount numeric(8,2),
    expire_date character varying(50) COLLATE pg_catalog."default",
    CONSTRAINT voucher_pkey PRIMARY KEY (id),
    CONSTRAINT voucher_code_key UNIQUE (code)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.voucher
    OWNER to postgres;