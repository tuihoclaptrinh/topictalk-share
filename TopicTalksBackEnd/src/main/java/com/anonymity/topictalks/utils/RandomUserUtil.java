package com.anonymity.topictalks.utils;

import com.anonymity.topictalks.payload.request.ParticipantRequest;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.*;

@Component
public class RandomUserUtil {

    public Map<Long, Long> randomUserChatting(ParticipantRequest request) {

        Map<Long, Instant> instantMap = new HashMap<>();

        // ISO 8601
        for (Map.Entry<Long, String> entry : request.getUserInfoRequest().entrySet()) {
            Long key = entry.getKey();
            String dateString = entry.getValue();
            Instant instant = Instant.parse(dateString);
            instantMap.put(key, instant);
        }

        List<Map.Entry<Long, Instant>> entries = new ArrayList<>(instantMap.entrySet());

        // Sort the entries by Instant in ascending order
        entries.sort(Comparator.comparing(Map.Entry::getValue));

        List<Long> userValues = new ArrayList<>();
        int count = 0;

        for (Map.Entry<Long, Instant> entry : entries) {
            userValues.add(entry.getKey());
            count++;

            if (count >= request.getAmount()) {
                break;
            }
        }

        // If the amount is odd, remove the last element from userValues
        if (request.getAmount() % 2 != 0 && userValues.size() > 0) {
            userValues.remove(userValues.size() - 1);
        }

        // Create a map with pairs of user IDs as keys
        Map<Long, Long> result = new LinkedHashMap<>();

        for (int i = 0; i < userValues.size(); i += 2) {
            if (i + 1 < userValues.size()) {
                Long user1 = userValues.get(i);
                Long user2 = userValues.get(i + 1);
                result.put(user1, user2);
            }
        }

        return result;
    }

}
