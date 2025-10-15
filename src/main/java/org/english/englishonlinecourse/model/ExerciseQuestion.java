package org.english.englishonlinecourse.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "exercise_question")
public class ExerciseQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "exercise_question_id_gen")
    @SequenceGenerator(name = "exercise_question_id_gen", sequenceName = "exercise_question_question_id_seq", allocationSize = 1)
    @Column(name = "question_id", nullable = false)
    private Long id;

    @ColumnDefault("('EQ-'::text || gen_random_uuid())")
    @Column(name = "public_id", nullable = false, length = 50)
    private String publicId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "exercise_id", nullable = false)
    private Exercise exercise;

    @Column(name = "question_text", nullable = false, length = Integer.MAX_VALUE)
    private String questionText;

    @Column(name = "correct_answer", nullable = false, length = Integer.MAX_VALUE)
    private String correctAnswer;

    @ColumnDefault("'fill-in'")
    @Column(name = "question_type", length = Integer.MAX_VALUE)
    private String questionType;

    @ColumnDefault("1")
    @Column(name = "points")
    private Integer points;

    @ColumnDefault("1")
    @Column(name = "\"position\"")
    private Integer position;

    @ColumnDefault("now()")
    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

}