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

    public LevelDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
