--=======For Creating User (Schema)==============================
CREATE USER MicroserviceStudyWithJavaGuide IDENTIFIED BY hossein;
GRANT ALL PRIVILEGES TO MicroserviceStudyWithJavaGuide;
--=======For Creating Entity Table===============================
create table student (
     id number(19,0) generated as identity,
     email varchar2(255 char) not null,
     first_name varchar2(255 char) not null,
     last_name varchar2(255 char) not null,
     primary key (id)
);