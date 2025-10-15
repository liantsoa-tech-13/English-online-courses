package org.english.englishonlinecourse.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "exercise")
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "exercise_id_gen")
    @SequenceGenerator(name = "exercise_id_gen", sequenceName = "exercise_exercise_id_seq", allocationSize = 1)
    @Column(name = "exercise_id", nullable = false)
    private Long id;

    @Column(name = "title", nullable = false, length = Integer.MAX_VALUE)
    private String title;

    @ColumnDefault("'quiz'")
    @Column(name = "exercise_type", length = Integer.MAX_VALUE)
    private String exerciseType;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @ColumnDefault("1")
    @Column(name = "\"position\"")
    private Integer position;

    @ColumnDefault("1")
    @Column(name = "points")
    private Integer points;

    @ColumnDefault("now()")
    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

}