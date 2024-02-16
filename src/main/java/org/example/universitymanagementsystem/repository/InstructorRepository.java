package org.example.universitymanagementsystem.repository;

import org.example.universitymanagementsystem.repository.entity.InstructorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<InstructorEntity,Long> {
}
