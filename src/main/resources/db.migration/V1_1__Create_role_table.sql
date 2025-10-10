CREATE TABLE role (
    role_id BIGSERIAL PRIMARY KEY,
    name VARCHAR UNIQUE NOT NULL CHECK (name IN ('ADMIN','USER'))  -- 'ADMIN', 'USER', etc.
);
