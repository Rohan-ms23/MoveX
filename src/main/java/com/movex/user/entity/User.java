package com.movex.user.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="users")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String name;

    @Column(nullable= false, unique=true)
    private String email;

    @Column(unique=true)
    private String phone;

    @Column(nullable=false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String profileImage;

    private Boolean isActive = true;

    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        createdAt= LocalDateTime.now();
    } 
}
