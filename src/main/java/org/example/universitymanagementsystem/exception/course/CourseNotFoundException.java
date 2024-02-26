package org.example.universitymanagementsystem.exception.course;

import org.example.universitymanagementsystem.exception.NotFoundException;

public class CourseNotFoundException extends NotFoundException {
    public CourseNotFoundException(String message) {
        super(message);
    }
}
