package org.example.universitymanagementsystem.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.universitymanagementsystem.repository.entity.LessonEntity;
import org.example.universitymanagementsystem.repository.entity.StudentEntity;

import java.time.Instant;
@Setter
@Getter
public class CreateAttendanceDTO {
    private Long id;
    private StudentEntity student;
    private LessonEntity lesson;
    private Instant createdAt;
    private Instant endedAt;
}
