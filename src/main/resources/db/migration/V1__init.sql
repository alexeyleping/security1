create table if not exists appuser
(
    id       uuid primary key,
    username text,
    password text
);

insert into appuser values ('eb2c7d26-c76a-11ed-8ad7-d3fb31520fc8','admin','{noop}admin')