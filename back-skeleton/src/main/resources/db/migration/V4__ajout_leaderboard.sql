CREATE TABLE IF NOT EXISTS leaderboard (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    score INT NOT NULL,
    temps INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX IF NOT EXISTS idx_leaderboard_score ON leaderboard (score DESC, temps ASC);

INSERT INTO leaderboard (username, score, temps) VALUES ('JohnDoe', 150, 300);
INSERT INTO leaderboard (username, score, temps) VALUES ('JaneDoe', 200, 250);