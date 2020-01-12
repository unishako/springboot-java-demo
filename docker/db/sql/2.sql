create role user1 login password 'USER1';
create database demo with owner = user1;
grant all privileges on database demo to user1;
\c demo
CREATE TABLE users(
    id    bigint GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name  character varying(1000) NOT NULL
);
ALTER TABLE public.users OWNER TO user1;
