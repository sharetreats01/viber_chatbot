create table tb_viber_products_rich_media
(
    id         int auto_increment primary key,
    brand      varchar(50) not null,
    brand_desc varchar(50) not null,
    data       text        not null
);