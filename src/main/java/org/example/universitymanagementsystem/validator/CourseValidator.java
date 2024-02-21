package org.example.universitymanagementsystem.validator;

import org.example.universitymanagementsystem.exception.CourseValidationException;
import org.example.universitymanagementsystem.repository.entity.CourseEntity;
import org.springframework.stereotype.Component;

@Component
public class CourseValidator {

    public void validate(CourseEntity courseEntity) {
        validateCapacity(courseEntity);
    }

    private void validateCapacity(CourseEntity courseEntity) {
        if (courseEntity.getStudents().size() == courseEntity.getCapacity()) {
            throw new CourseValidationException("Course capacity exceeded");
        }
    }
}
