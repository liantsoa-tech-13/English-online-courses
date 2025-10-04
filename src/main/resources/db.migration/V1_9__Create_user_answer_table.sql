CREATE TABLE IF NOT EXISTS user_answer (
    user_answer_id SERIAL PRIMARY KEY,
    user_test_id INT NOT NULL REFERENCES user_test(user_test_id) ON DELETE CASCADE,
    question_id INT NOT NULL REFERENCES question(question_id) ON DELETE CASCADE,
    answer TEXT,
    is_correct BOOLEAN,
    created_at TIMESTAMP DEFAULT NOW()
);