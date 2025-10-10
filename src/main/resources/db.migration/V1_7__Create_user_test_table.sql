CREATE TABLE IF NOT EXISTS user_test (
    user_test_id BIGSERIAL PRIMARY KEY,
    public_id VARCHAR(50) UNIQUE NOT NULL DEFAULT ('UTS-' || gen_random_uuid()),
    user_id INT NOT NULL REFERENCES "user"(user_id) ON DELETE CASCADE,
    test_id INT NOT NULL REFERENCES test(test_id) ON DELETE CASCADE,
    started_at TIMESTAMP DEFAULT NOW(),
    finished_at TIMESTAMP,
    status VARCHAR(20) CHECK (status IN ('in_progress', 'completed', 'abandoned'))
);