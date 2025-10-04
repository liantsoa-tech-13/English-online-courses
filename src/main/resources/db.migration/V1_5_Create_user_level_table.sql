CREATE TABLE IF NOT EXISTS user_level (
    user_level_id SERIAL PRIMARY KEY,
    user_id INT NOT NULL REFERENCES "user"(user_id) ON DELETE CASCADE,
    level_id INT NOT NULL REFERENCES level(level_id) ON DELETE CASCADE,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP
);
