CREATE SEQUENCE categorie_seq;
CREATE SEQUENCE choix_seq;

SELECT SETVAL('categorie_seq', COALESCE((SELECT MAX(id) FROM categorie), 1) + 1, false);
SELECT SETVAL('choix_seq', COALESCE((SELECT MAX(id) FROM choix), 1) + 1, false);



CREATE SEQUENCE IF NOT EXISTS question_id_seq;
ALTER TABLE question ALTER COLUMN id SET DEFAULT nextval('question_id_seq');

CREATE SEQUENCE IF NOT EXISTS contenir_id_seq;
ALTER TABLE contenir ALTER COLUMN id SET DEFAULT nextval('contenir_id_seq');
