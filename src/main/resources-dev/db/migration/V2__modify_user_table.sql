alter table tb_user
    add is_subscribe bit(1) DEFAULT 1 NOT NULL;

create table tb_message_template_placeholder
(
    id          bigint unsigned primary key auto_increment,
    template_id int         not null,
    name        varchar(10) not null,
    foreign key (template_id) references tb_message_template (id)
);

alter table tb_message_template
    change name type varchar(10);

alter table tb_message_template
    add version int;