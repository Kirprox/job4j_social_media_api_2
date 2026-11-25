--liquibase formatted sql

--changeset student:003
CREATE TABLE friendships
(
    id           UUID PRIMARY KEY,
    from_user_id UUID        NOT NULL,
    to_user_id   UUID        NOT NULL,
    created_at   TIMESTAMPTZ NOT NULL,
    updated_at   TIMESTAMPTZ NOT NULL,
    CONSTRAINT chk_friendships_different_users
        CHECK (from_user_id < to_user_id),
    CONSTRAINT uq_friendships_users
        UNIQUE (from_user_id, to_user_id)
);

--rollback DROP TABLE friendships;
