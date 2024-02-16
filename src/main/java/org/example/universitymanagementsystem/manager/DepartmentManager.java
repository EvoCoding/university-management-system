package org.example.universitymanagementsystem.manager;

import lombok.RequiredArgsConstructor;
import org.example.universitymanagementsystem.exception.DepartmentNotFoundException;
import org.example.universitymanagementsystem.repository.DepartmentRepository;
import org.example.universitymanagementsystem.repository.entity.DepartmentEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DepartmentManager {
    private final DepartmentRepository departmentRepository;

    public DepartmentEntity getDepartment(Long id) {
        return departmentRepository.findById(id).orElseThrow(() -> new DepartmentNotFoundException("Department not found with id:" + id));
    }
}