alter table tb_message_template modify column created_at timestamp default now();
alter table tb_message_template modify column modified_at timestamp default now();