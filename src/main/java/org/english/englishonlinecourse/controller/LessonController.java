package org.english.englishonlinecourse.controller;

import lombok.RequiredArgsConstructor;
import org.english.englishonlinecourse.Service.LessonService;
import org.english.englishonlinecourse.dto.LessonDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/level")
public class LessonController {
    private final LessonService lessonService;

    @GetMapping("/{levelId}/lessons")
    public ResponseEntity<List<LessonDto>> getLessonsByLevel(
            @PathVariable Long levelId,
            @RequestParam(required = false) Long createdBy,
            @RequestParam(required = false) String title,
            @RequestParam(defaultValue = "PUBLISHED") String status,
            @RequestParam(required = false) String updatedAt,
            @RequestParam(required = false) String position,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        List<LessonDto> lessons = lessonService.getLessonsByLevel(
                levelId,
                createdBy,
                title,
                status,
                updatedAt,
                position,
                page,
                size
        );

        return ResponseEntity.ok(lessons);
    }
}
