
postgres DB init

CREATE USER loyaltyweb WITH PASSWORD 'loyaltyweb';
create database loyaltyweb;
GRANT ALL PRIVILEGES ON DATABASE loyaltyweb to loyaltyweb;

then connect as loyaltyweb user

CREATE TABLE product_list
(
  id integer NOT NULL,
  price real,
  product_name character varying(255),
  provider_name character varying(255),
  CONSTRAINT product_list_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE product_list
  OWNER TO loyaltyweb;

INSERT INTO product_list(
            id, price, product_name, provider_name)
    VALUES (1, 1.5, 'Evian', 'Evian');

INSERT INTO product_list(
            id, price, product_name, provider_name)
    VALUES (2, 25.25, 'Pampers', 'Pampers');

INSERT INTO product_list(
            id, price, product_name, provider_name)
    VALUES (3, 12.5, '1664 Beer', 'Heineken');

INSERT INTO product_list(
            id, price, product_name, provider_name)
    VALUES (4, 25.25, 'Chedar cheese', 'AxonIvy');

INSERT INTO product_list(
            id, price, product_name, provider_name)
    VALUES (5, 5.0, 'Clone Wars', 'Lucas');

INSERT INTO product_list(
            id, price, product_name, provider_name)
    VALUES (6, 500.25, 'XBOX', 'Microsoft');

INSERT INTO product_list(
            id, price, product_name, provider_name)
    VALUES (7, 55.5, 'Requiem Mozart', 'Philips');

INSERT INTO product_list(
            id, price, product_name, provider_name)
    VALUES (8, 65.5, 'Hair Shampoon', 'I AM WORTH IT');

INSERT INTO product_list(
            id, price, product_name, provider_name)
    VALUES (9, 25.0, 'Orance Juice water', 'Self Made Corportation');

INSERT INTO product_list(
            id, price, product_name, provider_name)
    VALUES (10, 25.25, 'Red Wine', 'Bordeaux');
