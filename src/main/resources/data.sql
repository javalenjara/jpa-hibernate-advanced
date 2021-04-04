insert into course(id, name, created_date, last_updated_date) values (1001L, 'JPA course', sysdate(),sysdate());
insert into course(id, name, created_date, last_updated_date) values (1002L, 'Spring course', sysdate(), sysdate());
insert into course(id, name, created_date, last_updated_date) values (1003L, 'Spring Boot course', sysdate(), sysdate());

insert into student(id, name) values (2001, 'Jhon');
insert into student(id, name) values (2002, 'Jorge');
insert into student(id, name) values (2003, 'Clara');

insert into passport(id, number) values (4001, 'E123456');
insert into passport(id, number) values (4002, 'N123456');
insert into passport(id, number) values (4003, 'L123890');

insert into review(id, rating, description) values (5001, '5', 'Great course');
insert into review(id, rating, description) values (5002, '4', 'Wonderful course');
insert into review(id, rating, description) values (5003, '5', 'Awesome course');