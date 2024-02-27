package org.example.universitymanagementsystem.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.universitymanagementsystem.dto.course.CourseDTO;
import org.example.universitymanagementsystem.dto.course.CreateCourseDTO;
import org.example.universitymanagementsystem.dto.course.UpdateCourseDTO;
import org.example.universitymanagementsystem.service.CourseService;
import org.example.universitymanagementsystem.shared.PageRequest;
import org.example.universitymanagementsystem.shared.PageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {
    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<PageResponse<CourseDTO>> findAll(PageRequest pageRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(courseService.findAll(pageRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(courseService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateCourseDTO createCourseDTO) {
        courseService.create(createCourseDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody @Valid UpdateCourseDTO updateCourseDTO) {
        courseService.update(id, updateCourseDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PatchMapping("/{id}/capacity")
    public ResponseEntity<Void> updateCapacity(@PathVariable Long id, @RequestParam long capacity) {
        courseService.updateCapacity(id, capacity);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PatchMapping("/{id}/instructor")
    public ResponseEntity<Void> updateInstructor(@PathVariable Long id, @RequestParam(required = false) Long instructorId) {
        courseService.updateInstructor(instructorId, id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        courseService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
