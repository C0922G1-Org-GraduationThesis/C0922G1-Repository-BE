package com.example.be.service;

import com.example.be.model.Project;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProjectService {
    List<Project> findAll();
    Project findById(Long projectId);
    Project findProjectEnable( Long projectId);
    List<Project> findProjectListEnable();
}
