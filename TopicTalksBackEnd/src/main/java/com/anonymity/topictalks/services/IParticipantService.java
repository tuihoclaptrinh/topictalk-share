package com.anonymity.topictalks.services;

import com.anonymity.topictalks.payload.request.ParticipantRequest;

public interface IParticipantService {

    void createChatSingle(ParticipantRequest participantRequest);

}
