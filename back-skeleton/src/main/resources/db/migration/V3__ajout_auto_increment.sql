CREATE SEQUENCE IF NOT EXISTS categorie_id_seq;
ALTER TABLE categorie ALTER COLUMN id SET DEFAULT nextval('categorie_id_seq');

CREATE SEQUENCE IF NOT EXISTS choix_id_seq;
ALTER TABLE choix ALTER COLUMN id SET DEFAULT nextval('choix_id_seq');

CREATE SEQUENCE IF NOT EXISTS question_id_seq;
ALTER TABLE question ALTER COLUMN id SET DEFAULT nextval('question_id_seq');

CREATE SEQUENCE IF NOT EXISTS contenir_id_seq;
ALTER TABLE contenir ALTER COLUMN id SET DEFAULT nextval('contenir_id_seq');
