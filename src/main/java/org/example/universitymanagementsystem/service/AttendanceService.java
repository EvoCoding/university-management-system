package org.example.universitymanagementsystem.service;

import lombok.RequiredArgsConstructor;
import org.example.universitymanagementsystem.dto.AttendanceDTO;
import org.example.universitymanagementsystem.dto.UpdateAttendanceDTO;
import org.example.universitymanagementsystem.manager.AttendanceManager;
import org.example.universitymanagementsystem.mapper.AttendanceMapper;
import org.example.universitymanagementsystem.repository.AttendanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class AttendanceService {
    private final AttendanceMapper attendanceMapper;
    private final AttendanceManager attendanceManager;
    private final AttendanceRepository attendanceRepository;

    public List<AttendanceDTO> findAll() {
        var attendanceEntities = attendanceManager.findAll();
        return attendanceMapper.toAttendanceDTOList(attendanceEntities);
    }

    public void update(Long id, UpdateAttendanceDTO updateAttendanceDTO) {
        var attendance = attendanceManager.getAttendance(id);
        attendanceMapper.toAttendanceEntity(updateAttendanceDTO, attendance);
        attendanceRepository.save(attendance);
    }
}
