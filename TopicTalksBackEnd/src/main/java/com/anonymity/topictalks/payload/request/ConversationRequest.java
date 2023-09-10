package com.anonymity.topictalks.payload.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConversationRequest {

    private String chatName;
    private Boolean isGroupChat;
    private long topicChildrenId;

}
