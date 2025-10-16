package org.english.englishonlinecourse.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "test")
public class Test {
    @Id
    @ColumnDefault("nextval('test_test_id_seq'::regclass)")
    @Column(name = "test_id", nullable = false)
    private Long id;

    @ColumnDefault("('TST-'::text || gen_random_uuid())")
    @Column(name = "public_id", nullable = false, length = 50)
    private String publicId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "level_id", nullable = false)
    private Level level;

    @Column(name = "title", nullable = false, length = Integer.MAX_VALUE)
    private String title;

    @ColumnDefault("10")
    @Column(name = "passing_score")
    private Integer passingScore;

    @Column(name = "time_limit")
    private Integer timeLimit;

    @Column(name = "test_type", nullable = false, length = 20)
    private String testType;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @ColumnDefault("now()")
    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

}