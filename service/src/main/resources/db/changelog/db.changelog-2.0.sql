--liquibase formatted sql

--changeSet vdovmb:8
CREATE TABLE revision
(
    id        SERIAL PRIMARY KEY,
    timestamp BIGINT NOT NULL
);

--changeset vdovmb:9
CREATE TABLE users_aud
(
    id       INTEGER  NOT NULL,
    rev      INTEGER  NOT NULL,
    revtype  SMALLINT NOT NULL,
    name     VARCHAR(255),
    login    VARCHAR(255),
    password VARCHAR(255),
    role     VARCHAR(255),
    PRIMARY KEY (id, rev),
    CONSTRAINT fk_users_aud_rev FOREIGN KEY (rev) REFERENCES revision (id)
);


