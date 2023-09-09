package com.anonymity.topictalks.models.topic;

import com.anonymity.topictalks.models.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "user_topic")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class UserTopic implements Serializable {

    @EmbeddedId
    private UserTopicKey id = new UserTopicKey();

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User userInfo;

    @ManyToOne
    @MapsId("topicChildrenId")
    @JoinColumn(name = "topic_children_id")
    private TopicChildren topicChildrenInfo;

}
