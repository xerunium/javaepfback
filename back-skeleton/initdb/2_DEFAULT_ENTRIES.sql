INSERT INTO categorie (id, nom_categorie) VALUES (1, 'Guerre');
INSERT INTO categorie (id, nom_categorie) VALUES (2, 'Mario');
INSERT INTO categorie (id, nom_categorie) VALUES (3, 'Pain');
INSERT INTO categorie (id, nom_categorie) VALUES (4, 'Logo');

INSERT INTO choix (id, categorie_id, description) VALUES (1, 1, '1ère guerre mondiale');
INSERT INTO choix (id, categorie_id, description) VALUES (2, 1, '2ème guerre mondiale');
INSERT INTO choix (id, categorie_id, description) VALUES (3, 1, 'guerre corée');
INSERT INTO choix (id, categorie_id, description) VALUES (4, 1, 'guerre vietnam');
INSERT INTO choix (id, categorie_id, description) VALUES (5, 2, 'Mario galaxy');
INSERT INTO choix (id, categorie_id, description) VALUES (6, 2, 'mario kart');
INSERT INTO choix (id, categorie_id, description) VALUES (7, 2, 'mario bros wander');
INSERT INTO choix (id, categorie_id, description) VALUES (8, 2, 'New Super Mario Bros');
INSERT INTO choix (id, categorie_id, description) VALUES (9, 3, 'pain de seigle');
INSERT INTO choix (id, categorie_id, description) VALUES (10, 3, 'Pain couronne bordelaise');
INSERT INTO choix (id, categorie_id, description) VALUES (11, 3, 'Pain couronne lyonnaise');
INSERT INTO choix (id, categorie_id, description) VALUES (12, 3, 'pain au levain');
INSERT INTO choix (id, categorie_id, description) VALUES (13, 3, 'pain méteil');
INSERT INTO choix (id, categorie_id, description) VALUES (14, 4, 'Takima');
INSERT INTO choix (id, categorie_id, description) VALUES (15, 4, 'Capgemini');
INSERT INTO choix (id, categorie_id, description) VALUES (16, 4, 'jeux olympique');
INSERT INTO choix (id, categorie_id, description) VALUES (17, 4, 'Sopra Steria');

UPDATE choix SET image = pg_read_binary_file('../assets_image/guerre1.png') WHERE id = 1;

-- Insertion de l'image guerre2.png (2ème guerre mondiale)
UPDATE choix SET image = pg_read_binary_file('back-skeleton/assets_image/guerre2.png') WHERE id = 2;

-- Insertion de l'image guerrecor.png (guerre corée)
UPDATE choix SET image = pg_read_binary_file('back-skeleton/assets_image/guerrecor.png') WHERE id = 3;

-- Insertion de l'image guerreviet.png (guerre vietnam)
UPDATE choix SET image = pg_read_binary_file('back-skeleton/assets_image/guerreviet.png') WHERE id = 4;

-- Insertion de l'image mario galaxy.png (Mario galaxy)
UPDATE choix SET image = pg_read_binary_file('back-skeleton/assets_image/mario galaxy.png') WHERE id = 5;

-- Insertion de l'image mario kart.png (mario kart)
UPDATE choix SET image = pg_read_binary_file('back-skeleton/assets_image/mario kart.png') WHERE id = 6;

-- Insertion de l'image mariobroswander.png (mario bros wander)
UPDATE choix SET image = pg_read_binary_file('back-skeleton/assets_image/mariobroswander.png') WHERE id = 7;

-- Insertion de l'image supermarionewbros.png (New Super Mario Bros)
UPDATE choix SET image = pg_read_binary_file('back-skeleton/assets_image/supermarionewbros.png') WHERE id = 8;

-- Insertion de l'image pain_seigle.png (pain de seigle)
UPDATE choix SET image = pg_read_binary_file('back-skeleton/assets_image/pain_seigle.png') WHERE id = 9;

-- Insertion de l'image painCouronne_bordelaise.png (Pain couronne bordelaise)
UPDATE choix SET image = pg_read_binary_file('back-skeleton/assets_image/painCouronne_bordelaise.png') WHERE id = 10;

-- Insertion de l'image paincouronnelyonnaise.png (Pain couronne lyonnaise)
UPDATE choix SET image = pg_read_binary_file('back-skeleton/assets_image/paincouronnelyonnaise.png') WHERE id = 11;

-- Insertion de l'image painlevain.png (pain au levain)
UPDATE choix SET image = pg_read_binary_file('back-skeleton/assets_image/painlevain.png') WHERE id = 12;

-- Insertion de l'image painmeteil.png (pain méteil)
UPDATE choix SET image = pg_read_binary_file('back-skeleton/assets_image/painmeteil.png') WHERE id = 13;

-- Insertion de l'image takima.png (Takima)
UPDATE choix SET image = pg_read_binary_file('back-skeleton/assets_image/takima.png') WHERE id = 14;

-- Insertion de l'image capgemini.png (Capgemini)
UPDATE choix SET image = pg_read_binary_file('back-skeleton/assets_image/capgemini.png') WHERE id = 15;

-- Insertion de l'image jeux_olympique.png (jeux olympique)
UPDATE choix SET image = pg_read_binary_file('back-skeleton/assets_image/jeux_olympique.png') WHERE id = 16;

-- Insertion de l'image sopra.png (Sopra Steria)
UPDATE choix SET image = pg_read_binary_file('back-skeleton/assets_image/sopra.png') WHERE id = 17;
