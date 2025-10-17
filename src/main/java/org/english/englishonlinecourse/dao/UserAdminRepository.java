package org.english.englishonlinecourse.dao;

import org.english.englishonlinecourse.dto.UserAdminDto;

import java.util.List;

public interface UserAdminRepository {
    List<UserAdminDto> findAllForAdmin();
}
