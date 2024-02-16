package org.example.universitymanagementsystem.service;

import lombok.RequiredArgsConstructor;
import org.example.universitymanagementsystem.dto.CreateEnrollmentDTO;
import org.example.universitymanagementsystem.manager.CourseManager;
import org.example.universitymanagementsystem.manager.StudentManager;
import org.example.universitymanagementsystem.repository.CourseRepository;
import org.example.universitymanagementsystem.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnrollmentService {
    private final StudentManager studentManager;
    private final CourseManager courseManager;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public void create(CreateEnrollmentDTO createEnrollmentDTO) {
        var course = courseManager.getCourse(createEnrollmentDTO.getCourseId());
        var student = studentManager.getStudent(createEnrollmentDTO.getStudentId());

        course.getStudents().add(student);
        student.getCourses().add(course);

        studentRepository.save(student);
        courseRepository.save(course);
    }
}
