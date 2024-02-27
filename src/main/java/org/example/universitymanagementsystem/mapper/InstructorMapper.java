package org.example.universitymanagementsystem.mapper;

import org.example.universitymanagementsystem.dto.instructor.CreateInstructorDTO;
import org.example.universitymanagementsystem.dto.instructor.InstructorDTO;
import org.example.universitymanagementsystem.dto.instructor.InstructorDetailsDTO;
import org.example.universitymanagementsystem.dto.instructor.UpdateInstructorDTO;
import org.example.universitymanagementsystem.repository.entity.InstructorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InstructorMapper {
    List<InstructorDTO> toInstructorDTOList(List<InstructorEntity> instructorEntities);
    InstructorDTO toInstructorDTO(InstructorEntity instructor);
    InstructorDetailsDTO toInstructorDetailsDTO(InstructorEntity instructor);
    InstructorEntity toInstructor(CreateInstructorDTO createInstructorDTO);
    void toInstructor(UpdateInstructorDTO updateInstructorDTO, @MappingTarget InstructorEntity instructor);
}
