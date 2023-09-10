package com.anonymity.topictalks.services.impls;

import com.anonymity.topictalks.entities.message.Message;
import com.anonymity.topictalks.payload.request.MessageRequest;
import com.anonymity.topictalks.payload.response.MessageResponse;
import com.anonymity.topictalks.repositories.IConversationRepository;
import com.anonymity.topictalks.repositories.IMessageRepository;
import com.anonymity.topictalks.repositories.IUserRepository;
import com.anonymity.topictalks.services.IMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements IMessageService {

    private final IMessageRepository messageRepository;
    private final IUserRepository userRepository;
    private final IConversationRepository conversationRepository;

    @Override
    public MessageResponse createAndSaveMessage(MessageRequest messageRequest) {
        var message = Message.builder()
                .senderId(userRepository.findById(messageRequest.getSenderId()).get())
                .conversationId(conversationRepository.findById(messageRequest.getConversationId()).get())
                .content(messageRequest.getContent())
                .build();

        message = messageRepository.save(message);

        return MessageResponse.builder()
                .messageId(message.getId())
                .conversationId(message.getConversationId().getId())
                .content(message.getContent())
                .senderId(message.getSenderId().getId())
                .build();
    }

    @Override
    public void flush() {
        messageRepository.flush();
    }

    @Override
    public List<MessageResponse> findByConversationId(long id, int offset) {
        List<Message> messageList = messageRepository.findByConversationIdAndOffset(id, offset);

        List<MessageResponse> messageResponseList = new ArrayList<>();

        for (Message message : messageList) {
            MessageResponse messageResponse = MessageResponse.builder()
                    .messageId(message.getId())
                    .content(message.getContent())
                    .senderId(message.getSenderId().getId()) // Assuming you have a sender field in Message
                    .conversationId(message.getConversationId().getId()) // Assuming you have a conversation field in Message
                    .build();
            messageResponseList.add(messageResponse);
        }

        return messageResponseList;
    }

    @Override
    public void deleteAllMessageByConversationId(long id) {
        messageRepository.deleteMessagesDataByConversationId(id);
    }

    @Override
    public MessageResponse findLastMessage(long conversationId) {
        var message =  messageRepository.findLastMessageByConversationId(conversationId);
        return MessageResponse.builder()
                .messageId(message.getId())
                .senderId(message.getSenderId().getId())
                .conversationId(message.getConversationId().getId())
                .content(message.getContent())
                .build();
    }

    @Override
    public long findLastMessageIdByConversationId(long conversationId) {
        return messageRepository.findLastMessageIdByConversationId(conversationId);
    }
}
