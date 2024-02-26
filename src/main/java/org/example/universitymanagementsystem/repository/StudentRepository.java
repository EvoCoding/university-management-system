package org.example.universitymanagementsystem.repository;

import org.example.universitymanagementsystem.repository.entity.StudentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    Page<StudentEntity> findAllByIsDeleted(boolean isDeleted, Pageable pageable);

    Optional<StudentEntity> findByIdAndIsDeleted(Long id, boolean isDeleted);
}

