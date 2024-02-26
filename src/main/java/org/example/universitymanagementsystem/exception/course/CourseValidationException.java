package org.example.universitymanagementsystem.exception.course;

import org.example.universitymanagementsystem.exception.ValidationException;

public class CourseValidationException extends ValidationException {
    public CourseValidationException(String message) {
        super(message);
    }
}
