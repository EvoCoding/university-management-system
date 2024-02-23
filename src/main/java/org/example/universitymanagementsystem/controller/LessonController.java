package org.example.universitymanagementsystem.controller;

import lombok.RequiredArgsConstructor;
import org.example.universitymanagementsystem.dto.CreateLessonAttendanceDTO;
import org.example.universitymanagementsystem.dto.CreateLessonDTO;
import org.example.universitymanagementsystem.service.LessonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/lessons")
@RequiredArgsConstructor
public class LessonController {
    private final LessonService lessonService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateLessonDTO createLessonDTO) {
        lessonService.create(createLessonDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/{lessonId}/students/{studentId}")
    public ResponseEntity<Void> createAttendance(@PathVariable Long lessonId, @PathVariable Long studentId, @RequestBody CreateLessonAttendanceDTO createLessonAttendanceDTO) {
        lessonService.createAttendance(lessonId, studentId, createLessonAttendanceDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
