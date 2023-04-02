package com.example.be.service.Impl;

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
        return projectRepository.findById(projectId).orElse(null);
    }

    @Override
    public Project findProjectEnable(Long projectId) {
        return null;
    }

    @Override
    public List<Project> findProjectListEnable() {
        return null;
    }


}
