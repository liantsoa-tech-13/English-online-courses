package org.english.englishonlinecourse.dao;

import org.english.englishonlinecourse.dto.LessonDto;

import java.util.List;

public interface LessonRepositoryCustom {
    List<LessonDto> findLessonsByLevelWithFilters(Long levelId, Long createdBy, String title, String status, String updatedAt, String position, int page, int size);
}
