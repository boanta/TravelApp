use travel;

create table if not exists Users (
id integer not null auto_increment,
username varchar(50) not null,
password varchar(50) not null,
role varchar(50) not null,
primary key(id));

insert into Users (username,password,role) values 
("admin","admin","admin");
insert into Users (username,password,role) values
("emp","emp","employee");
insert into Users (username,password,role) values
("ion","ion","employee");


create table if not exists Clients (
id integer not null auto_increment,
username varchar(50) not null,
password varchar(50) not null,
mail varchar(50) not null,
primary key(id));

insert into Clients(username,password,mail) values
("ciprian","123","boanta.ciprian@yahoo.com");
insert into Clients(username,password,mail) values
("alex","123","alex@gmail.com");

create table if not exists Vacation (
id integer not null auto_increment,
country varchar(50) not null,
type varchar(50) not null,
space integer not null,
primary key(id));

insert into Vacation (country,type,space) values
("Romania","tour",10);
insert into Vacation (country,type,space) values
("Franta","stay",50);

create table if not exists Stay (
id integer not null auto_increment,
vacationId integer not null,
sight varchar(50) not null,
primary key(id));

insert into Stay (vacationId,sight) values
(2,"Paris");
insert into Stay (vacationId,sight) values
(2,"Muzeu");


create table if not exists ClientVacation (
id integer not null auto_increment,
clientId integer not null,
vacationId integer not null,
primary key(id));

insert into ClientVacation (clientId,vacationId) values
(1,2);

create table if not exists Reservation (
id integer not null auto_increment,
clientId integer not null,
vacationId integer not null,
primary key(id));

insert into Reservation (clientId,vacationId) values
(1,2);

