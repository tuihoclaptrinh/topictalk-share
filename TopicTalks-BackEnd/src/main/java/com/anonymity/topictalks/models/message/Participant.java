package com.anonymity.topictalks.models.message;

import com.anonymity.topictalks.models.user.User;
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
public class Participant implements Serializable {

    @EmbeddedId
    private ParticipantKey id = new ParticipantKey();

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User userInfo;

    @ManyToOne
    @MapsId("conversationId")
    @JoinColumn(name = "conversation_id")
    private Conversation conversationInfo;

}
