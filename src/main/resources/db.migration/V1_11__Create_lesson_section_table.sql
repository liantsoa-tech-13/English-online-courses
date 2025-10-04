CREATE TABLE lesson_section (
    section_id SERIAL PRIMARY KEY,
    lesson_id INT NOT NULL REFERENCES lesson(lesson_id) ON DELETE CASCADE,
    content TEXT,                     -- main text content (HTML/Markdown allowed)
    position INT DEFAULT 1,           -- order of sections
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP
);