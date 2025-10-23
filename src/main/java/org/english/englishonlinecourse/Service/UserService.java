package org.english.englishonlinecourse.Service;

import lombok.RequiredArgsConstructor;
import org.english.englishonlinecourse.dao.UserRepository;
import org.english.englishonlinecourse.dto.UserAdminDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserAdminDto> findAllWithFilters(
            String name,
            String email,
            String roleName,
            String studentStatus,
            Boolean isActive,
            Boolean emailVerified
    ) {
        return userRepository.findAllWithFilters(name, email, roleName, studentStatus, isActive, emailVerified);
    }
}

