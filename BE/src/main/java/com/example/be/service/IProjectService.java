package com.example.be.service;

import com.example.be.model.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IProjectService {
    List<Project> findAll();
    Project findById(Long projectId);
    Project findProjectEnable( Long projectId);
    List<Project> findProjectListEnable();
    /**
     * Created by: hoangNNH
     * Date created: 29/03/2023
     * Function: get project list
     *
     * @param pageable, name
     */
    Page<Project> getAllProject(Pageable pageable, String name);
    /**
     * Created by: hoangNNH
     * Date created: 29/03/2023
     * Function: get project by id
     *
     * @param projectId
     */
    Project getProjectById(Long projectId);
}
