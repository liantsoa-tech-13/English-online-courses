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
@Table(name = "student_answer")
public class StudentAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_answer_id_gen")
    @SequenceGenerator(name = "student_answer_id_gen", sequenceName = "student_answer_student_answer_id_seq", allocationSize = 1)
    @Column(name = "student_answer_id", nullable = false)
    private Long id;

    @ColumnDefault("('SA-'::text || gen_random_uuid())")
    @Column(name = "public_id", nullable = false, length = 50)
    private String publicId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_exercise_id", nullable = false)
    private UserExercise userExercise;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "exercise_question_id", nullable = false)
    private ExerciseQuestion exerciseQuestion;

    @Column(name = "answer", nullable = false, length = Integer.MAX_VALUE)
    private String answer;

    @Column(name = "is_correct")
    private Boolean isCorrect;

    @ColumnDefault("now()")
    @Column(name = "created_at")
    private Instant createdAt;

}