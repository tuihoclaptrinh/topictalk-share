package com.anonymity.topictalks.payload.response;

import com.anonymity.topictalks.entities.topic.TopicChildren;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConversationResponse {

    private Long conversationId;
    private String chatName;
    private Boolean isGroupChat;
    private TopicChildren topicChildren;

}
