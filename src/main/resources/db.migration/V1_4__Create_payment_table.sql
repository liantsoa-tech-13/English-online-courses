CREATE TABLE IF NOT EXISTS payment(
    payment_id VARCHAR CONSTRAINT payment_pk PRIMARY KEY,
    amount INTEGER NULL,
    status VARCHAR NOT NULL,
    psp_id VARCHAR NOT NULL,
    psp_last_verification_instant TIMESTAMP WITH TIME ZONE NULL
);
