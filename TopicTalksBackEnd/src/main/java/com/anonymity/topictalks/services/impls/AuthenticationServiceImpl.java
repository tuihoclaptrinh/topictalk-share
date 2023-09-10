package com.anonymity.topictalks.services.impls;

import com.anonymity.topictalks.entities.user.User;
import com.anonymity.topictalks.enums.ETokenType;
import com.anonymity.topictalks.payload.request.AuthenticationRequest;
import com.anonymity.topictalks.payload.request.RegisterRequest;
import com.anonymity.topictalks.payload.response.AuthenticationResponse;
import com.anonymity.topictalks.repositories.IUserRepository;
import com.anonymity.topictalks.services.IAuthenticationService;
import com.anonymity.topictalks.services.IJwtService;
import com.anonymity.topictalks.services.IRefreshTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements IAuthenticationService {

    private final PasswordEncoder passwordEncoder;
    private final IJwtService jwtService;
    private final IUserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final IRefreshTokenService refreshTokenService;

    @Override
    public AuthenticationResponse register(RegisterRequest request) {

        var user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setDob(request.getDob());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setBio(request.getBio());
        user.setImageUrl(request.getImageUrl());
        user.setGender(request.getPassword());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setCountry(request.getCountry());
        user.setIsBanned(request.getIsBanned());
        user.setBannedDate(request.getBannedDate());
        user.setRole(request.getRole());
        user.setCreatedAt(Instant.now());
        user.setUpdatedAt(null);
        user.setToken(jwtService.generateToken(user));


        user = userRepository.save(user);

        var jwt = user.getToken();
        var refreshToken = refreshTokenService.createRefreshToken(user.getId());

        var roles = user.getRole().getAuthorities()
                .stream()
                .map(SimpleGrantedAuthority::getAuthority)
                .toList();

        return AuthenticationResponse.builder()
                .accessToken(jwt)
                .username(user.getUsername())
                .id(user.getId())
                .refreshToken(refreshToken.getToken())
                .roles(roles)
                .tokenType(ETokenType.BEARER.name())
                .build();

    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));

        var user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));

        var roles = user.getRole().getAuthorities()
                .stream()
                .map(SimpleGrantedAuthority::getAuthority)
                .toList();

        String jwt = jwtService.generateToken(user);

        var refreshToken = refreshTokenService.createRefreshToken(user.getId());

        return AuthenticationResponse.builder()
                .accessToken(jwt)
                .roles(roles)
                .username(user.getUsername())
                .id(user.getId())
                .refreshToken(refreshToken.getToken())
                .tokenType(ETokenType.BEARER.name())
                .build();

    }
}
