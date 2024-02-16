package org.example.universitymanagementsystem.service;

import lombok.RequiredArgsConstructor;
import org.example.universitymanagementsystem.dto.CourseDTO;
import org.example.universitymanagementsystem.dto.CreateCourseDTO;
import org.example.universitymanagementsystem.dto.UpdateCourseDTO;
import org.example.universitymanagementsystem.exception.CourseNotFoundException;
import org.example.universitymanagementsystem.mapper.CourseMapper;
import org.example.universitymanagementsystem.repository.CourseRepository;
import org.example.universitymanagementsystem.repository.entity.CourseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseMapper courseMapper;
    private final CourseRepository courseRepository;

    public List<CourseDTO> findAll() {
        var courseEntities = courseRepository.findAll();
        return courseMapper.toCourseDTOList(courseEntities);
    }

    public CourseDTO findById(@PathVariable Long id) {
        var course = getCourse(id);
        return courseMapper.toCourseDTO(course);
    }

    public void create(CreateCourseDTO createCourseDTO) {
        courseRepository.save(courseMapper.toCourseEntity(createCourseDTO));
    }

    public void update(Long id, UpdateCourseDTO updateCourseDTO) {
        var course = getCourse(id);
        courseMapper.toCourseEntity(updateCourseDTO, course);
        courseRepository.save(course);
    }

    public void delete(Long id) {
        var course = getCourse(id);
        course.setDeleted(true);
        courseRepository.save(course);
    }

    private CourseEntity getCourse(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException("Course Not Found: " + id));
    }

}
