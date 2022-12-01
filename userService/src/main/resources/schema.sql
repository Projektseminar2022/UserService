CREATE TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY KEY,
    lastName varchar(255),
    city varchar(255),
    country varchar(255),
    password varchar(255),
    firstName varchar(255),
    email varchar(255)
    );