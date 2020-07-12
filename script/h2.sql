create sequence hibernate_sequence start with 1 increment by 1;

    create table Product (
       id integer not null,
        name varchar(255),
        price double not null,
        primary key (id)
    );

    create table User (
       id integer not null,
        age integer not null,
        email varchar(255) not null,
        name varchar(255),
        primary key (id)
    );

    alter table User 
       add constraint UK_e6gkqunxajvyxl5uctpl2vl2p unique (email);
