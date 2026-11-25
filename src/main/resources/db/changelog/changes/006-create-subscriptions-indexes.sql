--liquibase formatted sql

--changeset student:006
CREATE INDEX idx_subscriptions_to_user
    ON subscriptions (to_user_id, created_at DESC);

--rollback DROP INDEX idx_subscriptions_to_user;
