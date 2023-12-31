package com.anonymity.topictalks.repositories;

import com.anonymity.topictalks.entities.message.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMessageRepository extends JpaRepository<Message, Long> {

    @Query(value = "SELECT * FROM (SELECT * FROM message m WHERE m.conversation_id=:id and ((:offset > 0 and m.message_id < :offset) or (:offset <= 0)) ORDER BY m.message_id DESC LIMIT 20)t order by message_id", nativeQuery = true)
    List<Message> findByConversationIdAndOffset(@Param(value = "id") long id, @Param(value = "offset") int offset);

    @Query(value = "SELECT * FROM message m1 INNER JOIN (SELECT MAX(m.message_id) as id FROM message m GROUP BY m.conversation_id) temp ON temp.id = m1.message_id WHERE conversation_Id = :idOfConv", nativeQuery = true)
    Message findLastMessageByConversationId(@Param(value = "idOfConv") long convId);

    @Query(value = "SELECT m1.message_id FROM message m1 INNER JOIN (SELECT MAX(m.message_id) as id FROM message m GROUP BY m.conversation_id) temp ON temp.id = m1.message_id WHERE conversation_Id = :idOfConv", nativeQuery = true)
        int findLastMessageIdByConversationId(@Param(value = "idOfConv") long convId);

    @Modifying
    @Query(value = "DELETE m, conv FROM message m JOIN conversation conv ON m.conversation_id = conv.conversation_id WHERE conv.conversation_id = :convId", nativeQuery = true)
    void deleteMessagesDataByConversationId(@Param(value = "convId") long convId);

}
