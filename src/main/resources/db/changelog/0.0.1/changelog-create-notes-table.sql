--liquibase formatted sql

--changeset v-lyutin:create-notes-table
--comment create table personal.notes
create table personal.notes (
    id uuid primary key,
    text varchar(256) not null,
    created_at timestamp not null,
    edited_at timestamp not null,
    employee_id uuid not null,
    foreign key (employee_id) references personal.staff(id) on delete cascade
);
--rollback drop table personal.notes;