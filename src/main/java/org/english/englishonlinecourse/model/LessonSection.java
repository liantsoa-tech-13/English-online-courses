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
@Table(name = "lesson_section")
public class LessonSection {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lesson_section_id_gen")
    @SequenceGenerator(name = "lesson_section_id_gen", sequenceName = "lesson_section_section_id_seq", allocationSize = 1)
    @Column(name = "section_id", nullable = false)
    private Long id;

    @ColumnDefault("('LVL-'::text || gen_random_uuid())")
    @Column(name = "public_id", nullable = false, length = 50)
    private String publicId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "lesson_id", nullable = false)
    private Lesson lesson;

    @Column(name = "content", length = Integer.MAX_VALUE)
    private String content;

    @ColumnDefault("1")
    @Column(name = "\"position\"")
    private Integer position;

    @ColumnDefault("now()")
    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

}