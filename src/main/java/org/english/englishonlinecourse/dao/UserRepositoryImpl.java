package org.english.englishonlinecourse.dao;

import lombok.RequiredArgsConstructor;
import org.english.englishonlinecourse.dto.UserAdminDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserAdminRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<UserAdminDto> findAllForAdmin() {
        QUser user = QUser.user;

        return queryFactory
                .select(Projections.constructor(
                        UserAdminDto.class,
                        user.id,
                        user.firstname,
                        user.lastname,
                        user.email,
                        user.lastLogin,
                        user.isActive,
                        user.createdAt,
                        user.updatedAt
                ))
                .from(user)
                .fetch();
    }
}
