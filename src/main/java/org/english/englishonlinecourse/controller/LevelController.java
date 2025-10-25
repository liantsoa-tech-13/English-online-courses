package org.english.englishonlinecourse.controller;

import lombok.RequiredArgsConstructor;
import org.english.englishonlinecourse.Service.LevelService;
import org.english.englishonlinecourse.dto.LevelDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LevelController {

    private final LevelService levelService;

    @GetMapping("/level/name")
    public ResponseEntity<List<LevelDto>> getLevelsNAme(){
        List<LevelDto> levelsName = levelService.findAllLevelName();
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
