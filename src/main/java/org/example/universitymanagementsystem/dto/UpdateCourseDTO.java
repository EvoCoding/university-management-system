package org.example.universitymanagementsystem.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCourseDTO {
    private String name;
    private Long capacity;
    private String code;
    private int credit;
}
