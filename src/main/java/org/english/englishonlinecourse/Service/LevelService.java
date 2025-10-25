package org.english.englishonlinecourse.Service;

import lombok.RequiredArgsConstructor;
import org.english.englishonlinecourse.dao.LevelRepository;
import org.english.englishonlinecourse.dto.LevelDto;
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

    public List<LevelDto> findAllLevelName() {
        return levelRepository.findAllLevelName();
    }

    @Transactional
    public long updateLevel(Long id, String name, String description) {
        return levelRepository.updateLevelNameAndDescription(id, name, description);
    }
}
