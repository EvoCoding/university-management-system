package org.example.universitymanagementsystem.dto.instructor;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateInstructorDTO {

    @NotBlank(message = "Name cannot be empty.")
    private String name;

    @NotBlank(message = "Experience cannot be empty.")
    private String experience;
}
