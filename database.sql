-- Adminer 4.8.1 PostgreSQL 16.0 (Debian 16.0-1.pgdg120+1) dump

DROP TABLE IF EXISTS "car";
DROP SEQUENCE IF EXISTS car_car_id_seq;
CREATE SEQUENCE car_car_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 2147483647 START 6 CACHE 1;

CREATE TABLE "public"."car" (
    "car_id" integer DEFAULT nextval('car_car_id_seq') NOT NULL,
    "cost_per_day" double precision,
    "cost_per_km" double precision,
    "location_id" integer NOT NULL,
    "notes" character varying(8192),
    "license_plate" character varying(255),
    "make" character varying(255),
    "model" character varying(255),
    CONSTRAINT "car_pkey" PRIMARY KEY ("car_id")
) WITH (oids = false);

INSERT INTO "car" ("car_id", "cost_per_day", "cost_per_km", "location_id", "notes", "license_plate", "make", "model") VALUES
(3,	20.5,	0.5,	1,	'abc',	'I-ABC123',	'Toyota',	'Corolla'),
(4,	10,	2,	1,	'test',	'B-546DEF',	'Ford',	'Fiesta'),
(5,	10,	1,	1,	'123123213',	'123456-ABC',	'Fiat',	'Punto'),
(6,	1,	1,	2,	'',	'W-123ABC',	'VW',	'Golf');

DROP TABLE IF EXISTS "customer";
DROP SEQUENCE IF EXISTS customer_customer_id_seq;
CREATE SEQUENCE customer_customer_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 2147483647 START 2 CACHE 1;

CREATE TABLE "public"."customer" (
    "customer_id" integer DEFAULT nextval('customer_customer_id_seq') NOT NULL,
    "first_name" character varying(255),
    "last_name" character varying(255),
    "license_country" character varying(255),
    "license_number" character varying(255),
    CONSTRAINT "customer_pkey" PRIMARY KEY ("customer_id")
) WITH (oids = false);

INSERT INTO "customer" ("customer_id", "first_name", "last_name", "license_country", "license_number") VALUES
(1,	'John',	'Smith',	'UK',	'12345'),
(2,	'Max',	'Mustermann',	'Austria',	'B1111');

DROP TABLE IF EXISTS "location";
DROP SEQUENCE IF EXISTS location_location_id_seq;
CREATE SEQUENCE location_location_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 2147483647 START 2 CACHE 1;

CREATE TABLE "public"."location" (
    "location_id" integer DEFAULT nextval('location_location_id_seq') NOT NULL,
    "name" character varying(255),
    CONSTRAINT "location_pkey" PRIMARY KEY ("location_id")
) WITH (oids = false);

INSERT INTO "location" ("location_id", "name") VALUES
(1,	'Innsbruck'),
(2,	'Bregenz');

DROP TABLE IF EXISTS "rental";
DROP SEQUENCE IF EXISTS rental_rental_id_seq;
CREATE SEQUENCE rental_rental_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 2147483647 START 5 CACHE 1;

CREATE TABLE "public"."rental" (
    "car_id" integer NOT NULL,
    "customer_id" integer NOT NULL,
    "end_mileage_km" double precision,
    "final_cost" double precision,
    "km_limit" double precision,
    "rental_id" integer DEFAULT nextval('rental_rental_id_seq') NOT NULL,
    "start_mileage_km" double precision,
    "actual_end_date_time" timestamp(6),
    "agreed_end_date_time" timestamp(6),
    "start_date_time" timestamp(6),
    CONSTRAINT "rental_pkey" PRIMARY KEY ("rental_id")
) WITH (oids = false);

INSERT INTO "rental" ("car_id", "customer_id", "end_mileage_km", "final_cost", "km_limit", "rental_id", "start_mileage_km", "actual_end_date_time", "agreed_end_date_time", "start_date_time") VALUES
(3,	1,	500,	80,	1000,	1,	200,	'2020-01-03 12:00:00',	'2020-01-03 10:00:00',	'2020-01-01 15:00:00'),
(5,	1,	NULL,	NULL,	300,	2,	2000,	NULL,	'2023-10-05 10:00:00',	'2023-10-01 10:00:00'),
(3,	2,	3000,	NULL,	NULL,	4,	2000,	'2023-10-03 08:00:00',	'2023-10-02 08:30:00',	'2023-10-01 08:30:00');

ALTER TABLE ONLY "public"."car" ADD CONSTRAINT "fksjeo31bkla3haqy6x9hf5ij0o" FOREIGN KEY (location_id) REFERENCES location(location_id) NOT DEFERRABLE;

ALTER TABLE ONLY "public"."rental" ADD CONSTRAINT "fk7jf1f7b8w6jotl5qw1kxn8114" FOREIGN KEY (customer_id) REFERENCES customer(customer_id) NOT DEFERRABLE;
ALTER TABLE ONLY "public"."rental" ADD CONSTRAINT "fkqoq449d7f5x3a9as634tj4l4b" FOREIGN KEY (car_id) REFERENCES car(car_id) NOT DEFERRABLE;

