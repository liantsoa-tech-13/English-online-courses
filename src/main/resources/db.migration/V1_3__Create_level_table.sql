CREATE TABLE IF NOT EXISTS level (
    level_id SERIAL PRIMARY KEY,
    name VARCHAR NOT NULL, -- exemple : A1, A2.1, B1...
    description TEXT,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP
);
