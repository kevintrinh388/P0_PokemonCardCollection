-- CARD TYPES: (1 = Pokemon), (2 = Trainer), (3 = Energy)
CREATE TABLE card_types(
	card_type_id serial PRIMARY KEY,
	card_type_name TEXT
);
INSERT INTO card_types (card_type_name) VALUES ('Pokemon'),('Trainer'),('Energy');
SELECT * FROM card_types;


-- CONDITIONS: (1 = Mint), (2 = Near Mint), (3 = Lightly Played), (4 = Moderately Played), (5 = Heavily Played), (6 = Damaged)
CREATE TABLE card_conditions (
	card_condition_id serial PRIMARY KEY,
	card_condition_name TEXT
);
INSERT INTO card_conditions (card_condition_name) 
VALUES ('Mint'),
       ('Near Mint'),
	   ('Lightly Played'),
	   ('Moderately Played'),
	   ('Heavily Played'),
	   ('Damaged');
SELECT * FROM card_conditions;


-- RARITIES: (1 = Secret Rare), (2 = Ultra Rare), (3 = Rare), (4 = Uncommon), (5 = Common)
CREATE TABLE card_rarities (
	card_rarity_id serial PRIMARY KEY,
	card_rarity_name TEXT
);
INSERT INTO card_rarities (card_rarity_name)
VALUES ('Secret Rare'),
       ('Ultra Rare'),
       ('Rare'),
       ('Uncommon'),
       ('Common');
SELECT * FROM card_rarities;


-- Pokemon Card
CREATE TABLE pokemon_cards (
	pokemon_card_id serial PRIMARY KEY,
	pokemon_card_name TEXT,
	pokemon_card_price decimal(7,2),
	pokemon_card_number TEXT,
	pokemon_card_set TEXT,
	pokemon_card_rarity_fk int REFERENCES card_rarities(card_rarity_id),
	pokemon_card_condition_fk int REFERENCES card_conditions(card_condition_id),
	pokemon_card_type_fk int REFERENCES card_types(card_type_id),
	pokemon_card_user_fk int REFERENCES users(user_id)
);
INSERT INTO pokemon_cards 
(pokemon_card_name, pokemon_card_price, pokemon_card_number, pokemon_card_set,
 pokemon_card_rarity_fk, pokemon_card_condition_fk, pokemon_card_type_fk, pokemon_card_user_fk)
VALUES ('Scramble Energy',1.00,'89/101','EX Dragon Frontiers',4,4,3,1),
       ('Mom''s Kindness',0.02,'83/100','Majestic Dawn',4,2,2,1),
       ('Unown',0.25,'65/123','Mysterious Treasures',4,2,1,1),
       ('Spiritomb',1.95,'112/214','Unbroken Bonds',3,2,1,1),
       ('Celesteela GX',2.47,'163/214','Unbroken Bonds',2,2,1,1);
SELECT * FROM pokemon_cards;


-- Users
CREATE TABLE users (
	user_id serial PRIMARY KEY,
	username TEXT UNIQUE,
	PASSWORD TEXT
);
INSERT INTO users (username, password)
VALUES ('Kevin','12345'),
       ('Bob','54321');
SELECT * FROM users;


