package org.example.universitymanagementsystem.manager;

import lombok.RequiredArgsConstructor;
import org.example.universitymanagementsystem.annotation.Manager;
import org.example.universitymanagementsystem.exception.instructor.InstructorNotFoundException;
import org.example.universitymanagementsystem.repository.InstructorRepository;
import org.example.universitymanagementsystem.repository.entity.InstructorEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@Manager
@RequiredArgsConstructor
public class InstructorManager {
    private final InstructorRepository instructorRepository;

    public InstructorEntity getInstructor(Long id) {
        return instructorRepository.findByIdAndIsDeleted(id, false)
                .orElseThrow(() -> new InstructorNotFoundException("Instructor not found with id:" + id));
    }

    public Page<InstructorEntity> findAllByIsDeleted(int page ,int size) {
        var pageable= PageRequest.of(page,size);
        return instructorRepository.findAllByIsDeleted(false, pageable);
    }

}
