package com.example.be.service;

import com.example.be.dto.teacher.IEmailAndPhoneNumberDTO;
import com.example.be.dto.teacher.ITeacherDTO;
import com.example.be.dto.teacher.TeacherDTO;
import com.example.be.model.Teacher;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ITeacherService {
    ITeacherDTO getTeacher(Long idTeacher);

    ITeacherDTO maxIdTeacher();

    void addTeacher(Teacher teacher);
    void updateTeacher(Teacher teacher);

    List<IEmailAndPhoneNumberDTO> getAllPhoneNumberAndEmail();

}
