package org.example.universitymanagementsystem.exception.grade;

import org.example.universitymanagementsystem.exception.ValidationException;

public class GradeValidationException extends ValidationException {
    public GradeValidationException(String message) {
        super(message);
    }
}
