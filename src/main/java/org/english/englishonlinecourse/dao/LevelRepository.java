package org.english.englishonlinecourse.dao;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.english.englishonlinecourse.dto.LevelDto;
import org.english.englishonlinecourse.model.QLevel;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class LevelRepository {
    private final JPAQueryFactory queryFactory;

    @PersistenceContext
    private EntityManager entityManager;

    public List<LevelDto> findAllLevelName(){
        QLevel level = QLevel.level;

        return queryFactory
                .select(Projections.constructor(
                        LevelDto.class,
                        level.id,
                        level.name
                ))
                .from(level)
                .orderBy(level.id.asc())
                .fetch();
    }

    @Transactional
    public long updateLevelNameAndDescription(Long id, String name, String description) {
        QLevel level = QLevel.level;

        JPAUpdateClause update = new JPAUpdateClause(entityManager, level);

        if (name != null) {
            update.set(level.name, name);
        }
        if (description != null) {
            update.set(level.description, description);
        }

        return update.where(level.id.eq(id)).execute();
    }

}
