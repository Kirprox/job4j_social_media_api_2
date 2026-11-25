package ru.job4j.socialmediaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

public interface OfferFriendshipRepository
        extends JpaRepository<OfferFriendshipEntity, UUID> {
    Optional<OfferFriendshipEntity> findByFromUserIdAndToUserId(
            UUID fromUserId, UUID toUserId
    );

    @Modifying
    @Query(value = """
            INSERT INTO offer_friendships (
                id, from_user_id, to_user_id, status, created_at, updated_at
            )
            VALUES (:id, :fromUserId, :toUserId, 'PENDING', :now, :now)
            ON CONFLICT (from_user_id, to_user_id) DO NOTHING
            """, nativeQuery = true)
    int create(
            @Param("id") UUID id,
            @Param("fromUserId") UUID fromUserId,
            @Param("toUserId") UUID toUserId,
            @Param("now") Instant now
    );
}
