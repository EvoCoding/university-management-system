package org.example.universitymanagementsystem.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.universitymanagementsystem.dto.AttendanceDTO;
import org.example.universitymanagementsystem.dto.UpdateAttendanceDTO;
import org.example.universitymanagementsystem.service.AttendanceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/attendance")
@RequiredArgsConstructor
public class AttendanceController {
    private final AttendanceService attendanceService;
    @GetMapping
    public ResponseEntity<List<AttendanceDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(attendanceService.findAll());
    }
    @PutMapping
    public ResponseEntity<Void>update(@PathVariable Long id, @RequestBody @Valid UpdateAttendanceDTO updateAttendanceDTO){
        attendanceService.update(id,updateAttendanceDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
