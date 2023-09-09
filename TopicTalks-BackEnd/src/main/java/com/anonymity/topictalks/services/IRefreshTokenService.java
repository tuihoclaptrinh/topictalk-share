package com.anonymity.topictalks.services;

import com.anonymity.topictalks.models.user.RefreshToken;
import com.anonymity.topictalks.payload.request.RefreshTokenRequest;
import com.anonymity.topictalks.payload.response.RefreshTokenResponse;

import java.util.Optional;

public interface IRefreshTokenService {

    RefreshToken createRefreshToken(Long userId);
    RefreshToken verifyExpiration(RefreshToken token);
    Optional<RefreshToken> findByToken(String token);
    RefreshTokenResponse generateNewToken(RefreshTokenRequest request);

}
