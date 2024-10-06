--liquibase formatted sql

--changeset v-lyutin:create-teams-table
--comment create table personal.teams
create table personal.teams (
    id uuid primary key,
    display_name varchar(32) not null,
    description varchar(256),
    is_active boolean not null,
    department_id uuid not null,
    foreign key (department_id) references personal.departments (id) on delete cascade
);
--rollback drop table personal.teams;