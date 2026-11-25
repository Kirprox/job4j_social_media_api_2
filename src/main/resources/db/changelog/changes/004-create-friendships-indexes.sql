--liquibase formatted sql

--changeset student:004
CREATE INDEX idx_friendships_to_user
    ON friendships (to_user_id, created_at DESC);

--rollback DROP INDEX idx_friendships_to_user;
