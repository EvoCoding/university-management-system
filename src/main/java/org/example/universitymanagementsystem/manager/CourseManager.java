package org.example.universitymanagementsystem.manager;

import lombok.RequiredArgsConstructor;
import org.example.universitymanagementsystem.annotation.Manager;
import org.example.universitymanagementsystem.exception.course.CourseNotFoundException;
import org.example.universitymanagementsystem.repository.CourseRepository;
import org.example.universitymanagementsystem.repository.entity.CourseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;

@Manager
@RequiredArgsConstructor
public class CourseManager {
    private final CourseRepository courseRepository;

    public CourseEntity getCourse(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException("Course Not Found: " + id));
    }

    public Page<CourseEntity> findAllByIsDeleted(int page, int size) {
        var pageable = PageRequest.of(page, size);
        return courseRepository.findAllByIsDeleted(false, pageable);
    }

    public Optional<CourseEntity> findByIdAndIsDeleted(Long id) {
        return courseRepository.findByIdAndIsDeleted(id, false);
    }

}
