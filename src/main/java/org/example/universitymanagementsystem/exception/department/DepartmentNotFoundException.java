package org.example.universitymanagementsystem.exception.department;

import org.example.universitymanagementsystem.exception.NotFoundException;

public class DepartmentNotFoundException extends NotFoundException {
    public DepartmentNotFoundException(String message) {
        super(message);
    }
}
