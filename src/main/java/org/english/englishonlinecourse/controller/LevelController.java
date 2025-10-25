package org.english.englishonlinecourse.controller;

import lombok.RequiredArgsConstructor;
import org.english.englishonlinecourse.Service.LevelService;
import org.english.englishonlinecourse.dto.LevelDto;
import org.english.englishonlinecourse.dto.LevelNameDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LevelController {

    private final LevelService levelService;

    @GetMapping("/levels")
    public ResponseEntity<List<LevelDto>> getAllLevels(){
        List<LevelDto> levels = levelService.findAllLevels();
        return ResponseEntity.ok(levels);
    }

    @GetMapping("/level/{id}")
    public ResponseEntity<LevelDto> getLevelById(@PathVariable Long id) {
        LevelDto levelDto = levelService.getLevelById(id);
        return ResponseEntity.ok(levelDto);
    }

    @GetMapping("/levels/name")
    public ResponseEntity<List<LevelNameDto>> getLevelsNAme(){
        List<LevelNameDto> levelsName = levelService.findAllLevelName();
        return ResponseEntity.ok(levelsName);
    }

    @PutMapping("/level/{id}")
    public ResponseEntity<String> updateLevel(
            @PathVariable Long id,
            @RequestBody LevelDto levelDto) {

        long updatedCount = levelService.updateLevel(id, levelDto.getName(), levelDto.getDescription());

        if (updatedCount == 1) {
            return ResponseEntity.ok("Level updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
