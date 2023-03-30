package com.example.be.repository;

import com.example.be.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFacultyRepository extends JpaRepository<Faculty, Long> {
}
