package com.example.be.service;

import com.example.be.model.Project;
import com.example.be.model.Team;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProjectService {

    Page<Project> findPagePro(Pageable pageable);

    void updatePro(Long projectId);

    void updatePro2(Long projectId);

    Project findProById(Long projectId);
}
