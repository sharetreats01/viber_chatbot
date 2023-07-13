create table tb_treat_message_template
(
    id          bigint auto_increment primary key,
    type        varchar(10)  not null,
    constant    varchar(10)  not null,
    template    varchar(255) not null,
    created_at  timestamp default now(),
    modified_at timestamp default now(),
    version     int          not null
)