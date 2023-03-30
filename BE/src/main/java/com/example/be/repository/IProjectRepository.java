package com.example.be.repository;

import com.example.be.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface IProjectRepository extends JpaRepository<Project, Long> {
    @Query(value = "select * from project where project.project_status = 1 and project_id = :id", nativeQuery = true)
    Project findProjectEnable(@Param("id") Long projectId);
    @Query(value = "select * from project where project.project_status = 1", nativeQuery = true)
    List<Project> findProjectListEnable();
}
