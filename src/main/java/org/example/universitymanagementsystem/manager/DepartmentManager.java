package org.example.universitymanagementsystem.manager;

import lombok.RequiredArgsConstructor;
import org.example.universitymanagementsystem.annotation.Manager;
import org.example.universitymanagementsystem.exception.DepartmentNotFoundException;
import org.example.universitymanagementsystem.repository.DepartmentRepository;
import org.example.universitymanagementsystem.repository.entity.DepartmentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@Manager
@RequiredArgsConstructor
public class DepartmentManager {
    private final DepartmentRepository departmentRepository;

    public DepartmentEntity getDepartment(Long id) {
        return departmentRepository.findByIdAndIsDeleted(id, false)
                .orElseThrow(() -> new DepartmentNotFoundException("Department not found with id:" + id));
    }

    public Page<DepartmentEntity> findAllByIsDeleted(int page, int size) {
        var pageable = PageRequest.of(page, size);
        return departmentRepository.findAllByIsDeleted(false, pageable);
    }
}
