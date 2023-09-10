package com.anonymity.topictalks.dtos;

import com.anonymity.topictalks.enums.ETransportAction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InputTransportDTO {

    private int userId;

    private ETransportAction action;

    private String wsToken;

    private String groupUrl;

    private String message;

    private int messageId;

}
