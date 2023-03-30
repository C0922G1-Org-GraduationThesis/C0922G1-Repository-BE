package com.example.be.service;

import com.example.be.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentService {
    Student findStudentByEmail(String email);
}
