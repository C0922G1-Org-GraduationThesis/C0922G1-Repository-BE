package com.example.be.service.Impl;

import com.example.be.dto.ProgressDto;
import com.example.be.dto.ProgressStudentDto;
import com.example.be.model.Project;
import com.example.be.model.Student;
import com.example.be.model.Team;
import com.example.be.service.IProgressService;
import com.example.be.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Service
public class ProgressService implements IProgressService {
    @Autowired
    private IProjectService projectService;


    /**
     * Created by: VuLX
     * Date created: 29/3/2023
     * Function: create  list-progress
     */

    @Override
    public Page<ProgressDto> findAll() {
        List<Project> projectList = projectService.findProjectListEnable();
        List<ProgressDto> progressDtos = new ArrayList<>();
        Pageable pageable = Pageable.ofSize(3);
        for (Project project : projectList) {
            progressDtos.add(new ProgressDto(project.getProjectId(), project.getTeam().getTeamName(), project.getProjectName(), project.getTeam().getMemberOfTeam()));
        }
        Page<ProgressDto>progressDtoPage = new PageImpl<>(progressDtos,pageable, 0);
        return progressDtoPage;
    }

    /**
     * Created by: VuLX
     * Date created: 29/3/2023
     * <p>
     * Function: find list progress-student by projectId
     */

    @Override
    public List<ProgressStudentDto> findAllStudentOfTeam(Long projectId) {
        List<ProgressStudentDto> progressStudentDtos = new ArrayList<>();
        Project project = projectService.findProjectEnable(projectId);
        if (project == null){
            return null;
        }
        Team team = project.getTeam();
        Set<Student> studentSet = team.getStudentSet();
        for (Student student : studentSet) {
            progressStudentDtos.add(new ProgressStudentDto(student.getStudentName(), student.getStudentEmail(), student.getStudentPhoneNumber(), student.getStudentImg()));
        }
        return progressStudentDtos;
    }

}
