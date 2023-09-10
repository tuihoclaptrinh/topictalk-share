package com.anonymity.topictalks.services.impls;

import com.anonymity.topictalks.exceptions.TopicChildrenNotFoundException;
import com.anonymity.topictalks.entities.message.Conversation;
import com.anonymity.topictalks.entities.topic.TopicChildren;
import com.anonymity.topictalks.payload.request.ConversationRequest;
import com.anonymity.topictalks.payload.response.ConversationResponse;
import com.anonymity.topictalks.repositories.IConversationRepository;
import com.anonymity.topictalks.repositories.ITopicChildrenRepository;
import com.anonymity.topictalks.services.IConversationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConversationServiceImpl implements IConversationService {

    private final IConversationRepository conversationRepository;
    private final ITopicChildrenRepository topicChildrenRepository;

    @Override
    public ConversationResponse createConversation(ConversationRequest conversationRequest) {

        var conversation = new Conversation();
        TopicChildren topicChildren = topicChildrenRepository
                .findById(conversationRequest.getTopicChildrenId())
                .orElseThrow(() -> new TopicChildrenNotFoundException("Topic Children not found"));

        conversation.setChatName(conversationRequest.getChatName());
        conversation.setIsGroupChat(conversationRequest.getIsGroupChat());
        conversation.setTopicChildren(topicChildren);

        conversation = conversationRepository.save(conversation);

        var response = new ConversationResponse();

        return response.builder()
                .conversationId(conversation.getId())
                .chatName(conversation.getChatName())
                .isGroupChat(conversation.getIsGroupChat())
                .topicChildren(conversation.getTopicChildren())
                .build();
    }
}
