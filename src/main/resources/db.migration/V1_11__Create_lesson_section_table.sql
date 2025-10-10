CREATE TABLE lesson_section (
    section_id BIGSERIAL PRIMARY KEY,
    public_id VARCHAR(50) UNIQUE NOT NULL DEFAULT ('LVL-' || gen_random_uuid()),
    lesson_id INT NOT NULL REFERENCES lesson(lesson_id) ON DELETE CASCADE,
    content TEXT,                     -- main text content (HTML/Markdown allowed)
    position INT DEFAULT 1,           -- order of sections
    created_at TIMESTAMP DEFAULT NOW(),
    updated_at TIMESTAMP
);