package com.anonymity.topictalks.services;

import com.anonymity.topictalks.payload.request.AuthenticationRequest;
import com.anonymity.topictalks.payload.request.RegisterRequest;
import com.anonymity.topictalks.payload.response.AuthenticationResponse;

public interface IAuthenticationService {

    AuthenticationResponse register(RegisterRequest request);
    AuthenticationResponse authenticate(AuthenticationRequest request);

}
