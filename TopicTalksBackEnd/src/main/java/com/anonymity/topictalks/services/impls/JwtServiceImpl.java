package com.anonymity.topictalks.services.impls;

import com.anonymity.topictalks.services.IJwtService;
import com.anonymity.topictalks.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class JwtServiceImpl implements IJwtService {

    private final JwtUtil jwtUtil;

    @Override
    public String extractUserName(String token) {
        return jwtUtil.extractUserName(token);
    }

    @Override
    public String generateToken(UserDetails userDetails) {
        return jwtUtil.generateRefreshToken(userDetails);
    }

    @Override
    public String generateRefreshToken(UserDetails userDetails) {
        return jwtUtil.generateRefreshToken(userDetails);
    }

    @Override
    public boolean isTokenValid(String token, UserDetails userDetails) {
        return jwtUtil.isTokenValid(token, userDetails);
    }

}
