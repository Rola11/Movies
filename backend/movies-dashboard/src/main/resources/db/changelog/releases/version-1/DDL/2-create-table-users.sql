--liquibase formatted sql
--changeset Rola:"create users" labels:ddl
CREATE TABLE users (
                        id BIGSERIAL PRIMARY KEY,
                        username VARCHAR(255) NOT NULL UNIQUE,
                        password VARCHAR(255) NOT NULL,
                        role VARCHAR(255) NOT NULL
);