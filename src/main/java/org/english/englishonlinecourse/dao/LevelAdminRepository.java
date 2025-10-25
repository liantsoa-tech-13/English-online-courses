package org.english.englishonlinecourse.dao;

import org.english.englishonlinecourse.model.Level;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LevelAdminRepository extends JpaRepository<Level, Long> {
}
