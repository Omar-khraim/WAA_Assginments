insert into users ( name)
values ('Omar');


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