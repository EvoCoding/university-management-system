package org.example.universitymanagementsystem.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateDepartmentDto {
    private String name;
    private String code;
    private Long capacity;
}
