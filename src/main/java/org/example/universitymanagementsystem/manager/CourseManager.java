package org.example.universitymanagementsystem.manager;

import lombok.RequiredArgsConstructor;
import org.example.universitymanagementsystem.exception.CourseNotFoundException;
import org.example.universitymanagementsystem.repository.CourseRepository;
import org.example.universitymanagementsystem.repository.entity.CourseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CourseManager {
    private final CourseRepository courseRepository;

    public CourseEntity getCourse(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException("Course Not Found: " + id));
    }
}
