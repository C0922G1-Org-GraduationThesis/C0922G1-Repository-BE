package com.example.be.service.Impl;

import com.example.be.model.Project;
import com.example.be.repository.IProjectRepository;
import com.example.be.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
public class ProjectService implements IProjectService {
@Autowired
private IProjectRepository projectRepository;



    /**
     * Created by: hoangNNH
     * Date created: 29/03/2023
     * Function: get project by id
     *
     * @param pageable, name
     * @return project list
     */

    @Override
    public Page<Project> getAllProject(Pageable pageable, String name) {
        return this.projectRepository.getAllProject(pageable, name);
    }
    /**
     * Created by: hoangNNH
     * Date created: 29/03/2023
     * Function: get project by id
     *
     * @param projectId
     * @return project
     */
    @Override
    public Project getProjectById(Long projectId) {
        return this.projectRepository.getProjectById(projectId);
    }

}
