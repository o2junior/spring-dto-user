CREATE SCHEMA springdto;

CREATE TABLE springdto.user (
	id bigserial NOT NULL,
	username varchar(200) NOT NULL,
	full_name varchar(200) NOT NULL,
	email varchar(100) NOT NULL,
	document varchar(11) NOT NULL,
	pwd varchar(12) NOT NULL,
	admin bool NULL DEFAULT false,
	is_active bool NULL DEFAULT true,
	created_at timestamp NULL,
	updated_at timestamp NULL,
	deleted_at timestamp NULL,
	CONSTRAINT usuario_pk PRIMARY KEY (id),
	CONSTRAINT unique_email UNIQUE (email),
	CONSTRAINT unique_document UNIQUE (document)
);