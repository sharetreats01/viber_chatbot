create table tb_sharetreats_category
(
    id            int auto_increment primary key,
    category_name varchar(10) not null
);

create table tb_sharetreats_brand
(
    id          int auto_increment primary key,
    category_id int          not null,
    brand_name  varchar(100) not null,
    brand_image varchar(255),
    foreign key (category_id) references tb_sharetreats_category (id)
);

create table tb_sharetreats_product
(
    id           bigint auto_increment primary key,
    brand_id     int          not null,
    category_id  int          not null,
    product_name varchar(255) not null,
    amount       int          not null,
    stock        int,
    expiration   varchar(50)  not null,
    foreign key (brand_id) references tb_sharetreats_brand (id),
    foreign key (category_id) references tb_sharetreats_category (id)
);