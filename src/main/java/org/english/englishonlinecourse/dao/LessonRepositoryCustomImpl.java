package org.english.englishonlinecourse.dao;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.english.englishonlinecourse.dto.LessonDto;
import org.english.englishonlinecourse.model.QLesson;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class LessonRepositoryCustomImpl implements LessonRepositoryCustom{
    private final JPAQueryFactory queryFactory;

    @Override
    public List<LessonDto> findLessonsByLevelWithFilters(Long levelId, Long createdBy, String searchTitle, Boolean orderByUpdatedAt) {
        QLesson lesson = QLesson.lesson;

        BooleanExpression whereClause = lesson.level.id.eq(levelId);

        if (createdBy != null) {
            whereClause = whereClause.and(lesson.createdBy.id.eq(createdBy));
        }

        if (searchTitle != null && !searchTitle.isEmpty()) {
            whereClause = whereClause.and(lesson.title.containsIgnoreCase(searchTitle));
        }

        var query = queryFactory
                .select(Projections.bean(
                        LessonDto.class,
                        lesson.id.as("id"),
                        lesson.title.as("title"),
                        lesson.isSample.as("isSample"),
                        lesson.position.as("position"),
                        lesson.updatedAt.as("updatedAt"),
                        lesson.createdBy.id.as("createdBy")
                ))
                .from(lesson)
                .where(whereClause)
                .orderBy(orderByUpdatedAt != null && orderByUpdatedAt
                        ? lesson.updatedAt.asc()
                        : lesson.position.asc()
                );

        return query.fetch();
    }
}
