package org.english.englishonlinecourse.Controller;

import lombok.RequiredArgsConstructor;
import org.english.englishonlinecourse.Service.UserService;
import org.english.englishonlinecourse.dto.UserAdminDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserAdminDto>> getAllUsers(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String role,
            @RequestParam(required = false) String studentStatus,
            @RequestParam(required = false) Boolean isActive,
            @RequestParam(required = false) Boolean emailVerified,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        List<UserAdminDto> users = userService.findAllWithFilters(name, email, role, studentStatus, isActive, emailVerified, page, size);
        return ResponseEntity.ok(users);
    }
}
