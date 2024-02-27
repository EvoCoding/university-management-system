package org.example.universitymanagementsystem.manager;

import lombok.RequiredArgsConstructor;
import org.example.universitymanagementsystem.annotation.Manager;
import org.example.universitymanagementsystem.dto.FindStudentsDTO;
import org.example.universitymanagementsystem.exception.StudentNotFoundException;
import org.example.universitymanagementsystem.mapper.StudentMapper;
import org.example.universitymanagementsystem.repository.StudentRepository;
import org.example.universitymanagementsystem.repository.entity.StudentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@Manager
@RequiredArgsConstructor
public class StudentManager {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentEntity getStudent(Long id) {
        return studentRepository.findByIdAndIsDeleted(id, false)
                .orElseThrow(() -> new StudentNotFoundException("student not found : " + id));
    }

    public Page<StudentEntity> findAll(FindStudentsDTO findStudentsDTO) {
        var pageable = PageRequest.of(findStudentsDTO.getPage(), findStudentsDTO.getSize());
        var findStudentsVo = studentMapper.toFindStudentsVo(findStudentsDTO);
        return studentRepository.findAll(findStudentsVo, pageable);
    }
}

