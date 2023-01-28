
insert into users (email, first_name, last_name, password)
values ('oaskhraim@gmail.com', 'Omar', 'Amjed', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2');
insert into users (email, first_name, last_name, password)
values ('amdofree@gmail.com', 'Ahmad', 'Baker', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2');


insert into post (author, content, title, user_id)
values ('Author1', 'content1', 'Post1', 1);
insert into post (author, content, title, user_id)
values ('Author2', 'content2', 'post2', 1);


insert into public.comment (name, post_id)
values ('comment1' , 1);
insert into public.comment (name, post_id)
values ('comment2' , 1);
insert into public.comment (name, post_id)
values ('comment3' , 2);


insert into public.role (role)
values ('Admin');
insert into public.role (role)
values ('Client');

insert into user_role (user_id, role_id)
values (1,1);
insert into user_role (user_id, role_id)
values (2,2);