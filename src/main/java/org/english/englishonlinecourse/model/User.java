package org.english.englishonlinecourse.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "\"user\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_gen")
    @SequenceGenerator(name = "user_id_gen", sequenceName = "user_user_id_seq", allocationSize = 1)
    @Column(name = "user_id", nullable = false)
    private Long id;

    @ColumnDefault("('USR-'::text || gen_random_uuid())")
    @Column(name = "public_id", nullable = false, length = 50)
    private String publicId;

    @Column(name = "firstname", length = 100)
    private String firstname;

    @Column(name = "lastname", length = 100)
    private String lastname;

    @Column(name = "email", nullable = false, length = Integer.MAX_VALUE)
    private String email;

    @Column(name = "password_hash", nullable = false, length = Integer.MAX_VALUE)
    private String passwordHash;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @ColumnDefault("'prospect'")
    @Column(name = "student_status", length = Integer.MAX_VALUE)
    private String studentStatus;

    @Column(name = "last_login")
    private Instant lastLogin;

    @ColumnDefault("true")
    @Column(name = "is_active")
    private Boolean isActive;

    @ColumnDefault("false")
    @Column(name = "email_verified")
    private Boolean emailVerified;

    @ColumnDefault("now()")
    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;
}