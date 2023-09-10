package com.anonymity.topictalks;

import com.anonymity.topictalks.payload.request.ParticipantRequest;
import com.anonymity.topictalks.services.IParticipantService;
import com.anonymity.topictalks.services.impls.ParticipantServiceImpl;
import com.anonymity.topictalks.utils.RandomUserUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class TopicTalksBackEndApplicationTests {

    @Autowired
    private IParticipantService participantService;

    @Test
    void contextLoads() {
    }

    @Test
    void testRandom() {

        RandomUserUtil randomUserUtil = new RandomUserUtil();

        ParticipantRequest request = new ParticipantRequest();

        Map<Long, String> map = new HashMap<>();
        map.put(1L, "2023-09-05T10:00:00Z");
        map.put(3L, "2023-09-05T11:30:00Z");
        map.put(2L, "2023-09-05T11:30:00Z");
        map.put(5L, "2023-09-05T14:30:00Z");
        map.put(4L, "2023-09-05T13:45:00Z");
        map.put(6L, "2023-09-05T10:00:00Z");
        map.put(7L, "2023-09-05T16:00:00Z");
        map.put(8L, "2023-09-05T16:00:00Z");

        request.setUserInfoRequest(map);
        request.setAmount(map.size());
        request.setTopicChildId(1L);

        Map<Long, Long> result = randomUserUtil.randomUserChatting(request);

        System.out.println(result);

        participantService.createChatSingle(request);

    }

}
