CREATE TABLE "user" (
   user_id BIGSERIAL PRIMARY KEY,
   public_id VARCHAR(50) UNIQUE NOT NULL DEFAULT ('USR-' || gen_random_uuid()),
   fullname VARCHAR NOT NULL,
   email VARCHAR UNIQUE NOT NULL,
   password_hash VARCHAR NOT NULL,
   role_id INT NOT NULL REFERENCES role(role_id),
   student_status VARCHAR DEFAULT 'prospect', -- after active(learning), inactive, alumni
   last_login TIMESTAMP,
   is_active BOOLEAN DEFAULT TRUE,
   email_verified BOOLEAN DEFAULT FALSE,
   created_at TIMESTAMP DEFAULT NOW(),
   updated_at TIMESTAMP
);







