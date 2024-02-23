package org.example.universitymanagementsystem.repository;

import org.example.universitymanagementsystem.repository.entity.AttendanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepository extends JpaRepository<AttendanceEntity,Long> {
}
