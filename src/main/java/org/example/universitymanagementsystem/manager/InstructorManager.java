package org.example.universitymanagementsystem.manager;

import lombok.RequiredArgsConstructor;
import org.example.universitymanagementsystem.annotation.Manager;
import org.example.universitymanagementsystem.dto.FindInstructorsDTO;
import org.example.universitymanagementsystem.exception.InstructorNotFoundException;
import org.example.universitymanagementsystem.mapper.InstructorMapper;
import org.example.universitymanagementsystem.repository.InstructorRepository;
import org.example.universitymanagementsystem.repository.entity.InstructorEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@Manager
@RequiredArgsConstructor
public class InstructorManager {
    private final InstructorRepository instructorRepository;
    private final InstructorMapper instructorMapper;

    public InstructorEntity getInstructor(Long id) {
        return instructorRepository.findByIdAndIsDeleted(id, false)
                .orElseThrow(() -> new InstructorNotFoundException("Instructor not found with id:" + id));
    }

    public Page<InstructorEntity> findAll(FindInstructorsDTO findInstructorsDTO) {
        var pageable = PageRequest.of(findInstructorsDTO.getPage(), findInstructorsDTO.getSize());
        var findInstructorsVo = instructorMapper.toFindInstructorsVo(findInstructorsDTO);
        return instructorRepository.findAll(findInstructorsVo, pageable);
    }

}
