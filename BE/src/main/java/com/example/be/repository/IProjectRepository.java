package com.example.be.repository;

import com.example.be.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

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

    @Modifying
    @Query(value = "" +
            "INSERT INTO project " +
            "(project_name, project_content, project_description, project_status, project_img, team_id)" +
            " VALUES (:projectName,:projectContent ,:projectDescription ,0 ,:projectImg,:teamId );",
            nativeQuery = true)
    Project saveProject(@Param("projectName") String projectName,
                        @Param("projectContent") String projectContent,
                        @Param("projectDescription") String projectDescription,
                        @Param("projectImg") String projectImg,
                        @Param("teamId") Long teamId);

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
            "project_name," +
            "project_content," +
            "project_img," +
            "project_description," +
            "project_status," +
            "team_id " +
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
            "project_name," +
            "project_content," +
            "project_img," +
            "project_description," +
            "project_status," +
            "team_id " +
            "FROM project " +
            "WHERE project_name = LOWER(TRIM(REGEXP_REPLACE(:projectName, '\\s+', ' ')))", nativeQuery = true)
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
            "project_name," +
            "project_content," +
            "project_img," +
            "project_description," +
            "project_status," +
            "team_id " +
            "FROM project " +
            "WHERE project_name LIKE CONCAT('%',:searchName,'%')", nativeQuery = true)
    Page<Project> findAllByNameContaining(@Param("searchName") String searchName, Pageable pageable);

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

