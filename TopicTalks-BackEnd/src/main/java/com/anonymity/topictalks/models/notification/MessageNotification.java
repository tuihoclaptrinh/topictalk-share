package com.anonymity.topictalks.models.notification;

import com.anonymity.topictalks.models.message.Message;
import com.anonymity.topictalks.models.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "message_notification")
public class MessageNotification {

    @Id
    @Column(name = "message_notification_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "message_notification_seq")
    @SequenceGenerator(name = "message_notification_seq", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User userId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "message_id", nullable = false)
    private Message messageId;

}
