create table tb_viber_webhook_setting
(
    id                   int primary key auto_increment,
    url                  varchar(255) not null,
    delivered            bit(1)    default 0,
    seen                 bit(1)    default 0,
    failed               bit(1)    default 0,
    subscribed           bit(1)    default 0,
    unsubscribed         bit(1)    default 0,
    conversation_started bit(1)    default 0,
    send_name            bit(1)    default 0,
    send_photo           bit(1)    default 0,
    is_set               bit(1)    default 0,
    created_at           timestamp default now()
);