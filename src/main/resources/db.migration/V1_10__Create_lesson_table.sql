CREATE TABLE lesson (
    lesson_id BIGSERIAL PRIMARY KEY,
    public_id VARCHAR(50) UNIQUE NOT NULL DEFAULT ('LES-' || gen_random_uuid()),
    level_id INT NOT NULL REFERENCES level(level_id) ON DELETE CASCADE,
    title VARCHAR NOT NULL,
    description TEXT,
    is_sample BOOLEAN DEFAULT FALSE,
    position INT,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP,
    created_by INT REFERENCES "user"(user_id),
    updated_by INT REFERENCES "user"(user_id)
);