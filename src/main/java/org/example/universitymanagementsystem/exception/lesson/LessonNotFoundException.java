package org.example.universitymanagementsystem.exception.lesson;

import org.example.universitymanagementsystem.exception.NotFoundException;

public class LessonNotFoundException extends NotFoundException {
    public LessonNotFoundException(String s) {
        super(s);
    }
}
