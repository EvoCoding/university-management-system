package org.example.universitymanagementsystem.repository;

import org.example.universitymanagementsystem.repository.entity.DepartmentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {
    Page<DepartmentEntity> findAllByIsDeleted(boolean isDeleted, Pageable pageable);

    Optional<DepartmentEntity> findByIdAndIsDeleted(Long id, boolean isDeleted);
}
