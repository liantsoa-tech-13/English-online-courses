package org.english.englishonlinecourse.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String publicId;
    private String firstname;
    private String lastname;
    private String email;
}
