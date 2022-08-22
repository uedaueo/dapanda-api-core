create database sample;
use sample;
create table user (
    user_id varchar(254) NOT NULL, 
    password varchar(64) NOT NULL, 
    created_at datetime NOT NULL default current_timestamp,
    updated_at timestamp NOT NULL default current_timestamp on update current_timestamp,
    PRIMARY KEY (user_id)
    );

create table token (
    user_id varchar(254) NOT NULL, 
    token varchar(50) NOT NULL,
    expired_at datetime NOT NULL default current_timestamp,
    created_at datetime NOT NULL default current_timestamp,
    updated_at timestamp NOT NULL default current_timestamp on update current_timestamp,
    PRIMARY KEY (user_id)
    );