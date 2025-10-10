CREATE TABLE exercise (
    exercise_id BIGSERIAL PRIMARY KEY,
    lesson_id INT NOT NULL REFERENCES lesson(lesson_id) ON DELETE CASCADE,
    title VARCHAR NOT NULL,              -- e.g., "Fill in the blanks"
    exercise_type VARCHAR DEFAULT 'quiz', -- 'quiz', 'fill-in', etc.
    description TEXT,
    position INT DEFAULT 1,              -- order in lesson
    points INT DEFAULT 1,                 -- total points for the exercise
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP
);
