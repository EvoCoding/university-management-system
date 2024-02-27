package org.example.universitymanagementsystem.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.universitymanagementsystem.dto.department.CreateDepartmentDTO;
import org.example.universitymanagementsystem.dto.department.DepartmentDetailsDTO;
import org.example.universitymanagementsystem.dto.department.UpdateDepartmentDto;
import org.example.universitymanagementsystem.dto.course.UpdateCourseDTO;
import org.example.universitymanagementsystem.service.DepartmentService;
import org.example.universitymanagementsystem.shared.PageRequest;
import org.example.universitymanagementsystem.shared.PageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/departments")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<PageResponse<UpdateCourseDTO.DepartmentDTO>> findAll(PageRequest pageRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(departmentService.findAll(pageRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDetailsDTO> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(departmentService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid CreateDepartmentDTO createDepartmentDTO) {
        departmentService.create(createDepartmentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody @Valid UpdateDepartmentDto updateDepartmentDto) {
        departmentService.update(id, updateDepartmentDto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        departmentService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
