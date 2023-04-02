package com.example.be.service;

import com.example.be.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();


    void addStudent(String studentName,
                    String studentCode,
                    String studentDateOfBirth,
                    String studentEmail,
                    String studentPhoneNumber,
                    boolean studentGender,
                    String studentAddress,
                    String studentImg,
                    Long clazzId);

    Student findById(long studentId);

    void updateStudent(long studentId,Student student);
    Long maxIdStudent();
    
}
