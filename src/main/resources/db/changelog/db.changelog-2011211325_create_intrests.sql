--liquibase formatted sql

--changeset wawaw:0001
create table persona_intrests (
    id int primary key auto_increment,
    outdoors int,
    travel_enthusiasts int,
    movie_goer int,
    tech_enthusiasts int,
    fitness_enthusiasts int,
    luxuries int,
    created datetime,
    updated datetime,
    created_by varchar(50),
    status int
);
--rollback drop table test