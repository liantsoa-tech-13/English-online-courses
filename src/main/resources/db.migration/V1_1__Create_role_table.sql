CREATE TABLE role (
                      role_id SERIAL PRIMARY KEY,
                      name VARCHAR UNIQUE NOT NULL CHECK (name IN ('ADMIN','USER'))  -- 'ADMIN', 'USER', etc.
);
