package org.example.universitymanagementsystem.exception.attendance;

import org.example.universitymanagementsystem.exception.NotFoundException;

public class AttendanceNotFoundException extends NotFoundException {
    public AttendanceNotFoundException(String message) {
        super(message);
    }
}
