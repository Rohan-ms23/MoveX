package com.movex.auth.controller;

import com.movex.auth.dto.*;
import com.movex.auth.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public AuthResponse register(
        @Valid@RequestBody RegisterRequest request
    ){
        return authService.register(request);
    }

}
