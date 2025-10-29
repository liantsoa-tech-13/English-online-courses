package org.english.englishonlinecourse.dao;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.english.englishonlinecourse.dto.LevelDto;
import org.english.englishonlinecourse.dto.LevelNameDto;
import org.english.englishonlinecourse.model.QLesson;
import org.english.englishonlinecourse.model.QLevel;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class LevelAdminRepository {
    private final JPAQueryFactory queryFactory;

    @PersistenceContext
    private EntityManager entityManager;

    public List<LevelDto> findAllLevelDetails() {
        QLevel level = QLevel.level;
        QLesson lesson = QLesson.lesson;

        return queryFactory
                .select(Projections.bean(LevelDto.class,
                        level.id.as("id"),
                        level.name.as("name"),
                        level.updatedAt.as("updatedAt"),
                        level.status.as("status"),
                        lesson.count().as("lessonCount")
                ))
                .from(level)
                .leftJoin(lesson).on(lesson.level.id.eq(level.id))
                .groupBy(level.id, level.name, level.updatedAt, level.status)
                .orderBy(level.id.asc())
                .fetch();
    }

    public Optional<LevelDto> findLevelById(Long id) {
        QLevel level = QLevel.level;

        LevelDto result = queryFactory
                .select(Projections.constructor(
                        LevelDto.class,
                        level.id,
                        level.name,
                        level.description,
                        level.createdAt,
                        level.updatedAt
                ))
                .from(level)
                .where(level.id.eq(id))
                .fetchOne();

        return Optional.ofNullable(result);
    }
}
