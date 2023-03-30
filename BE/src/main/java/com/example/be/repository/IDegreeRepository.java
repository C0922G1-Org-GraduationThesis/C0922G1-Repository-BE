package com.example.be.repository;

import com.example.be.model.Degree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDegreeRepository extends JpaRepository<Degree, Long> {
}
