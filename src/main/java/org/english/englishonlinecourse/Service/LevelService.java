package org.english.englishonlinecourse.Service;

import lombok.RequiredArgsConstructor;
import org.english.englishonlinecourse.dao.LevelAdminRepository;
import org.english.englishonlinecourse.dao.LevelRepository;
import org.english.englishonlinecourse.dto.LevelDto;
import org.english.englishonlinecourse.dto.LevelNameDto;
import org.english.englishonlinecourse.model.Level;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LevelService {
    private final LevelRepository levelRepository;
    private final LevelAdminRepository levelAdminRepository;

    @Transactional
    public LevelDto createLevel(LevelDto levelDto) {
        Level level = new Level();
        level.setName(levelDto.getName());
        level.setDescription(levelDto.getDescription());

        Level savedLevel = levelAdminRepository.save(level);

        return new LevelDto(
                savedLevel.getId(),
                savedLevel.getName(),
                savedLevel.getDescription(),
                savedLevel.getCreatedAt(),
                savedLevel.getUpdatedAt()
        );
    }

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
