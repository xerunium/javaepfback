CREATE TABLE IF NOT EXISTS categorie (
                                         id bigint PRIMARY KEY,
                                         nom_categorie VARCHAR(255) NOT NULL
    );

-- Création de la table choix
CREATE TABLE IF NOT EXISTS choix (
                                     id bigint PRIMARY KEY,
                                     categorie_id bigint REFERENCES categorie(id) ON DELETE CASCADE,
    description VARCHAR(255) NOT NULL,
    image VARCHAR(255)
    );

-- Création de la table Question
CREATE TABLE IF NOT EXISTS question (
                                        id bigint PRIMARY KEY,
                                        nb_choix INT NOT NULL
);

-- Création de la table Contenir, avec les relations vers Choix et Question
CREATE TABLE IF NOT EXISTS contenir (
                                        id bigint PRIMARY KEY,
                                        choix_id bigint NOT NULL,
                                        question_id bigint NOT NULL,
                                        is_answer BOOLEAN NOT NULL,
                                        FOREIGN KEY (choix_id) REFERENCES choix(id) ON DELETE CASCADE,
                                        FOREIGN KEY (question_id) REFERENCES question(id) ON DELETE CASCADE
);
