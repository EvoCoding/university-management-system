package org.example.universitymanagementsystem.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateGradeDTO {
    private Long studentId;

    private Long courseId;

    private Long instructorId;

    private int grade;
}
