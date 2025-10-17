package org.english.englishonlinecourse.dto;

import org.english.englishonlinecourse.model.Role;

import java.time.Instant;

public class UserAdminDto {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private Role role;
    private String studentStatus;
    private Instant lastLogin;
    private Boolean isActive;
    private Boolean emailVerified;
    private Instant createdAt;
    private Instant updatedAt;

    public static class UserRepository {
    }
}
