package org.english.englishonlinecourse.controller;

import lombok.RequiredArgsConstructor;
import org.english.englishonlinecourse.Service.LevelService;
import org.english.englishonlinecourse.dto.LevelCreationDto;
import org.english.englishonlinecourse.dto.LevelDto;
import org.english.englishonlinecourse.dto.LevelNameDto;
import org.english.englishonlinecourse.model.Level;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LevelController {

    private final LevelService levelService;

    @GetMapping("/levels")
    public ResponseEntity<List<LevelDto>> getAllLevelDetails(){
        List<LevelDto> levels = levelService.findAllLevelDetails();
        return ResponseEntity.ok(levels);
    }

    @GetMapping("/level/{id}")
    public ResponseEntity<LevelDto> getLevelById(@PathVariable Long id) {
        LevelDto levelDto = levelService.getLevelById(id);
        return ResponseEntity.ok(levelDto);
    }

    @PutMapping("/level/{id}")
    public ResponseEntity<Level> updateLevel(
            @PathVariable Long id,
            @RequestBody LevelDto dto
    ) {
        Level updated = levelService.updateLevel(id, dto.getName(), dto.getDescription(), dto.getStatus());
        return ResponseEntity.ok(updated);
    }

    @PostMapping("/level")
    public ResponseEntity<Level> createLevel(@RequestBody LevelCreationDto dto) {
        Level level = levelService.createLevel(dto);
        return ResponseEntity.ok(level);
    }
}
