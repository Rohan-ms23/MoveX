package com.movex.auth.dto;

import com.movex.user.entity.Role;
import jakarta.validation.constraints.*;

import lombok.Data;

@Data
public class RegisterRequest {

    @NotBlank
    private String name;

    @Email
    private String email;

    @NotBlank
    private String phone;

    @Size(min=8)
    private String password;

    private Role role;
    
}
