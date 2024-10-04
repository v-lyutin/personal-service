--liquibase formatted sql

--changeset v-lyutin:create-departments-table
--comment create table personal.departments
create table personal.departments (
    id uuid primary key,
    display_name varchar(32) not null,
    description varchar(256),
    is_active boolean not null
);
--rollback drop table personal.departments;