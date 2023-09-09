package com.anonymity.topictalks.models.topic;

import com.anonymity.topictalks.models.audit.DateAudit;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "topic_parent")
public class TopicParent extends DateAudit {

    @Id
    @Column(name = "topic_parent_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "topic_parent_seq")
    @SequenceGenerator(name = "topic_parent_seq", allocationSize = 1)
    private Long id;

    @NotNull
    @Column(name = "topic_parent_name", nullable = false)
    private String topicParentName;

}
