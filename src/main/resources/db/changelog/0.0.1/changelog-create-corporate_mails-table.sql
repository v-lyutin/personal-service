--liquibase formatted sql

--changeset v-lyutin:create-corporate_mails-table
--comment create table personal.corporate_mails
create table personal.corporate_mails (
    id uuid primary key,
    address varchar(255) not null unique,
    employee_id uuid not null,
    foreign key (employee_id) references personal.staff(id) on delete cascade
);
--rollback drop table personal.corporate_mails;