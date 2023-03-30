package com.example.be.controller;

import com.example.be.dto.ProgressDto;
import com.example.be.dto.ProgressStudentDto;
import com.example.be.model.Project;
import com.example.be.service.IProgressService;
import com.example.be.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/progress")
public class ProgressRestController {
    @Autowired
    private IProjectService projectService;
    @Autowired
    private IProgressService progressService;
    /**
     * Created by: VuLX
     * Date created: 29/3/2023

     * Function: create  list-progress
     * @return HttpStatus.NO_CONTENT if result is null or HttpStatus.OK if result is not null
     */

    @GetMapping("/api/progress/list")
    public ResponseEntity<Page<ProgressDto>> findAll(){
        Page<ProgressDto> progressDtos = progressService.findAll();
        if (progressDtos == null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(progressDtos,HttpStatus.OK);
    }

    /**
     * Created by: VuLX
     * Date created: 29/3/2023

     * Function: find list progress-student by projectId
     * @return HttpStatus.NO_CONTENT if result is null or HttpStatus.OK if result is not null
     */

    @GetMapping("/api/progress/progressStudent/{projectId}")
    public ResponseEntity<List<ProgressStudentDto>> findAllStudentOfTeam(@PathVariable Long projectId){
        List<ProgressStudentDto> progressStudentDtos = progressService.findAllStudentOfTeam(projectId);
        if (progressStudentDtos == null){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(progressStudentDtos,HttpStatus.OK);
    }
    @GetMapping("/api/progress/project/{projectId}")
    public ResponseEntity<Project> findProjectById(@PathVariable Long projectId){
       Project project = projectService.findById(projectId);
       if (project == null){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);

       }
        return new ResponseEntity<>(project,HttpStatus.OK);
    }
}
