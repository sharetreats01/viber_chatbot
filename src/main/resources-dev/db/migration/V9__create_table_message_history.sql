create table tb_message_history
(
    session_id binary(16) primary key  not null,
    type       varchar(10)             not null,
    user_id    varchar(255)            not null,
    content    varchar(255)            not null,
    direction  varchar(10)             not null,
    timestamp  timestamp default now() not null
);