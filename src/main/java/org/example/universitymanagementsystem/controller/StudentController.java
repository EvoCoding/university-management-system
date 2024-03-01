package org.example.universitymanagementsystem.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.universitymanagementsystem.dto.CreateStudentDTO;
import org.example.universitymanagementsystem.dto.FindStudentsDTO;
import org.example.universitymanagementsystem.dto.StudentDTO;
import org.example.universitymanagementsystem.dto.UpdateStudentDTO;
import org.example.universitymanagementsystem.service.StudentService;
import org.example.universitymanagementsystem.shared.PageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<PageResponse<StudentDTO>> findAll(FindStudentsDTO findStudentsDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.findAll(findStudentsDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid CreateStudentDTO createStudentDTO) {
        studentService.create(createStudentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody @Valid UpdateStudentDTO updateStudentDTO) {
        studentService.update(id, updateStudentDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        studentService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
