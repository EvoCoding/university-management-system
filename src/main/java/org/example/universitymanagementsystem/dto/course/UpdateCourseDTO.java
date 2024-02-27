package org.example.universitymanagementsystem.dto.course;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class UpdateCourseDTO {

    @NotBlank(message = "Name cannot be empty.")
    private String name;

    @NotBlank(message = "Capacity cannot be empty.")
    private Long capacity;

    @NotBlank(message = "Code cannot be empty.")
    private String code;

    @NotBlank(message = "Credit cannot be empty.")
    private int credit;

    @Getter
    @Setter
    public static class DepartmentDTO {
        private Long id;
        private String name;
        private String code;
        private Instant createdAt;
        private Instant modifiedAt;
    }
}
