CREATE TABLE USERS (
  ID NUMBER NOT NULL PRIMARY KEY,
  FIRST_NAME VARCHAR(32) NOT NULL,
  LAST_NAME VARCHAR(32) NOT NULL,
  AGE NUMBER
);

CREATE TABLE PRODUCT (
  ID NUMBER NOT NULL PRIMARY KEY,
  NAME VARCHAR(64) NOT NULL,
  PRICE NUMBER NOT NULL,
  CATEGORY VARCHAR(16) NOT NULL,
  GENDER VARCHAR(8) NOT NULL,
  COLOR VARCHAR(16) NOT NULL,
  SIZE VARCHAR(8) NOT NULL,
  REMAINING_COUNT NUMBER NOT NULL
);