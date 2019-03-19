create database fmusic default charset=utf8;

use fmusic;

create table user(
id int primary key auto_increment,
username varchar(15) not null,
password varchar(50) not null,
email varchar(40) not null,
url varchar(64) not null,
state varchar(2) not null,
sex varchar(2) not null,
age int not null,
birthday date not null,
hobby varchar(20),
phone varchar(15),
address varchar(30),
validatecode varchar(64),
outdate datetime,
power tinyint default 0
);


create table resource (
id int primary key auto_increment not null,
magnet varchar(70) not null
);

create table music
 (id int primary key auto_increment,
 name varchar(30) not null,
 path varchar(100) not null));