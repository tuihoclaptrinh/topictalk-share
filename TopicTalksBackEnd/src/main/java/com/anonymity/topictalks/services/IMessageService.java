package com.anonymity.topictalks.services;

import com.anonymity.topictalks.payload.request.MessageRequest;
import com.anonymity.topictalks.payload.response.MessageResponse;

import java.util.List;

public interface IMessageService {

    MessageResponse createAndSaveMessage(MessageRequest messageRequest);
    void flush();

    List<MessageResponse> findByConversationId(long id, int offset);

    void deleteAllMessageByConversationId(long id);

    MessageResponse findLastMessage(long conversationId);

    long findLastMessageIdByConversationId(long conversationId);

}
