package com.example.be.repository;

import com.example.be.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITeacherRepository extends JpaRepository<Teacher, Long> {
}
