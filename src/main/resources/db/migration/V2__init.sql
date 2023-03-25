alter table appuser add approles text null;

create table if not exists approles
(
    id       uuid primary key,
    name text,
    appuser text
);

create table if not exists appuser_approles
(
    appuser_id      uuid references appuser(id),
    approles_id     uuid references approles(id),
    CONSTRAINT appuser_approles_pkey PRIMARY KEY(appuser_id, approles_id)
);
