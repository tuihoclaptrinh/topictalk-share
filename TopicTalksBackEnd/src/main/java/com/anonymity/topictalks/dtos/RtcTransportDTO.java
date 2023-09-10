package com.anonymity.topictalks.dtos;

import com.anonymity.topictalks.enums.ERtcAction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RtcTransportDTO {

    private int userId;

    private String groupUrl;

    private ERtcAction action;

    private Object offer;

    private Object answer;

}
