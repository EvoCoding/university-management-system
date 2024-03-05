package org.example.universitymanagementsystem.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.universitymanagementsystem.dto.*;
import org.example.universitymanagementsystem.service.InstructorService;
import org.example.universitymanagementsystem.shared.PageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/instructors")
@RequiredArgsConstructor
public class InstructorController {
    private final InstructorService instructorService;

    @GetMapping
    public ResponseEntity<PageResponse<InstructorDTO>> findAll(FindInstructorsDTO findInstructorsDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(instructorService.findAll(findInstructorsDTO));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('INSTRUCTOR', 'DEPARTMENT')")
    public ResponseEntity<InstructorDetailsDTO> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(instructorService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid CreateInstructorDTO createInstructorDTO) {
        instructorService.create(createInstructorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody @Valid UpdateInstructorDTO updateInstructorDTO) {
        instructorService.update(id, updateInstructorDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        instructorService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
