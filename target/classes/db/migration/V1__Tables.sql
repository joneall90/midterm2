create table product (
    product_id int not null AUTO_INCREMENT,
    product_name varchar(100) not null,
    PRIMARY KEY (product_id)
);

create table comment (
    comment_id int not null AUTO_INCREMENT,
    review_id int not null,
    comment varchar(500) not null,
    PRIMARY KEY (comment_id)
);

create table reviews (
    review_id int not null AUTO_INCREMENT,
    product_id int not null,
    review varchar(500),
    PRIMARY KEY (review_id)
);