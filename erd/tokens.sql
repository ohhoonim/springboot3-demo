-- public.tokens definition

-- Drop table

-- DROP TABLE public.tokens;

CREATE TABLE public.tokens (
	id serial NOT NULL,
	"token" varchar(1024) NOT NULL,
	token_type varchar NOT NULL,
	expired bool NULL,
	revoked bool NULL,
	user_name varchar NOT NULL,
	CONSTRAINT tokens_pk PRIMARY KEY (id),
	CONSTRAINT tokens_un UNIQUE (token)
);

create sequence tokens_seq