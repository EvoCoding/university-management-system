package org.example.universitymanagementsystem.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateStudentDTO {
    private String name;
    private String email;
    private String address;
    private String phoneNumber;
}
