package com.example.be.service.Impl;

import com.example.be.dto.ITeacherDto;
import com.example.be.model.Teacher;
import com.example.be.repository.ITeacherRepository;
import com.example.be.repository.ITeamRepository;
import com.example.be.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeacherService implements ITeacherService {
    @Autowired
    private ITeacherRepository teacherRepository;
    @Override
    public Optional<ITeacherDto> findTeacherById(Long id) {
        return teacherRepository.findTeacherById(id);
    }
}
