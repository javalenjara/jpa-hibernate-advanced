insert into course(id, name, created_date, last_updated_date) values (1001L, 'JPA course', sysdate(),sysdate());
insert into course(id, name, created_date, last_updated_date) values (1002L, 'Spring course', sysdate(), sysdate());
insert into course(id, name, created_date, last_updated_date) values (1003L, 'Spring Boot course', sysdate(), sysdate());

insert into passport(id, number) values (4001, 'E123456');
insert into passport(id, number) values (4002, 'N123456');
insert into passport(id, number) values (4003, 'L123890');

insert into student(id, name, passport_id) values (2001, 'Jhon', 4001);
insert into student(id, name, passport_id) values (2002, 'Jorge', 4002);
insert into student(id, name, passport_id) values (2003, 'Clara', 4003);

insert into review(id, rating, description, course_id) values (5001, '5', 'Great course', 1001);
insert into review(id, rating, description, course_id) values (5002, '4', 'Wonderful course', 1001);
insert into review(id, rating, description, course_id) values (5003, '5', 'Awesome course', 1003);