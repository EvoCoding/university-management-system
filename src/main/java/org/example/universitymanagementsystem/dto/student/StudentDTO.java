package org.example.universitymanagementsystem.dto.student;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class StudentDTO {
    private Long id;
    private String name;
    private Instant createdAt;
    private Instant modifiedAt;
}
