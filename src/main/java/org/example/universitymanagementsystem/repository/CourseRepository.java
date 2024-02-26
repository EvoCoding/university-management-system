package org.example.universitymanagementsystem.repository;

import org.example.universitymanagementsystem.repository.entity.CourseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Long> {

    Page<CourseEntity> findAllByIsDeleted(boolean isDeleted, Pageable pageable);

    Optional<CourseEntity> findByIdAndIsDeleted(Long id, boolean isDeleted);
}
