--liquibase formatted sql

--changeset v-lyutin:create-positions-table
--comment create table personal.positions
create table personal.positions (
    id uuid primary key,
    display_name varchar(32) not null,
    description varchar(256),
    team_id uuid not null,
    foreign key (team_id) references personal.teams (id) on delete cascade
);
--rollback drop table personal.positions;