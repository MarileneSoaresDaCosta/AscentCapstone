--/* run command from regular terminal: psql <username> -d pets -f schema.sql */
--run command from psql cli: \i /Users/meredithwhite/JavaScript/vmWareAscent/petconnect-search/schema.sql

-- /* Reset */
DROP DATABASE IF EXISTS petsProfiles;
CREATE DATABASE petsProfiles;

-- ==== THIS IS JUST AN EXAMPLE / CHANGE SCHEMA TO REFLECT CURRENT PROJECT ===
--/* Table 'pets' */
DROP TABLE IF EXISTS pets;

CREATE TABLE pets(
  id serial NOT NULL,
  name varchar(255) NOT NULL,
  type varchar(255) NOT NULL,
  zip varchar(255) NOT NULL,
  age varchar(255) NOT NULL,
  gender varchar(255) NOT NULL,
  breed varchar(255) NOT NULL,
  PRIMARY KEY(id)
);

INSERT INTO pets(id, name, type, zip, age, gender, breed)
VALUES (DEFAULT, 'Mr. Whiskers', 'cat', '98745', 'young', 'female', 'ragdoll');

INSERT INTO pets(id, name, type, zip, age, gender, breed)
VALUES (DEFAULT, 'Beans', 'cat', '95745', 'adult', 'male', 'bengal');

INSERT INTO pets(id, name, type, zip, age, gender, breed)
VALUES (DEFAULT, 'Baguera', 'cat', '88745', 'senior', 'female', 'british shorthair');

INSERT INTO pets(id, name, type, zip, age, gender, breed)
VALUES (DEFAULT, 'Bitey McNibble', 'cat', '78745', 'young', 'male', 'devon rex');

INSERT INTO pets(id, name, type, zip, age, gender, breed)
VALUES (DEFAULT, 'Sam', 'dog', '98745', 'adult', 'male', 'bulldog');

INSERT INTO pets(id, name, type, zip, age, gender, breed)
VALUES (DEFAULT, 'Bark Twain', 'dog', '68745', 'senior', 'female', 'golden retriever');

INSERT INTO pets(id, name, type, zip, age, gender, breed)
VALUES (DEFAULT, 'Buster', 'dog', '58745', 'young', 'female', 'husky');

INSERT INTO pets(id, name, type, zip, age, gender, breed)
VALUES (DEFAULT, 'Chewy', 'dog', '48745', 'adult', 'male', 'corgi');
