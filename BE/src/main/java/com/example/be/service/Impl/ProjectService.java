package com.example.be.service.Impl;


import com.example.be.dto.ProgressProjectDto;
import com.example.be.model.Project;
import com.example.be.repository.IProjectRepository;
import com.example.be.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService implements IProjectService {
    @Autowired
    private IProjectRepository projectRepository;
    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project findById(Long projectId) {
        return projectRepository.findByAId(projectId).orElse(null);
    }

    @Override
    public Project findProjectById(Long projectId) {
        return projectRepository.findByAId(projectId).orElse(null);
    }

    @Override
    public List<Project> findProjectListEnable() {
        return projectRepository.findProjectListEnable();
    }

    @Override
    public ProgressProjectDto findByProjectId(Long projectId) {
        return projectRepository.findProgressDtoByProjectId(projectId).orElse(null);
    }


}
