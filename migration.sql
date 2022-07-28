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

CREATE TABLE category_and_ads
(
    id          INT UNSIGNED NOT NULL AUTO_INCREMENT,
    ad_id       INT UNSIGNED NOT NULL,
    category_id INT UNSIGNED NOT NULL,
    ad_desc VARCHAR(255) NOT NULL,
    primary key (id),
    FOREIGN KEY (ad_id) REFERENCES ads (id),
    FOREIGN KEY (category_id) REFERENCES category (id)
);



# SELECT category.name AS Category, a.title as Title, a.description AS Description
# FROM category
#          JOIN category_and_ads caa on category.id = caa.category_id
#          JOIN ads a on caa.ad_id = a.id;
#
#
# SELECT category.name AS Category, a.title AS Title, a.description AS Description
# FROM category
# JOIN category_and_ads caa on category.id = caa.category_id
# JOIN adlister_db.category c on c.id = caa.category_id
# JOIN ads a on caa.ad_id = a.id;


SELECT a.id,c.name,a.title,a.description
FROM ads AS a
JOIN category_and_ads caa on a.id = caa.ad_id
JOIN category c on caa.category_id = c.id;

SELECT a.id,c.name,a.title,a.description,a.user_ID
                FROM ads AS a
                JOIN category_and_ads caa on a.id = caa.ad_id
                JOIN category c on caa.category_id = c.id
                WHERE a.title LIKE '%cookie%';

SELECT * FROM ads WHERE title LIKE '%cookie%' OR description LIKE '%cookie%';


