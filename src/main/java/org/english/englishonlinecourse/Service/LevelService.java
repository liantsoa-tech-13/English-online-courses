package org.english.englishonlinecourse.Service;

import lombok.RequiredArgsConstructor;
import org.english.englishonlinecourse.dao.LevelRepository;
import org.english.englishonlinecourse.dto.LevelDto;
import org.english.englishonlinecourse.dto.LevelNameDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LevelService {
    private final LevelRepository levelRepository;

    public List<LevelDto> findAllLevels(){
        return levelRepository.findAllLevels();
    }

    public LevelDto getLevelById(Long id) {
        return levelRepository.findLevelById(id)
                .orElseThrow(() -> new RuntimeException("Level not found with id: " + id));
    }

    public List<LevelNameDto> findAllLevelName() {
        return levelRepository.findAllLevelName();
    }

    @Transactional
    public long updateLevel(Long id, String name, String description) {
        return levelRepository.updateLevelNameAndDescription(id, name, description);
    }
}
