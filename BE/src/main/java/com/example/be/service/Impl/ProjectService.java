package com.example.be.service.Impl;

import com.example.be.model.Project;
import com.example.be.model.Team;
import com.example.be.repository.IProjectRepository;
import com.example.be.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProjectService implements IProjectService {
    @Autowired
    private IProjectRepository projectRepository;


    /**
     * Created by: NuongHT
     * Date create: 29/03/2023
     */
    @Override
    @Transactional
    public void updatePro(Long projectId) {
        projectRepository.updatePro(projectId);
    }

    /**
     * Created by: NuongHT
     * Date create: 29/03/2023
     */
    @Override
    @Transactional
    public void updatePro2(Long projectId) {
        projectRepository.updatePro2(projectId);
    }

    /**
     * Created by: NuongHT
     * Date create: 29/03/2023
     */
    @Override
    public Project findProById(Long projectId) {
        return projectRepository.findProById(projectId);
    }

    @Override
    public Page<Project> findPagePro(Pageable pageable) {
        return projectRepository.findPagePro(pageable);
    }
}
