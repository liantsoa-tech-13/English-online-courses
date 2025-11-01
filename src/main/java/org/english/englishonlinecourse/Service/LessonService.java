package org.english.englishonlinecourse.Service;

import lombok.RequiredArgsConstructor;
import org.english.englishonlinecourse.dao.LessonRepositoryCustomImpl;
import org.english.englishonlinecourse.dto.LessonDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonService {
    public final LessonRepositoryCustomImpl lessonRepositoryCustom;

    public List<LessonDto> getLessonsByLevel(Long levelId, Long createdBy, String searchTitle, String updatedAtOrder) {
        return lessonRepositoryCustom.findLessonsByLevelWithFilters(levelId, createdBy, searchTitle, updatedAtOrder);
    }
}
