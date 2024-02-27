package org.example.universitymanagementsystem.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.universitymanagementsystem.dto.instructor.CreateInstructorDTO;
import org.example.universitymanagementsystem.dto.instructor.InstructorDTO;
import org.example.universitymanagementsystem.dto.instructor.InstructorDetailsDTO;
import org.example.universitymanagementsystem.dto.instructor.UpdateInstructorDTO;
import org.example.universitymanagementsystem.service.InstructorService;
import org.example.universitymanagementsystem.shared.PageRequest;
import org.example.universitymanagementsystem.shared.PageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/instructors")
@RequiredArgsConstructor
public class InstructorController {
    private final InstructorService instructorService;

    @GetMapping
    public ResponseEntity<PageResponse<InstructorDTO>> findAll(PageRequest pageRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(instructorService.findAll(pageRequest));
    }

    @GetMapping("/{id}")
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
    public ResponseEntity<Void>delete(@PathVariable Long id){
        instructorService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
