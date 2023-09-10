package com.anonymity.topictalks.entities.message;

import com.anonymity.topictalks.entities.topic.TopicChildren;
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
@Table(name = "conversation")
public class Conversation {

    @Id
    @Column(name = "conversation_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "conversation_seq")
    @SequenceGenerator(name = "conversation_seq", allocationSize = 1)
    private Long id;

    @Column(name = "chat_name", nullable = true)
    private String chatName;

    @Column(name = "is_group_chat")
    private Boolean isGroupChat;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "topic_children_id", nullable = false)
    private TopicChildren topicChildren;

}
