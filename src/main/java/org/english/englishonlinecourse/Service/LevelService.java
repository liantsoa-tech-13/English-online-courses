package org.english.englishonlinecourse.Service;

import lombok.RequiredArgsConstructor;
import org.english.englishonlinecourse.dao.LevelRepository;
import org.english.englishonlinecourse.dto.LevelDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LevelService {
    private final LevelRepository levelRepository;

    public List<LevelDto> findAllLevelName() {
        return levelRepository.findAllLevelName();
    }
}
