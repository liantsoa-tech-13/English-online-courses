package org.english.englishonlinecourse.dao;

import org.english.englishonlinecourse.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserAdminRepository extends JpaRepository<User, Long> {
}
