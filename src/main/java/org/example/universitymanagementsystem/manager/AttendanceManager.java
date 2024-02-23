package org.example.universitymanagementsystem.manager;

import lombok.RequiredArgsConstructor;
import org.example.universitymanagementsystem.exception.AttendanceNotFoundException;
import org.example.universitymanagementsystem.repository.AttendanceRepository;
import org.example.universitymanagementsystem.repository.entity.AttendanceEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AttendanceManager {
    public final AttendanceRepository attendanceRepository;

    public List<AttendanceEntity> findAll() {
        return attendanceRepository.findAll();
    }

    public AttendanceEntity getAttendance(Long id) {
        return attendanceRepository.findById(id)
                .orElseThrow(() -> new AttendanceNotFoundException("Attendance Not Found: " + id));
    }
}
