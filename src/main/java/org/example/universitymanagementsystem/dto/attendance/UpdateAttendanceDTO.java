package org.example.universitymanagementsystem.dto.attendance;

import lombok.Getter;
import lombok.Setter;
import org.example.universitymanagementsystem.repository.entity.AttendanceTypeEnum;
@Getter
@Setter
public class UpdateAttendanceDTO {
    private AttendanceTypeEnum attendanceTypeEnum;
}
