CREATE SCHEMA `ems_schema` ;

CREATE TABLE ems_schema.DEPARTMENT(
    id VARCHAR(36) default (uuid()) not null primary key,
    department_name varchar(255) NOT NULL,
    UNIQUE (department_name)
);

CREATE TABLE ems_schema.ROLE(
    id VARCHAR(36) default (uuid()) not null primary key,
    role_name varchar(255) NOT NULL,
    UNIQUE (role_name)
);

create table ems_schema.employee
(
    id VARCHAR(36) default (uuid()) not null primary key,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    username VARCHAR(255) not null,
    password VARCHAR(255) not null,
    email varchar(255) not null,
    department_id VARCHAR(36) not null,
    role_id VARCHAR(36) not null,
    unique (email),
    unique (username),
    FOREIGN KEY(department_id) REFERENCES ems_schema.DEPARTMENT(id),
    FOREIGN KEY(role_id) REFERENCES ems_schema.ROLE(id)
);