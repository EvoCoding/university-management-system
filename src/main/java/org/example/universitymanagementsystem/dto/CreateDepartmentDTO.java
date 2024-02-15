package org.example.universitymanagementsystem.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateDepartmentDTO {
    private String name;
    private String code;
    private Long capacity;
}
