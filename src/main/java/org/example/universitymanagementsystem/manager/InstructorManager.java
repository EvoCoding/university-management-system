package org.example.universitymanagementsystem.manager;

import lombok.RequiredArgsConstructor;
import org.example.universitymanagementsystem.exception.InstructorNotFoundException;
import org.example.universitymanagementsystem.repository.InstructorRepository;
import org.example.universitymanagementsystem.repository.entity.InstructorEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class InstructorManager {
    private final InstructorRepository instructorRepository;

    public InstructorEntity getInstructor(Long id) {
        return instructorRepository.findById(id)
                .orElseThrow(() -> new InstructorNotFoundException("Instructor not found with id:" + id));
    }

    public List<InstructorEntity> findAllByIsDeleted() {
        return instructorRepository.findAllByIsDeleted(false);
    }

    public Optional<InstructorEntity> findByIdAndIsDeleted(Long id) {
        return instructorRepository.findByIdAndIsDeleted(id, false);
    }
}
