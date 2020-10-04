CREATE TABLE subscriber (
	id int8 NOT NULL,
	"name" varchar(255) NULL,
	"surname" varchar(255) NULL,
    "email" varchar(255) NULL,
	created_by varchar(255) NULL,
	creation_date timestamp NULL,
	last_modified_by varchar(255) NULL,
	last_modified_date timestamp NULL,
	is_deleted boolean default false,
	CONSTRAINT subscriber_pkey PRIMARY KEY (id)
);