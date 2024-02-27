package org.example.universitymanagementsystem.dto.grade;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
@Getter
@Setter
public class GradeDTO {
    private Long id;
    private Long studentId;
    private Long courseId;
    private Long instructorId;
    private Instant createdAt;
    private Instant modifiedAt;
}
