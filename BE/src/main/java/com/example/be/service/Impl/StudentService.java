package com.example.be.service.Impl;

import com.example.be.model.Student;
import com.example.be.repository.IStudentRepository;
import com.example.be.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository studentRepository;
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void addStudent(String studentName, String studentCode,
                           String studentDateOfBirth, String studentEmail,
                           String studentPhoneNumber, boolean studentGender,
                           String studentAddress, String studentImg, Long clazzId) {
        studentRepository.addStudent(studentName,studentCode,studentDateOfBirth,studentEmail,studentPhoneNumber,studentGender,studentAddress,studentImg,clazzId);
    }
}
