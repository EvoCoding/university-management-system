package org.example.universitymanagementsystem.exception.student;

import org.example.universitymanagementsystem.exception.ValidationException;

public class StudentValidationException extends ValidationException {
    public StudentValidationException(String message) {
        super(message);
    }
}
