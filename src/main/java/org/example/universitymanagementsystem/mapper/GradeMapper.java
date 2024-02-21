package org.example.universitymanagementsystem.mapper;

import org.example.universitymanagementsystem.dto.CreateGradeDTO;
import org.example.universitymanagementsystem.dto.GradeDto;
import org.example.universitymanagementsystem.repository.entity.GradeEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GradeMapper {
    List<GradeDto> toGradeDTOList(List<GradeEntity> gradeEntities);
    GradeDto toGradeDTO(GradeEntity gradeEntity);
    GradeEntity toGrade(CreateGradeDTO createGradeDTO);
}
