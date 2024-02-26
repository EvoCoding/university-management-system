package org.example.universitymanagementsystem.exception.lesson;

import org.example.universitymanagementsystem.exception.ValidationException;

public class LessonValidationException extends ValidationException {
    public LessonValidationException(String message) {
        super(message);
    }
}
