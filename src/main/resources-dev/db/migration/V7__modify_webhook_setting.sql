alter table tb_viber_webhook_setting add column set_on timestamp default now();
alter table tb_viber_webhook_setting modify set_on timestamp default null;