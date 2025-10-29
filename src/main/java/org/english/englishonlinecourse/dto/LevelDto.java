package org.english.englishonlinecourse.dto;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LevelDto {
    private Long id;
    private String name;
    private String description;
    private Instant createdAt;
    private Instant updatedAt;
    private String status;
    private Long lessonCount;

    public LevelDto(Long id, String name, Instant updatedAt, String status, Long lessonCount) {
        this.id = id;
        this.name = name;
        this.updatedAt = updatedAt;
        this.status = status;
        this.lessonCount = lessonCount;
    }
}
