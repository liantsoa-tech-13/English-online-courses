package org.english.englishonlinecourse.dto;


import lombok.*;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LessonDto {
    private String title;
    private Boolean isSample;
    private Integer position;
    private Instant updatedAt;
    private Long createdBy;
}
