package com.anonymity.topictalks.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/participants")
@PreAuthorize("hasAnyRole('USER')")
@Tag(name = "Participant", description = "The Participant API contains information about the people who are participant in the chat.")
public class ParticipantController {



}
