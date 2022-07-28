USE adlister_db;

DROP TABLE IF EXISTS ads;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS category_and_ads;

CREATE TABLE users
(
    id       INT UNSIGNED        NOT NULL AUTO_INCREMENT,
    username VARCHAR(240) UNIQUE NOT NULL,
    email    VARCHAR(240)        NOT NULL,
    password VARCHAR(255)        NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE ads
(
    id          INT UNSIGNED NOT NULL AUTO_INCREMENT,
    user_id     INT UNSIGNED NOT NULL,
    title       VARCHAR(240) NOT NULL,
    description TEXT         NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users (id)

);

CREATE TABLE category
(
    id   INT UNSIGNED NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO category (name)
VALUES ('Music'),
       ('Games'),
       ('Jobs'),
       ('Food'),
       ('Selling'),
       ('Anime'),
       ('Other');

# CREATE TABLE category_and_ads
# (
#     id          INT UNSIGNED NOT NULL AUTO_INCREMENT,
#     ad_id       INT UNSIGNED NOT NULL,
#     category_id INT UNSIGNED NOT NULL,
#     primary key (id)
# #     FOREIGN KEY (ad_id) REFERENCES ads (id),
# #     FOREIGN KEY (category_id) REFERENCES category (id)
# );
#
#
#
# SELECT category.name AS Category, a.title as Title, a.description AS Description
# FROM category
#          JOIN category_and_ads caa on category.id = caa.category_id
#          JOIN ads a on caa.ad_id = a.id



