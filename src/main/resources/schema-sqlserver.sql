DROP DATABASE IF EXISTS customer;
CREATE DATABASE customer;
ALTER DATABASE customer SET AUTO_CLOSE OFF;
USE customer;

CREATE table customer
(
    id         INT IDENTITY(1,1),
    first_name VARCHAR(255),
    last_name  VARCHAR(255)
);
