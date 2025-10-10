CREATE TABLE user_exercise (
    user_exercise_id BIGSERIAL PRIMARY KEY,
    public_id VARCHAR(50) UNIQUE NOT NULL DEFAULT ('UEX-' || gen_random_uuid()),
    user_id INT NOT NULL REFERENCES "user"(user_id) ON DELETE CASCADE,
    exercise_id INT NOT NULL REFERENCES exercise(exercise_id) ON DELETE CASCADE,
    started_at TIMESTAMP DEFAULT NOW(),
    finished_at TIMESTAMP,
    status VARCHAR(20) CHECK (status IN ('in_progress', 'completed', 'abandoned')),
    total_score INT DEFAULT 0,           -- sum of points from sub-questions
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP
);