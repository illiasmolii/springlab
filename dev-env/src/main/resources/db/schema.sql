CREATE DATABASE springlab;
use springlab;

CREATE TABLE USERS (
                       ID INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
                       FIRST_NAME VARCHAR(32) NOT NULL,
                       LAST_NAME VARCHAR(32) NOT NULL,
                       AGE INTEGER
);

CREATE TABLE PRODUCTS (
                          ID INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
                          NAME VARCHAR(64) NOT NULL,
                          PRICE INTEGER NOT NULL,
                          CATEGORY VARCHAR(16) NOT NULL,
                          GENDER VARCHAR(8) NOT NULL,
                          COLOR VARCHAR(16) NOT NULL,
                          SIZE VARCHAR(8) NOT NULL,
                          REMAINING_COUNT INTEGER NOT NULL
);

CREATE TABLE ORDERS (
                        ID INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
                        USER_ID INTEGER NOT NULL,
                        FOREIGN KEY (USER_ID) REFERENCES USERS(ID)
);

CREATE TABLE ORDER_ITEMS (
                             ORDER_ID INTEGER NOT NULL,
                             PRODUCT_ID INTEGER NOT NULL,
                             COUNT INTEGER NOT NULL,
                             FOREIGN KEY (ORDER_ID) REFERENCES ORDERS(ID),
                             FOREIGN KEY (PRODUCT_ID) REFERENCES PRODUCTS(ID)
);