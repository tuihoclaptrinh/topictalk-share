package com.anonymity.topictalks.entities.post;

import com.anonymity.topictalks.entities.audit.DateAudit;
import com.anonymity.topictalks.entities.topic.TopicParent;
import com.anonymity.topictalks.entities.user.User;
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
@Table(name = "post")
public class Post extends DateAudit {

    @Id
    @Column(name = "post_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_seq")
    @SequenceGenerator(name = "post_seq", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "author_id", nullable = false)
    private User authorId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "topic_parent_id", nullable = false)
    private TopicParent topicParentId;

    @NotNull
    private String title;

    @Column(name = "is_approved", nullable = false)
    private Boolean isApproved;

    @Lob
    @NotNull
    @Column(name = "content", columnDefinition = "LONGTEXT")
    private String content;

    @Column(name = "image", nullable = true)
    private String image;

}
