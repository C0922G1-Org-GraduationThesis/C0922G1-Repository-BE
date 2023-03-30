package com.example.be.repository;

import com.example.be.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


import com.example.be.model.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface IProjectRepository extends JpaRepository<Project, Long> {
    /**
     * Create by: HauNN
     * Date create: 29/03/2023
     * Function: save project
     *
     * @Param: name, content, description, img
     */
    @Transactional
    @Query(value = "" +
            "INSERT INTO project " +
            "(name, content, description, project_status, img)" +
            " VALUES (:name,:content ,:description ,0 ,:img );",
            nativeQuery = true)
    Project saveProject(@Param("name") String name,
                        @Param("content") String content,
                        @Param("description") String description,
                        @Param("img") String img);

    /**
     * Create by: HauNN
     * Date create: 29/03/2023
     * Function: find by id project
     *
     * @Param: id
     */
    @Query(value = "" +
            "SELECT " +
            "project_id," +
            "name," +
            "content," +
            "img," +
            "description," +
            "project_status " +
            "FROM project " +
            "WHERE project_id = :projectId", nativeQuery = true)
    Optional<Project> findById(@Param("projectId") Long id);

    /**
     * Create by: HauNN
     * Date create: 29/03/2023
     * Function: find by name project
     *
     * @Param: name
     */
    @Query(value = "" +
            "SELECT " +
            "project_id," +
            "name," +
            "content," +
            "img," +
            "description," +
            "project_status " +
            "FROM project " +
            "WHERE name = LOWER(TRIM(REGEXP_REPLACE(:projectName, '\\s+', ' ')))", nativeQuery = true)
    Optional<Project> findByName(@Param("projectName") String name);

    /**
     * Create by: HauNN
     * Date create: 29/03/2023
     * Function: find by name containing project
     *
     * @Param: project, pageable
     */
    @Query(value = "" +
            "SELECT " +
            "project_id," +
            "name," +
            "content," +
            "img," +
            "description," +
            "project_status " +
            "FROM project " +
            "WHERE name LIKE CONCAT('%',:searchName,'%')", nativeQuery = true)
    Page<Project> findAllByNameContaining(@Param("searchName") String searchName, Pageable pageable);
}

