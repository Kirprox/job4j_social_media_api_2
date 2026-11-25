--liquibase formatted sql

--changeset student:005
CREATE TABLE subscriptions
(
    id           UUID PRIMARY KEY,
    from_user_id UUID        NOT NULL,
    to_user_id   UUID        NOT NULL,
    created_at   TIMESTAMPTZ NOT NULL,
    updated_at   TIMESTAMPTZ NOT NULL,
    CONSTRAINT chk_subscriptions_different_users
        CHECK (from_user_id <> to_user_id),
    CONSTRAINT uq_subscriptions_users
        UNIQUE (from_user_id, to_user_id)
);

--rollback DROP TABLE subscriptions;
