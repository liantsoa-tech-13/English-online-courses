package org.english.englishonlinecourse.dao;

import com.querydsl.core.types.OrderSpecifier;
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
    public List<LessonDto> findLessonsByLevelWithFilters(
            Long levelId,
            Long createdBy,
            String title,
            String status,
            String updatedAt,
            String position,
            int page,
            int size
    ) {
        QLesson lesson = QLesson.lesson;

        BooleanExpression whereClause = lesson.level.id.eq(levelId);

        int offset = (page - 1) * size;

        if (createdBy != null) {
            whereClause = whereClause.and(lesson.createdBy.id.eq(createdBy));
        }

        if (title != null && !title.isEmpty()) {
            whereClause = whereClause.and(lesson.title.containsIgnoreCase(title));
        }

        if (status != null && !status.isEmpty()) {
            whereClause = whereClause.and(lesson.status.eq(status));
        }

        OrderSpecifier<?> orderBy;
        if ("asc".equalsIgnoreCase(updatedAt)) {
            orderBy = lesson.updatedAt.asc();
        } else if ("desc".equalsIgnoreCase(updatedAt)) {
            orderBy = lesson.updatedAt.desc();
        } else {
            if ("DRAFT".equalsIgnoreCase(status)) {
                orderBy = "desc".equalsIgnoreCase(position) ? lesson.id.desc() : lesson.id.asc();
            } else {
                orderBy = "desc".equalsIgnoreCase(position) ? lesson.position.desc() : lesson.position.asc();
            }
        }

        return queryFactory
                .select(Projections.bean(
                        LessonDto.class,
                        lesson.id.as("id"),
                        lesson.title.as("title"),
                        lesson.isSample.as("isSample"),
                        lesson.position.as("position"),
                        lesson.updatedAt.as("updatedAt"),
                        lesson.createdBy.id.as("createdBy"),
                        lesson.status.as("status")
                ))
                .from(lesson)
                .where(whereClause)
                .orderBy(orderBy)
                .offset(offset)
                .limit(size)
                .fetch();
    }
}
