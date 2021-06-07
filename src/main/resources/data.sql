-- noinspection SqlResolveForFile

insert into course(id, name, created_date, last_updated_date, is_deleted) values (1001, 'JPA course', sysdate(),sysdate(), false);
insert into course(id, name, created_date, last_updated_date, is_deleted) values (1002, 'Spring course', sysdate(), sysdate(), false);
insert into course(id, name, created_date, last_updated_date, is_deleted) values (1003, 'Generic course 1', sysdate(), sysdate(), false);
insert into course(id, name, created_date, last_updated_date, is_deleted) values (1004, 'Generic course 2', sysdate(), sysdate(), false);

insert into passport(id, number) values (4001, 'E123456');
insert into passport(id, number) values (4002, 'N123456');
insert into passport(id, number) values (4003, 'L123890');

insert into student(id, name, passport_id) values (2001, 'Jhon', 4001);
insert into student(id, name, passport_id) values (2002, 'Jorge', 4002);
insert into student(id, name, passport_id) values (2003, 'Clara', 4003);

insert into review(id, rating, description, course_id) values (5001, '5', 'Great course', 1001);
insert into review(id, rating, description, course_id) values (5002, '4', 'Wonderful course', 1001);
insert into review(id, rating, description, course_id) values (5003, '5', 'Awesome course', 1003);

insert into student_course(student_id, course_id) values (2001, 1001);
insert into student_course(student_id, course_id) values (2002, 1001);
insert into student_course(student_id, course_id) values (2003, 1001);
insert into student_course(student_id, course_id) values (2001, 1003);