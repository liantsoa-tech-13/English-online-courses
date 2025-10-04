CREATE TABLE IF NOT EXISTS user_test (
    user_test_id SERIAL PRIMARY KEY,
    user_id INT NOT NULL REFERENCES "user"(user_id) ON DELETE CASCADE,
    test_id INT NOT NULL REFERENCES test(test_id) ON DELETE CASCADE,
    started_at TIMESTAMP DEFAULT NOW(),
    finished_at TIMESTAMP,
    status VARCHAR(20) CHECK (status IN ('in_progress', 'completed', 'abandoned'))
);