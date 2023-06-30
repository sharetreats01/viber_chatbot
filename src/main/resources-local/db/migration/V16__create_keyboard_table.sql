create table tb_viber_keyboard
(
    id            int auto_increment primary key,
    keyboard_type varchar(10) not null,
    keyboard_desc varchar(50) not null
);

create table tb_viber_keyboard_version
(
    id               int auto_increment primary key,
    keyboard_id      int       not null,
    keyboard_version int       not null,
    data             text      not null,
    created_at       timestamp not null,
    foreign key (keyboard_id) references tb_viber_keyboard (id)
);