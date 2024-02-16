package org.example.universitymanagementsystem.service;

import lombok.RequiredArgsConstructor;
import org.example.universitymanagementsystem.dto.CreateInstructorDTO;
import org.example.universitymanagementsystem.dto.InstructorDTO;
import org.example.universitymanagementsystem.dto.InstructorDetailsDTO;
import org.example.universitymanagementsystem.dto.UpdateInstructorDTO;
import org.example.universitymanagementsystem.exception.InstructorNotFoundException;
import org.example.universitymanagementsystem.mapper.InstructorMapper;
import org.example.universitymanagementsystem.repository.InstructorRepository;
import org.example.universitymanagementsystem.repository.entity.InstructorEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructorService {
    private final InstructorRepository instructorRepository;
    private final InstructorMapper instructorMapper;

    public List<InstructorDTO> findAll() {
        var instructorEntities = instructorRepository.findAll();
        return instructorMapper.toInstructorDTOList(instructorEntities);
    }

    public InstructorDetailsDTO findById(Long id) {
        return instructorMapper.toInstructorDetailsDTO(getInstructor(id));
    }

    public void create(CreateInstructorDTO createInstructorDTO) {
        var instructor = instructorMapper.toInstructor(createInstructorDTO);
        instructorRepository.save(instructor);
    }

    public void update(Long id, UpdateInstructorDTO updateInstructorDTO) {
        var instructor = getInstructor(id);
        instructorMapper.toInstructor(updateInstructorDTO, instructor);
        instructorRepository.save(instructor);
    }

    public void delete(Long id) {
        var instructor = getInstructor(id);
        instructor.setDeleted(true);
        instructorRepository.save(instructor);
    }

    private InstructorEntity getInstructor(Long id) {
        return instructorRepository.findById(id)
                .orElseThrow(() -> new InstructorNotFoundException("Instructor not found with id:" + id));
    }

}
