package org.example.universitymanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateEnrollmentDTO {
    private Long studentId;
    private Long courseId;
}
