package org.example.universitymanagementsystem.manager;

import lombok.RequiredArgsConstructor;
import org.example.universitymanagementsystem.exception.InstructorNotFoundException;
import org.example.universitymanagementsystem.repository.InstructorRepository;
import org.example.universitymanagementsystem.repository.entity.InstructorEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InstructorManager {
    private final InstructorRepository instructorRepository;

    public InstructorEntity getInstructor(Long id) {
        return instructorRepository.findById(id)
                .orElseThrow(() -> new InstructorNotFoundException("Instructor not found with id:" + id));
    }
}
