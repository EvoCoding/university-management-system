package org.example.universitymanagementsystem.mapper;

import org.example.universitymanagementsystem.dto.lesson.CreateLessonDTO;
import org.example.universitymanagementsystem.repository.entity.LessonEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LessonMapper {
    LessonEntity toLessonEntity(CreateLessonDTO createLessonDTO);
}
