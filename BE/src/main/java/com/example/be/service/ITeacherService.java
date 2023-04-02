package com.example.be.service;

import com.example.be.dto.ITeacherDto;
import com.example.be.model.Teacher;

import java.util.Optional;

public interface ITeacherService {
    Optional<ITeacherDto> findTeacherById(Long id);

}
