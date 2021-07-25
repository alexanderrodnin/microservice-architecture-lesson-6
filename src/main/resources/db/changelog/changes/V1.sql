create table if not exists public.user
(
    id bigint not null
        constraint user_pk
            primary key,
    user_name varchar,
    first_name varchar,
    last_name varchar,
    email varchar,
    phone varchar
);

create sequence if not exists public.user_id_seq;
