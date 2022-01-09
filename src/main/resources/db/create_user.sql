-- Drop table

-- DROP TABLE spring_security_schema.users;

CREATE TABLE spring_security_schema.users (
	id int4 NOT NULL,
	created_by varchar(255) NULL,
	created_on timestamp NULL,
	updated_by varchar(255) NULL,
	updated_on timestamp NULL,
	"password" varchar(255) NULL,
	username varchar(255) NULL,
	CONSTRAINT users_pkey PRIMARY KEY (id)
);

-- spring_security_schema.users_seq definition

-- DROP SEQUENCE spring_security_schema.users_seq;

CREATE SEQUENCE spring_security_schema.users_seq
	INCREMENT BY 50
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;
	
