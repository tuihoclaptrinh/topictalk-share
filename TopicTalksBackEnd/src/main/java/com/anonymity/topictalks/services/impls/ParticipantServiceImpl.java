package com.anonymity.topictalks.services.impls;

import com.anonymity.topictalks.entities.message.Participant;
import com.anonymity.topictalks.entities.message.ParticipantKey;
import com.anonymity.topictalks.payload.request.ConversationRequest;
import com.anonymity.topictalks.payload.request.ParticipantRequest;
import com.anonymity.topictalks.repositories.IConversationRepository;
import com.anonymity.topictalks.repositories.IParticipantRepository;
import com.anonymity.topictalks.repositories.IUserRepository;
import com.anonymity.topictalks.services.IConversationService;
import com.anonymity.topictalks.services.IParticipantService;
import com.anonymity.topictalks.utils.RandomUserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ParticipantServiceImpl implements IParticipantService {

    private final IParticipantRepository participantRepository;
    private final RandomUserUtil randomUserUtil;
    private final IConversationService conversationService;
    private final IUserRepository userRepository;
    private final IConversationRepository conversationRepository;

    @Override
    public void createChatSingle(ParticipantRequest participantRequest) {

        Map<Long, Long> result = randomUserUtil.randomUserChatting(participantRequest);

        var conversationRequest = ConversationRequest.builder()
                .isGroupChat(false)
                .chatName(null)
                .topicChildrenId(participantRequest.getTopicChildId())
                .build();

        for(Map.Entry<Long, Long> entry: result.entrySet()) {

            var conversationResponse = conversationService.createConversation(conversationRequest);

            var key = new ParticipantKey();
            var participant = Participant.builder()
                    .id(key)
                    .userInfo(userRepository.findById(entry.getKey()).get())
                    .conversationInfo(conversationRepository.findById(conversationResponse.getConversationId()).get())
                    .build();
            participant.setCreatedAt(Instant.now());
            participantRepository.save(participant);

            var key2 = new ParticipantKey();
            var participant2 = Participant.builder()
                    .id(key2)
                    .userInfo(userRepository.findById(entry.getValue()).get())
                    .conversationInfo(conversationRepository.findById(conversationResponse.getConversationId()).get())
                    .build();
            participant2.setCreatedAt(Instant.now());
            participantRepository.save(participant2);
        }

    }

}
