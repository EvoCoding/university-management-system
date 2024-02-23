package org.example.universitymanagementsystem.service;

import lombok.RequiredArgsConstructor;
import org.example.universitymanagementsystem.dto.CreateLessonAttendanceDTO;
import org.example.universitymanagementsystem.dto.CreateLessonDTO;
import org.example.universitymanagementsystem.manager.CourseManager;
import org.example.universitymanagementsystem.manager.LessonManager;
import org.example.universitymanagementsystem.manager.StudentManager;
import org.example.universitymanagementsystem.mapper.LessonMapper;
import org.example.universitymanagementsystem.repository.AttendanceRepository;
import org.example.universitymanagementsystem.repository.LessonRepository;
import org.example.universitymanagementsystem.repository.entity.AttendanceEntity;
import org.example.universitymanagementsystem.validator.AttendanceValidator;
import org.example.universitymanagementsystem.validator.LessonValidator;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LessonService {
    private final LessonMapper lessonMapper;
    private final CourseManager courseManager;
    private final LessonRepository lessonRepository;
    private final LessonValidator lessonValidator;
    private final LessonManager lessonManager;
    private final StudentManager studentManager;
    private final AttendanceRepository attendanceRepository;
    private final AttendanceValidator attendanceValidator;

    public void create(CreateLessonDTO createLessonDTO) {
        var lesson = lessonMapper.toLessonEntity(createLessonDTO);
        var course = courseManager.getCourse(createLessonDTO.getCourseId());
        lesson.setCourse(course);

        lessonValidator.validateLesson(lesson);
        lessonRepository.save(lesson);
    }

    public void createAttendance(Long lessonId, Long studentId, CreateLessonAttendanceDTO createLessonAttendanceDTO) {
        var lesson = lessonManager.getLesson(lessonId);
        var student = studentManager.getStudent(studentId);
        var attendance = new AttendanceEntity();
        attendance.setAttendanceTypeEnum(createLessonAttendanceDTO.getAttendanceTypeEnum());
        attendance.setLesson(lesson);
        attendance.setStudent(student);

        attendanceValidator.validateAttendanceNotExist(attendance);
        attendanceRepository.save(attendance);
    }
}
