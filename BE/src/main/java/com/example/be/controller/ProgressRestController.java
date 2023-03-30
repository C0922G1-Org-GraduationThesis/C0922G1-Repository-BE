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


}
