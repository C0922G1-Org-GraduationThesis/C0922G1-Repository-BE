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

    @Override
    public Page<ProgressDto> findAll() {
        return null;
    }

    @Override
    public List<ProgressStudentDto> findAllStudentOfTeam(Long projectId) {
        return null;
    }
}
