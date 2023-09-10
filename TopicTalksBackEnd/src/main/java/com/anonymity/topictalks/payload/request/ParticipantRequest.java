package com.anonymity.topictalks.payload.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParticipantRequest {

    Map<Long, String> userInfoRequest;
    int amount;
    long topicChildId;

}
