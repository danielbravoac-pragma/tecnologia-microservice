CREATE EXTENSION IF NOT EXISTS pgcrypto;
CREATE TABLE technology(
    id UUID NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    description VARCHAR(90) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
CREATE UNIQUE INDEX uq_technology_name_ci ON technology ((lower(name)));