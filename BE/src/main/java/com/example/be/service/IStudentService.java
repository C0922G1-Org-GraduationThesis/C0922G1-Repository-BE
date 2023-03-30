package com.example.be.service;

import com.example.be.dto.IMailStudentDto;
import com.example.be.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();

    /**
     * Created by: NuongHT
     * Date create: 29/03/2023
     */
    List<IMailStudentDto> getInfomation(Long teamId);
}
