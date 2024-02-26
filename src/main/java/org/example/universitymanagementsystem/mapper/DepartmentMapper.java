package org.example.universitymanagementsystem.mapper;

import org.example.universitymanagementsystem.dto.department.CreateDepartmentDTO;
import org.example.universitymanagementsystem.dto.department.DepartmentDTO;
import org.example.universitymanagementsystem.dto.department.DepartmentDetailsDTO;
import org.example.universitymanagementsystem.dto.department.UpdateDepartmentDto;
import org.example.universitymanagementsystem.repository.entity.DepartmentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    List<DepartmentDTO> toDepartmentDTOList(List<DepartmentEntity> departmentEntities);
    DepartmentDTO toDepartmentDto(DepartmentEntity department);
    DepartmentDetailsDTO toDepartmentDetailsDTO(DepartmentEntity department);
    DepartmentEntity toDepartment(CreateDepartmentDTO createDepartmentDTO);
    void toDepartment(UpdateDepartmentDto updateDepartmentDto, @MappingTarget DepartmentEntity departmentEntity);
}
