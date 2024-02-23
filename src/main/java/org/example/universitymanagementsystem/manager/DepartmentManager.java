package org.example.universitymanagementsystem.manager;

import lombok.RequiredArgsConstructor;
import org.example.universitymanagementsystem.exception.DepartmentNotFoundException;
import org.example.universitymanagementsystem.repository.DepartmentRepository;
import org.example.universitymanagementsystem.repository.entity.DepartmentEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DepartmentManager {
    private final DepartmentRepository departmentRepository;

    public DepartmentEntity getDepartment(Long id) {
        return departmentRepository.findById(id).orElseThrow(() -> new DepartmentNotFoundException("Department not found with id:" + id));
    }

    public List<DepartmentEntity> findAllByIsDeleted() {
        return departmentRepository.findAllByIsDeleted(false);
    }
    public Optional<DepartmentEntity> findByIdAndIsDeleted(Long id){
        return  departmentRepository.findByIdAndIsDeleted(id,false);
    }
}
