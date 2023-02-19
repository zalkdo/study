insert into `USER` (id, name, joindate, password, ssn) values (90001, 'User1', current_date(), 'test1111', '701010-1234567');
insert into `USER` (id, name, joindate, password, ssn) values (90002, 'User2', current_date(), 'test2222', '801010-1234567');
insert into `USER` (id, name, joindate, password, ssn) values (90003, 'User3', current_date(), 'test3333', '901010-1234567');

insert into POST (id, description, user_id) values (10001, 'My first post', 90001);
insert into POST (id, description, user_id) values (10002, 'My second post', 90001);
