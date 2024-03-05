package org.example.universitymanagementsystem.service;

import lombok.RequiredArgsConstructor;
import org.example.universitymanagementsystem.dto.CreateStudentDTO;
import org.example.universitymanagementsystem.dto.FindStudentsDTO;
import org.example.universitymanagementsystem.dto.StudentDTO;
import org.example.universitymanagementsystem.dto.UpdateStudentDTO;
import org.example.universitymanagementsystem.manager.StudentManager;
import org.example.universitymanagementsystem.mapper.StudentMapper;
import org.example.universitymanagementsystem.repository.StudentRepository;
import org.example.universitymanagementsystem.shared.PageResponse;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final StudentManager studentManager;

    public PageResponse<StudentDTO> findAll(FindStudentsDTO findStudentsDTO) {
        var studentEntities = studentManager.findAll(findStudentsDTO);
        var content = studentMapper.toStudentDTOList(studentEntities.getContent());
        return new PageResponse<>(content, studentEntities.getTotalPages(), studentEntities.getTotalElements());
    }

    public StudentDTO findById(Long id) {
        return studentMapper.toStudentDTO(studentManager.getStudent(id));
    }

    public void create(CreateStudentDTO createStudentDTO) {
        studentRepository.save(studentMapper.toStudentEntity(createStudentDTO));
    }

    public void update(Long id, UpdateStudentDTO updateStudentDTO) {
        var student = studentManager.getStudent(id);
        studentMapper.toStudentEntity(updateStudentDTO, student);
        studentRepository.save(student);
    }

    public void delete(Long id) {
        var student = studentManager.getStudent(id);
        student.setDeleted(true);
        studentRepository.save(student);
    }
}
