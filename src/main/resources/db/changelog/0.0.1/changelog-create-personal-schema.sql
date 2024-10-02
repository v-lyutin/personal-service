--liquibase formatted sql

--changeset v-lyutin:create personal schema
--comment create personal schema
create schema personal;
--rollback drop schema personal;