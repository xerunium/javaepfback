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
INSERT INTO choix (id, categorie_id, description) VALUES (7, 2, 'mario bros wonder');
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
UPDATE choix SET image = ('https://i.imgur.com/ttgo5Un.png') WHERE id=1;
UPDATE choix SET image = ('https://i.imgur.com/EyFmLGs.png') WHERE id=2;
UPDATE choix SET image = ('https://i.imgur.com/B1ZGlOo.png') WHERE id=3;
UPDATE choix SET image = ('https://i.imgur.com/Fr1V9B2.png') WHERE id=4;
UPDATE choix SET image = ('https://i.imgur.com/FUfBx9U.png') WHERE id=5;
UPDATE choix SET image = ('https://i.imgur.com/t1rlpsu.png') WHERE id=6;
UPDATE choix SET image = ('https://i.imgur.com/l90xs8m.png') WHERE id=7;
UPDATE choix SET image = ('https://i.imgur.com/w8WK925.png') WHERE id=8;
UPDATE choix SET image = ('https://i.imgur.com/lqnCeYy.png') WHERE id=9;
UPDATE choix SET image = ('https://i.imgur.com/2pTl5Kc.png') WHERE id=10;
UPDATE choix SET image = ('https://i.imgur.com/Dog4OX7.png') WHERE id=11;
UPDATE choix SET image = ('https://i.imgur.com/h1SFZBe.png') WHERE id=12;
UPDATE choix SET image = ('https://i.imgur.com/TCqXxQs.png') WHERE id=13;
UPDATE choix SET image = ('https://i.imgur.com/WjWw1Rt.png') WHERE id=14;
UPDATE choix SET image = ('https://i.imgur.com/LwSL2dU.png') WHERE id=15;
UPDATE choix SET image = ('https://i.imgur.com/1HK8tVJ.png') WHERE id=16;
UPDATE choix SET image = ('https://i.imgur.com/RmdfeoW.png') WHERE id=17;
