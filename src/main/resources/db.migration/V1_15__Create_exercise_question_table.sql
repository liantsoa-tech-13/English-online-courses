CREATE TABLE exercise_question (
    question_id BIGSERIAL PRIMARY KEY,
    public_id VARCHAR(50) UNIQUE NOT NULL DEFAULT ('EQ-' || gen_random_uuid()),
    exercise_id INT NOT NULL REFERENCES exercise(exercise_id) ON DELETE CASCADE,
    question_text TEXT NOT NULL,
    correct_answer TEXT NOT NULL,
    question_type VARCHAR DEFAULT 'fill-in', -- 'fill-in', 'multiple-choice', etc.
    points INT DEFAULT 1,                     -- points for this sub-question
    position INT DEFAULT 1,                   -- order inside exercise
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP
);