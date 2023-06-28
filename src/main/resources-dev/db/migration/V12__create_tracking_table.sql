create table tb_user_session
(
    session_id binary(16) primary key not null,
    user_id    varchar(255)           not null,
    start_time timestamp              not null,
    end_time   timestamp
);

create table tb_user_activity
(
    id              bigint auto_increment primary key,
    session_id      binary(16)  not null,
    event_type      varchar(10) not null,
    event_data      varchar(50) not null,
    event_timestamp timestamp   not null,
    foreign key (session_id) references tb_user_session (session_id)
);