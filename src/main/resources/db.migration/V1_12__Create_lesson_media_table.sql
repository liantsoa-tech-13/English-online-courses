CREATE TABLE lesson_media (
    media_id SERIAL PRIMARY KEY,
    lesson_id INT NOT NULL REFERENCES lesson(lesson_id) ON DELETE CASCADE,
    media_type VARCHAR NOT NULL,  -- 'image' or 'video'
    media_url VARCHAR NOT NULL,
    position INT DEFAULT 1,       -- order of media in the lesson
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP
);