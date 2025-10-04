CREATE TABLE IF NOT EXISTS question (
    question_id SERIAL PRIMARY KEY,
    test_id INT NOT NULL REFERENCES test(test_id) ON DELETE CASCADE,
    question_text TEXT NOT NULL,
    correct_answer TEXT NOT NULL,  -- used for validation
    question_type VARCHAR DEFAULT 'fill-in', -- 'fill-in', 'multiple-choice', etc.
    points INT DEFAULT 1,
    position INT DEFAULT 1,                   -- order in the test
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP
);