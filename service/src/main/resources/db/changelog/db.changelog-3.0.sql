--liquibase formatted sql

--changeSet vdovmb:1
ALTER TABLE users
ADD COLUMN image VARCHAR(32);

--changeset vdovmb:2
ALTER TABLE users_aud
ADD COLUMN image VARCHAR(32);




