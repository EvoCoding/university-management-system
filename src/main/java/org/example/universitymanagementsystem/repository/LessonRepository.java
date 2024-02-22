package org.example.universitymanagementsystem.repository;

import jakarta.persistence.Id;
import org.example.universitymanagementsystem.repository.entity.LessonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<LessonEntity, Id> {
}
