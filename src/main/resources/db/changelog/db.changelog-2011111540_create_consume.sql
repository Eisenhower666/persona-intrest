--liquibase formatted sql

--changeset xbyi:0001
create table persona_consume (
    id int primary key auto_increment,
    business_travel int,
    overseas_travel int,
    relax_travel int,
    catering int,
    car int,
    mother int,
    financial int,
    created datetime,
    updated datetime,
    created_by varchar(50),
    status int
);
--rollback drop table test