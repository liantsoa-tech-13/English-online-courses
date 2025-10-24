package org.english.englishonlinecourse.Controller;

import lombok.RequiredArgsConstructor;
import org.english.englishonlinecourse.Service.LevelService;
import org.english.englishonlinecourse.Service.UserService;
import org.english.englishonlinecourse.dto.LevelDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/levels")
@RequiredArgsConstructor
public class LevelController {

    private final LevelService levelService;

    @GetMapping
    public ResponseEntity<List<LevelDto>> getLevelsNAme(){
        List<LevelDto> levelsName = levelService.findAllLevelName();
        return ResponseEntity.ok(levelsName);
    }
}
