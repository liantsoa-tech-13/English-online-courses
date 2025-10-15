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
@Table(name = "user_answer")
public class UserAnswer {
    @Id
    @ColumnDefault("nextval('user_answer_user_answer_id_seq'::regclass)")
    @Column(name = "user_answer_id", nullable = false)
    private Long id;

    @ColumnDefault("('USR-'::text || gen_random_uuid())")
    @Column(name = "public_id", nullable = false, length = 50)
    private String publicId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_test_id", nullable = false)
    private UserTest userTest;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    @Column(name = "answer", length = Integer.MAX_VALUE)
    private String answer;

    @Column(name = "is_correct")
    private Boolean isCorrect;

    @ColumnDefault("now()")
    @Column(name = "created_at")
    private Instant createdAt;

}