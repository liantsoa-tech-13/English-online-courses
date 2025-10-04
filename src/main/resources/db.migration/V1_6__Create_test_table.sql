CREATE TABLE IF NOT EXISTS test (
    test_id SERIAL PRIMARY KEY,
    level_id INT NOT NULL REFERENCES level(level_id) ON DELETE CASCADE,
    title VARCHAR NOT NULL,
    passing_score INT DEFAULT 10,
    time_limit INT, -- in minute
    test_type VARCHAR(20) NOT NULL,
    description TEXT,
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP
);
