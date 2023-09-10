package com.anonymity.topictalks.controllers;

import com.anonymity.topictalks.payload.request.ConversationRequest;
import com.anonymity.topictalks.payload.response.ConversationResponse;
import com.anonymity.topictalks.services.IConversationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/conversations")
@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
@Tag(name = "Conversation", description = "The Conversation API contains information about conversation of people.")
public class ConversationController {

    private final IConversationService conversationService;

    @PostMapping("/")
    @PreAuthorize("hasAuthority('WRITE_PRIVILEGE') and hasRole('ADMIN')")
    public ResponseEntity<Object> createConversation(@Valid @RequestBody ConversationRequest request) {
        try {
            ConversationResponse response = conversationService.createConversation(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // Handle exceptions gracefully and return an error response
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "An unexpected error occurred");
            errorResponse.put("message", e.getMessage()); // You can customize the error message
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

}
