package com.anonymity.topictalks.repositories;

import com.anonymity.topictalks.entities.message.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IConversationRepository extends JpaRepository<Conversation, Long> {
}
