package org.example.universitymanagementsystem.service;

import lombok.RequiredArgsConstructor;
import org.example.universitymanagementsystem.dto.DepartmentDTO;
import org.example.universitymanagementsystem.mapper.DepartmentMapper;
import org.example.universitymanagementsystem.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    public List<DepartmentDTO> findAll() {
        var departmentEntities = departmentRepository.findAll();
        return departmentMapper.toDepartmentDTOList(departmentEntities);
    }

}
