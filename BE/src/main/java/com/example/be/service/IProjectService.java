package com.example.be.service;

import com.example.be.dto.ProgressProjectDto;
import com.example.be.model.Project;

import java.util.List;

public interface IProjectService {
    /**
     * Created by: VuLX
     * Date created: 01/04/2023
     */

    List<Project> findAll();

    /**
     * Created by: VuLX
     * Date created: 01/04/2023
     */
    Project findByIdProject(Long projectId);

    /**
     * Created by: VuLX
     * Date created: 01/04/2023
     */
    Project findProjectById(Long projectId);

    /**
     * Created by: VuLX
     * Date created: 01/04/2023
     */
    List<Project> findProjectListEnableAndSetStatusIsTrue();

    /**
     * Created by: VuLX
     * Date created: 01/04/2023
     */
    ProgressProjectDto findByProjectId(Long projectId);

    void save(Project project);
}
