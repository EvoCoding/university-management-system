package org.example.universitymanagementsystem.validator;

import org.example.universitymanagementsystem.exception.StudentValidationException;
import org.example.universitymanagementsystem.repository.entity.CourseEntity;
import org.example.universitymanagementsystem.repository.entity.StudentEntity;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class StudentValidator {

    public void validate(StudentEntity studentEntity, CourseEntity courseEntity) {
        validateCourseExistence(studentEntity, courseEntity);
        validateCredit(studentEntity, courseEntity.getCredit());
    }

    private void validateCourseExistence(StudentEntity studentEntity, CourseEntity courseEntity) {
        var response = studentEntity.getCourses().stream()
                .anyMatch(courseEntity1 -> Objects.equals(courseEntity1.getId(), courseEntity.getId()));

        if (response) {
            throw new StudentValidationException("Course already is enrolled");
        }
    }

    private void validateCredit(StudentEntity studentEntity, int newCredit) {
        var currentCreditSum = studentEntity.getCourses()
                .stream()
                .map(CourseEntity::getCredit)
                .reduce(0, Integer::sum);

        var totalCreditSum = currentCreditSum + newCredit;

        if (totalCreditSum > 30) {
            throw new StudentValidationException("Credit is allowed maximum 30");
        }
    }
}
