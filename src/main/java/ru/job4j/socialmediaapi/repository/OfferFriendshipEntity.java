package ru.job4j.socialmediaapi.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.job4j.socialmediaapi.domain.OfferFriendshipStatus;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "offer_friendships")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class OfferFriendshipEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "from_user_id", nullable = false)
    private UUID fromUserId;

    @Column(name = "to_user_id", nullable = false)
    private UUID toUserId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 16)
    private OfferFriendshipStatus status;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    @Override
    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OfferFriendshipEntity entity)) {
            return false;
        }
        UUID currentId = getId();
        return currentId != null && currentId.equals(entity.getId());
    }

    @Override
    public final int hashCode() {
        return OfferFriendshipEntity.class.hashCode();
    }
}

