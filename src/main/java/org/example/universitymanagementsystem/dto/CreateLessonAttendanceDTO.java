package org.example.universitymanagementsystem.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.universitymanagementsystem.repository.entity.AttendanceTypeEnum;
@Getter
@Setter
public class CreateLessonAttendanceDTO {
    private AttendanceTypeEnum attendanceTypeEnum;
}
