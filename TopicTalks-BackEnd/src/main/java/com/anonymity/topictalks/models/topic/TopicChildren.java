package com.anonymity.topictalks.models.topic;

import com.anonymity.topictalks.models.audit.DateAudit;
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
@Table(name = "topic_children")
public class TopicChildren extends DateAudit {

    @Id
    @Column(name = "topic_children_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "topic_children_seq")
    @SequenceGenerator(name = "topic_children_seq", allocationSize = 1)
    private Long id;

    @Column(name = "topic_children_name")
    private String topicChildrenName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "topic_parent_id", nullable = false)
    private TopicParent topicParentId;

}
