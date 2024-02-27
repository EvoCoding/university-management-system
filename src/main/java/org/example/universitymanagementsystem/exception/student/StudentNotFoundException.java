package org.example.universitymanagementsystem.exception.student;

import org.example.universitymanagementsystem.exception.NotFoundException;

public class StudentNotFoundException extends NotFoundException {
    public StudentNotFoundException(String message) {
        super(message);
    }
}
