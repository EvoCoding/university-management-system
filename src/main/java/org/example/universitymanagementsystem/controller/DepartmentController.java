package org.example.universitymanagementsystem.controller;

import lombok.RequiredArgsConstructor;
import org.example.universitymanagementsystem.dto.DepartmentDTO;
import org.example.universitymanagementsystem.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/departments")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(departmentService.findAll());
    }
}
