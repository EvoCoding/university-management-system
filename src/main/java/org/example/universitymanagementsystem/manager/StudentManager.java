package org.example.universitymanagementsystem.manager;

import lombok.RequiredArgsConstructor;
import org.example.universitymanagementsystem.annotation.Manager;
import org.example.universitymanagementsystem.exception.student.StudentNotFoundException;
import org.example.universitymanagementsystem.repository.StudentRepository;
import org.example.universitymanagementsystem.repository.entity.StudentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@Manager
@RequiredArgsConstructor
public class StudentManager {
    private final StudentRepository studentRepository;

    public StudentEntity getStudent(Long id) {
        return studentRepository.findByIdAndIsDeleted(id, false)
                .orElseThrow(() -> new StudentNotFoundException("student not found : " + id));
    }

    public Page<StudentEntity> findAllByIsDeleted( int page,int size) {
        var pageable= PageRequest.of(page,size);
        return studentRepository.findAllByIsDeleted(false,pageable);
    }
}

