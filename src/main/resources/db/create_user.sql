-- Drop table

-- DROP TABLE spring_security_schema.users;

CREATE TABLE spring_security_schema.users (
	id int4 NOT NULL,
	created_by varchar(255) NULL,
	created_on timestamp NULL,
	updated_by varchar(255) NULL,
	updated_on timestamp NULL,
	"password" varchar(255) NULL,
	ENABLED INT NOT NULL,
	username varchar(255)  NOT NULL UNIQUE,
	CONSTRAINT users_pkey PRIMARY KEY (id)
);


CREATE TABLE spring_security_schema.AUTHORITIES
   (
   	id int4 NOT NULL,
	USERNAME VARCHAR(50) NOT NULL,
        AUTHORITY VARCHAR(68) NOT NULL,
        created_by varchar(255) NULL,
	created_on timestamp NULL,
	updated_by varchar(255) NULL,
	updated_on timestamp NULL,
        CONSTRAINT AUTHORITIES_pkey PRIMARY KEY (id),
        FOREIGN KEY (USERNAME) REFERENCES spring_security_schema.USERS(USERNAME)
   );
   
  
  CREATE SEQUENCE spring_security_schema.users_seq
	INCREMENT BY 50
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;
	
CREATE SEQUENCE spring_security_schema.AUTHORITIES_seq
	INCREMENT BY 50
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;
