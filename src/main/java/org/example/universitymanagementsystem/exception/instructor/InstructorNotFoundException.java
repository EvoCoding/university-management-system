package org.example.universitymanagementsystem.exception.instructor;

import org.example.universitymanagementsystem.exception.NotFoundException;

public class InstructorNotFoundException extends NotFoundException {
    public InstructorNotFoundException(String message) {
        super(message);
    }
}
