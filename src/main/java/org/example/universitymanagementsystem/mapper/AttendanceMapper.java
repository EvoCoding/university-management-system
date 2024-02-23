package org.example.universitymanagementsystem.mapper;

import org.example.universitymanagementsystem.dto.AttendanceDTO;
import org.example.universitymanagementsystem.dto.UpdateAttendanceDTO;

import java.util.List;

public interface AttendanceMapper {
    List<AttendanceDTO> toAttendanceDTOList(Object attendanceEntities);

    void toAttendanceEntity(UpdateAttendanceDTO updateAttendanceDTO, Object attendance);
}
