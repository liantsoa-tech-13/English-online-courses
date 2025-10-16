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
@Table(name = "lesson_media")
public class LessonMedia {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lesson_media_id_gen")
    @SequenceGenerator(name = "lesson_media_id_gen", sequenceName = "lesson_media_media_id_seq", allocationSize = 1)
    @Column(name = "media_id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "lesson_id", nullable = false)
    private Lesson lesson;

    @Column(name = "media_type", nullable = false, length = Integer.MAX_VALUE)
    private String mediaType;

    @Column(name = "media_url", nullable = false, length = Integer.MAX_VALUE)
    private String mediaUrl;

    @ColumnDefault("1")
    @Column(name = "\"position\"")
    private Integer position;

    @ColumnDefault("now()")
    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

}