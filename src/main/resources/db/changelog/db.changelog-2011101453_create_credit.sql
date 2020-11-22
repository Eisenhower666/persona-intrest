--liquibase formatted sql

--changeset xbyi:0001
create table persona_credit (
    id int primary key auto_increment,
    job varchar(50),
    income double,
    capital double,
    debt double,
    education int,
    score double,
    created datetime,
    updated datetime,
    created_by varchar(50),
    status int
);
--rollback drop table test