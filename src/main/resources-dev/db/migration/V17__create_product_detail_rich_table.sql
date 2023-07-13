create table tb_viber_product_detail_rich_media
(
    id           bigint auto_increment primary key,
    brand        varchar(50) not null,
    product_name varchar(50) not null,
    data         text        not null
);