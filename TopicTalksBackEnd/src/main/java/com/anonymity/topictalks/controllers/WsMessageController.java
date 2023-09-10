package com.anonymity.topictalks.controllers;

import com.anonymity.topictalks.dtos.InputTransportDTO;
import com.anonymity.topictalks.enums.ETransportAction;
import com.anonymity.topictalks.services.IMessageService;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/api/v1/messages")
public class WsMessageController {

    private final Logger log = LoggerFactory.getLogger(WsMessageController.class);

    private final SimpMessagingTemplate messagingTemplate;

    private final IMessageService messageService;

    @MessageMapping("/message")
    public void mainChannel(InputTransportDTO dto, @Header("simpSessionId") String sessionId) {

        ETransportAction action = dto.getAction();

        switch (action) {

        }


    }



}
