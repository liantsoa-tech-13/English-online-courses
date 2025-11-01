package org.english.englishonlinecourse.controller;

import lombok.RequiredArgsConstructor;
import org.english.englishonlinecourse.Service.LessonService;
import org.english.englishonlinecourse.dto.LessonDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/level")
public class LessonController {
    private final LessonService lessonService;

    @GetMapping("{levelId}/lessons")
    public List<LessonDto> getLessonsByLevel(
            @PathVariable Long levelId,
            @RequestParam(required = false) Long createdBy,
            @RequestParam(required = false) String searchTitle,
            @RequestParam(required = false) String updatedAtOrder
    ) {
        return lessonService.getLessonsByLevel(levelId, createdBy, searchTitle, updatedAtOrder);
    }
}
