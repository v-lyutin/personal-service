--liquibase formatted sql

--changeset v-lyutin:create-staff-table
--comment create table personal.staff
create table personal.staff (
    id uuid primary key,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    middle_name varchar(255),
    date_of_birth date not null,
    gender varchar(10) not null,
    country_of_residence varchar(255) not null,
    region_of_residence varchar(255) not null,
    contacts varchar(255) not null,
    is_dismissed boolean not null,
    date_of_dismissal date
);
--rollback drop table personal.staff;