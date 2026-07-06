package com.movex.auth.service;

import com.movex.auth.dto.AuthResponse;
import com.movex.auth.dto.RegisterRequest;

public interface AuthService {

    AuthResponse register(RegisterRequest request);
}