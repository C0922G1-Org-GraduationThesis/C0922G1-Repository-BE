package com.example.be.repository;

import com.example.be.model.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface IProjectRepository extends JpaRepository<Project, Long> {
    /**
     * Created by: hoangNNH
     * Date created: 29/03/2023
     * Function: get project list
     *
     * @param pageable, name
     */
    @Query(value = "select * from `project` " +
            "where `project_name` like concat('%', :name, '%')" +
            "and `project_status` = true ", nativeQuery = true)
    Page<Project> getAllProject(Pageable pageable, @Param("name") String name);
    /**
     * Created by: hoangNNH
     * Date created: 29/03/2023
     * Function: get project by id
     *
     * @param projectId
     */
    @Query(value = "select * from project where project_id = :projectId", nativeQuery = true)
    Project getProjectById(@Param("projectId") Long projectId);
}
