create table member (
email varchar(100) not null,
pwd varchar(1000) not null,
nick_name varchar(100) not null,
reg_at datetime default current_timestamp,
last_login datetime default null,
grade tinyint default '10',
primary key(email)
) default CHARSET=utf8mb4;

create table comment(
cno bigint not null auto_increment,
pno bigint not null,
writer varchar(100) not null,
content varchar(2000) not null,
reg_at datetime default current_timestamp,
mod_at datetime default current_timestamp,
primary key (cno)
) default CHARSET=utf8mb4;

create table board (
bno bigint not null auto_increment,
title varchar(200) not null,
content text not null,
writer varchar(100) not null,
reg_at datetime default now(),
mod_at datetime default now(),
read_count int(10) default 0,
primary key (bno)
);

create table comment (
cno bigint not null auto_increment,
pno bigint not null,
writer varchar(100) not null,
content varchar(2000) not null,
reg_at datetime default current_timestamp,
mod_at datetime default current_timestamp,
primary key (cno)
) default CHARSET=utf8mb4;

create table attached_file(
uuid varchar(256) primary key,
save_dir varchar(1000) not null,
file_name varchar(1000) not null,
file_type tinyint(1) default 0,
pno bigint not null,
file_size bigint not null,
reg_at datetime default current_timestamp
) default CHARSET=utf8mb4;