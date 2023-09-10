package com.anonymity.topictalks.entities.topic;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UserTopicKey implements Serializable {

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "topic_children_id")
    private Long topicChildrenId;

}
