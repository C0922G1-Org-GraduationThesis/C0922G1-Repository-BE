package com.example.be.repository;

import com.example.be.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProjectRepository extends JpaRepository<Project, Long> {
}
