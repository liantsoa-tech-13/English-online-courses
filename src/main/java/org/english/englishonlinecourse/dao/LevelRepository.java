package org.english.englishonlinecourse.dao;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.english.englishonlinecourse.dto.LevelDto;
import org.english.englishonlinecourse.model.QLevel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class LevelRepository {
    private final JPAQueryFactory queryFactory;

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

}
