create table if not exists app_user
(
    id       uuid primary key,
    username text,
    password text
);

insert into app_user
values ('eb2c7d26-c76a-11ed-8ad7-d3fb31520fc8', 'admin', '{noop}admin');

create table if not exists app_role
(
    id   uuid primary key,
    name text
);

insert into app_role
values ('d79ce9b2-dc46-11ed-9dfb-13e1171c3c12', 'ADMIN');
values ('1fef696e-dc48-11ed-8e47-eff69f75fa5c', 'STUFF');

create table if not exists app_user_app_role
(
    app_user_id uuid,
    app_role_id uuid,
    primary key (app_user_id, app_role_id)
);

insert into app_user_app_role
values ('eb2c7d26-c76a-11ed-8ad7-d3fb31520fc8', 'd79ce9b2-dc46-11ed-9dfb-13e1171c3c12');