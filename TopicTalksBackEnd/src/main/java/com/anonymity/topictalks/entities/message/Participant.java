package com.anonymity.topictalks.entities.message;

import com.anonymity.topictalks.entities.audit.DateAudit;
import com.anonymity.topictalks.entities.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "participant")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class Participant extends DateAudit implements Serializable {

    @EmbeddedId
    private ParticipantKey id = new ParticipantKey();

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User userInfo;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @MapsId("conversationId")
    @JoinColumn(name = "conversation_id")
    private Conversation conversationInfo;

}
