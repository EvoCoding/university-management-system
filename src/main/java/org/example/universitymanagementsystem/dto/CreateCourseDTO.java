package org.example.universitymanagementsystem.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCourseDTO {
    private String name;
    private Long capacity;
    private String code;
    private int credit;
}
