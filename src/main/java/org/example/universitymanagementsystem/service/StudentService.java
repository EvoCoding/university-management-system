package org.example.universitymanagementsystem.service;

import lombok.RequiredArgsConstructor;
import org.example.universitymanagementsystem.dto.student.CreateStudentDTO;
import org.example.universitymanagementsystem.dto.student.StudentDTO;
import org.example.universitymanagementsystem.dto.student.UpdateStudentDTO;
import org.example.universitymanagementsystem.exception.StudentNotFoundException;
import org.example.universitymanagementsystem.manager.StudentManager;
import org.example.universitymanagementsystem.mapper.StudentMapper;
import org.example.universitymanagementsystem.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final StudentManager studentManager;


    public List<StudentDTO> findAll() {
        var studentEntities = studentManager.findAll();
        return studentMapper.toStudentDTOList(studentEntities);
    }

    public StudentDTO findById(Long id) {
        var student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("student not found : " + id));
        return studentMapper.toStudentDTO(student);
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
