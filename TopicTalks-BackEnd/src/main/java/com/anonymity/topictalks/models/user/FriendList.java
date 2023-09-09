package com.anonymity.topictalks.models.user;

import com.anonymity.topictalks.models.audit.DateAudit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "friend_list", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "friend_id",
                "user_id"
        })
})
public class FriendList extends DateAudit {

    @Id
    @Column(name = "friend_list_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "friend_list_seq")
    @SequenceGenerator(name = "friend_list_seq", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User userId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "friend_id", nullable = false)
    private User friendId;

    @Column(name = "is_public", nullable = false)
    private Boolean isPublic;

    @Column(name = "is_accept", nullable = false)
    private Boolean isAccept;

}
