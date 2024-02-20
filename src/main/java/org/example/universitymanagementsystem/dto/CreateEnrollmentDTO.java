package org.example.universitymanagementsystem.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateEnrollmentDTO {

    @NotBlank(message = "Student Id cannot be empty.")
    private Long studentId;

    @NotBlank(message = "Course Id cannot be empty.")
    private Long courseId;
}
