create table tb_user
(
    id          varchar(255) primary key,
    name        varchar(255) not null,
    avatar      varchar(255),
    country     varchar(10),
    language    varchar(10),
    api_version int
);

create table tb_message_template
(
    id          int primary key auto_increment,
    name        varchar(255) not null,
    template    varchar(255) not null,
    language    varchar(10)  not null,
    created_at  timestamp    not null,
    modified_at timestamp    not null
);