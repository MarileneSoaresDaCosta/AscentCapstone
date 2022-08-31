/* run command: psql <username> - h 127.0.0.1 - d petsProfiles - f schema.sql */

-- /* Reset */
DROP DATABASE pets IF EXISTS;
CREATE petsProfiles;


-- ==== THIS IS JUST AN EXAMPLE / CHANGE SCHEMA TO REFLECT CURRENT PROJECT ===
/* Table 'pets' */
CREATE TABLE pets(
  id serial NOT NULL,
  name varchar(255) NOT NULL,
  type varchar(255) NOT NULL,
  zip varchar(255) NOT NULL,
  PRIMARY KEY(id)
);


-- populate db with sample data:
INSERT INTO profiles(id, name, type, zip)
VALUES (DEFAULT, 'Mr. Whiskers', 'cat', '98745');

INSERT INTO profiles(id, name, type, zip)
VALUES (DEFAULT, 'Beans', 'cat', '95745');

INSERT INTO profiles(id, name, type, zip)
VALUES (DEFAULT, 'Baguera', 'cat', '88745');

INSERT INTO profiles(id, name, type, zip)
VALUES (DEFAULT, 'Bitey McNibble', 'cat', '78745');


INSERT INTO profiles(id, name, type, zip)
VALUES (DEFAULT, 'Sam', 'dog', '98745');

INSERT INTO profiles(id, name, type, zip)
VALUES (DEFAULT, 'Bark Twain', 'dog', '68745');

INSERT INTO profiles(id, name, type, zip)
VALUES (DEFAULT, 'Buster', 'dog', '58745');

INSERT INTO profiles(id, name, type, zip)
VALUES (DEFAULT, 'Chewy', 'dog', '48745');

