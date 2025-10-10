CREATE TABLE student_answer (
    student_answer_id BIGSERIAL PRIMARY KEY,
    public_id VARCHAR(50) UNIQUE NOT NULL DEFAULT ('SA-' || gen_random_uuid()),
    user_exercise_id INT NOT NULL REFERENCES user_exercise(user_exercise_id) ON DELETE CASCADE,
    exercise_question_id INT NOT NULL REFERENCES exercise_question(question_id) ON DELETE CASCADE,
    answer TEXT NOT NULL,
    is_correct BOOLEAN,
    created_at TIMESTAMP DEFAULT NOW()
);
