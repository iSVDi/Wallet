-- liquibase formatted sql

-- changeset DaniilShestopalov:1
-- comment first migration

create table wallet
(
    id varchar(255) default gen_random_uuid() not null primary key,
    amount integer not null
);

alter table wallet owner to admin;

insert into wallet(amount)
values (1000),
       (2000),
       (3000);
-- rollback truncate table demo;

