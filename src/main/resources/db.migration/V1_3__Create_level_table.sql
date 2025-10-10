CREATE TABLE IF NOT EXISTS level (
    level_id BIGSERIAL PRIMARY KEY,
    public_id VARCHAR(50) UNIQUE NOT NULL DEFAULT ('LVL-' || gen_random_uuid()),
    name VARCHAR NOT NULL, -- exemple : A1, A2.1, B1...
    description TEXT,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP
);
