package com.anonymity.topictalks.services;

import com.anonymity.topictalks.payload.request.ConversationRequest;
import com.anonymity.topictalks.payload.response.ConversationResponse;

public interface IConversationService {

    ConversationResponse createConversation(ConversationRequest conversationRequest);

}
