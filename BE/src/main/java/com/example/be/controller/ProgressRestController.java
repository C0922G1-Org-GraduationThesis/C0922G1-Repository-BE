package com.example.be.controller;

import com.example.be.dto.ProgressDto;
import com.example.be.dto.ProgressProjectDto;
import com.example.be.dto.ProgressStudentDto;
import com.example.be.service.IProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class ProgressRestController {

    @Autowired
    private IProgressService progressService;

    /**
     * Created by: VuLX
     * Date created: 29/3/2023
     * Function: create list-progress
     * @return HttpStatus.NO_CONTENT if result is null or HttpStatus.OK if result is not null
     */

    @GetMapping("/api/progress/list")
    public ResponseEntity<List<ProgressDto>> findAll() {
        List<ProgressDto> progressDtos = progressService.findAll();
        if (progressDtos == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(progressDtos, HttpStatus.OK);
    }

    /**
     * Created by: VuLX
     * Date created: 29/3/2023
     * Function: find list progress-student by projectId
     * @return HttpStatus.NO_CONTENT if result is null or HttpStatus.OK if result is not null
     */

    @GetMapping("/api/progress/progressStudent/{projectId}")
    public ResponseEntity<List<ProgressStudentDto>> findAllStudentOfTeam(@PathVariable Long projectId) {
        List<ProgressStudentDto> progressStudentDtos = progressService.findAllStudentOfTeam(projectId);
        if (progressStudentDtos == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(progressStudentDtos, HttpStatus.OK);
    }

    /**
     * Created by: VuLX
     * Date created: 31/3/2023
     * Function: find  progress-detail by projectId
     * @return HttpStatus.NO_CONTENT if result is null or HttpStatus.OK if result is not null
     */

    @GetMapping("/api/progress/{projectId}")
    public ResponseEntity<ProgressProjectDto> findProgressById(@PathVariable Long projectId) {
        ProgressProjectDto progressDto = progressService.findByProjectId(projectId);
        if (progressDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(progressDto, HttpStatus.OK);
    }


}
