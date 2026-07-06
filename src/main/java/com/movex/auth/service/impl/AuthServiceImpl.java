package com.movex.auth.service.impl;

import com.movex.auth.service.AuthService;
import com.movex.exception.DuplicateResourceException;
import com.movex.auth.dto.RegisterRequest;
import com.movex.auth.dto.AuthResponse;
import com.movex.user.entity.User;
import com.movex.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AuthResponse register(RegisterRequest request) {

        if(userRepository.existsByEmail(request.getEmail())) {
            throw new DuplicateResourceException("Email already exists");
        }

        if(userRepository.existsByPhone(request.getPhone())) {
            throw new DuplicateResourceException("Phone already exits");
        }

        User user = User.builder()
            .name(request.getName())
            .email(request.getEmail())
            .phone(request.getPhone())
            .password(passwordEncoder.encode(request.getPassword()))
            .role(request.getRole())
            .build();
        
        User savedUser = userRepository.save(user);

        return AuthResponse.builder()
                .id(savedUser.getId())
                .name(savedUser.getEmail())
                .email(savedUser.getName())
                .role(savedUser.getRole().name())
                .build();
                
            }
}
