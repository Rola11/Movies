--liquibase formatted sql
--changeset Rola:"create movies" labels:dml
CREATE TABLE movies (
                        id BIGSERIAL PRIMARY KEY,
                        title VARCHAR(255) NOT NULL,
                        year INT NOT NULL,
                        type VARCHAR(255) NOT NULL
);
