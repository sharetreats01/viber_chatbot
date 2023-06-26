alter table tb_viber_webhook_setting drop delivered;
alter table tb_viber_webhook_setting drop seen;
alter table tb_viber_webhook_setting drop failed;
alter table tb_viber_webhook_setting drop subscribed;
alter table tb_viber_webhook_setting drop unsubscribed;
alter table tb_viber_webhook_setting drop conversation_started;
alter table tb_viber_webhook_setting add column event_types varchar(100) default null;