create table IF NOT EXISTS odontologo(id bigint auto_increment primary key, name varchar(255), lastName varchar(255), enrolment int);
create table IF NOT EXISTS paciente(id bigint auto_increment primary key, name varchar(255), lastName varchar(255), home varchar(255), dni INT, date DATE);