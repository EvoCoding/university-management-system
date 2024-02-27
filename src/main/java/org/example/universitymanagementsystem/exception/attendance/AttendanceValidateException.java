package org.example.universitymanagementsystem.exception.attendance;

import org.example.universitymanagementsystem.exception.ValidationException;

public class AttendanceValidateException extends ValidationException {
    public AttendanceValidateException(String s) {
        super(s);
    }
}
