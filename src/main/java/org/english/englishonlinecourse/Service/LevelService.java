package org.english.englishonlinecourse.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.english.englishonlinecourse.dao.LevelAdminRepository;
import org.english.englishonlinecourse.dao.LevelRepository;
import org.english.englishonlinecourse.dto.LevelCreationDto;
import org.english.englishonlinecourse.dto.LevelDto;
import org.english.englishonlinecourse.dto.LevelNameDto;
import org.english.englishonlinecourse.model.Level;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LevelService {
    private final LevelAdminRepository levelAdminRepository;
    private final LevelRepository levelRepository;
    private final EntityManager entityManager;

    @Transactional
    public Level createLevel(LevelCreationDto dto) {
        Level level = new Level();
        level.setName(dto.getName());
        level.setDescription(dto.getDescription());

        levelRepository.saveAndFlush(level);
        entityManager.refresh(level);
        return level;
    }

    @Transactional
    public Level updateLevel(Long id, String name, String description, String status) {
        Level level = levelRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Level not found with id: " + id));

        if (name != null) {
            level.setName(name);
        }
        if (description != null) {
            level.setDescription(description);
        }
        if (status != null) {
            level.setStatus(status);
        }

        levelRepository.saveAndFlush(level);       // save changes first
        entityManager.refresh(level);      // then reload DB-triggered fields like updatedAt
        return level;
    }

    public List<LevelDto> findAllLevelDetails(){
        return levelAdminRepository.findAllLevelDetails();
    }

    public LevelDto getLevelById(Long id) {
        return levelAdminRepository.findLevelById(id)
                .orElseThrow(() -> new RuntimeException("Level not found with id: " + id));
    }
}
