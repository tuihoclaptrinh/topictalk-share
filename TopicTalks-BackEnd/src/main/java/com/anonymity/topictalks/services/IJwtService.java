package com.anonymity.topictalks.services;

import org.springframework.security.core.userdetails.UserDetails;

public interface IJwtService {

    String extractUserName(String token);

    String generateToken(UserDetails userDetails);

    public String generateRefreshToken(UserDetails userDetails);

    boolean isTokenValid(String token, UserDetails userDetails);

}
