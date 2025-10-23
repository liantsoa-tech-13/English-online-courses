package org.english.englishonlinecourse.dao;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.english.englishonlinecourse.dto.UserAdminDto;
import org.english.englishonlinecourse.model.QRole;
import org.english.englishonlinecourse.model.QUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final JPAQueryFactory queryFactory;

    public List<UserAdminDto> findAllWithFilters(
            String name,
            String email,
            String roleName,
            String studentStatus,
            Boolean isActive,
            Boolean emailVerified
    ) {
        QUser user = QUser.user;
        QRole role = QRole.role;

        BooleanBuilder builder = new BooleanBuilder();

        if (name != null && !name.isBlank()) {
            builder.and(user.firstname.concat(" ").concat(user.lastname).containsIgnoreCase(name));
        }
        if (email != null && !email.isBlank()) {
            builder.and(user.email.containsIgnoreCase(email));
        }
        if (roleName != null && !roleName.isBlank()) {
            builder.and(role.name.equalsIgnoreCase(roleName));
        }
        if (studentStatus != null && !studentStatus.isBlank()) {
            builder.and(user.studentStatus.eq(studentStatus));
        }
        if (isActive != null) {
            builder.and(user.isActive.eq(isActive));
        }
        if (emailVerified != null) {
            builder.and(user.emailVerified.eq(emailVerified));
        }

        return queryFactory
                .select(Projections.constructor(
                        UserAdminDto.class,
                        user.id,
                        user.firstname,
                        user.lastname,
                        user.email,
                        user.role,
                        user.studentStatus,
                        user.lastLogin,
                        user.isActive,
                        user.emailVerified,
                        user.createdAt,
                        user.updatedAt
                ))
                .from(user)
                .leftJoin(user.role, role)
                .where(builder)
                .orderBy(user.createdAt.desc())
                .fetch();
    }
}

