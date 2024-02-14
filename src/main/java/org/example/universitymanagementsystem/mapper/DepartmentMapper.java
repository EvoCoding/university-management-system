package org.example.universitymanagementsystem.mapper;

import org.example.universitymanagementsystem.dto.DepartmentDTO;
import org.example.universitymanagementsystem.repository.entity.DepartmentEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    List<DepartmentDTO> toDepartmentDTOList(List<DepartmentEntity> departmentEntities);
}
