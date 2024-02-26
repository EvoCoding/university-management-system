package org.example.universitymanagementsystem.mapper;

import org.example.universitymanagementsystem.dto.grade.CreateGradeDTO;
import org.example.universitymanagementsystem.dto.grade.GradeDTO;
import org.example.universitymanagementsystem.repository.entity.GradeEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GradeMapper {
    List<GradeDTO> toGradeDTOList(List<GradeEntity> gradeEntities);
    GradeDTO toGradeDTO(GradeEntity gradeEntity);
    GradeEntity toGrade(CreateGradeDTO createGradeDTO);
}
