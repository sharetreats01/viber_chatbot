alter table sharetreats.tb_user
    add column primary_device_os varchar(20) not null;
alter table sharetreats.tb_user
    add column viber_version varchar(20) not null;
alter table sharetreats.tb_user
    add column device_type varchar(20) not null;
alter table sharetreats.tb_user
    add column mobile_country_code int(2) not null;
alter table sharetreats.tb_user
    add column mobile_network_code int(2) not null;