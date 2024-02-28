package org.example.universitymanagementsystem.repository;

import org.example.universitymanagementsystem.repository.entity.InstructorEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InstructorRepository extends JpaRepository<InstructorEntity, Long> {
    Page<InstructorEntity> findAllByIsDeleted(boolean isDeleted, Pageable pageable);

    Optional<InstructorEntity> findByIdAndIsDeleted(Long id, boolean isDeleted);
}
