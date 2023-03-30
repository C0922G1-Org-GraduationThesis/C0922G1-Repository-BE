package com.example.be.service;

import com.example.be.model.Teacher;

public interface ITeacherService {
    Teacher findTeacherByEmail(String email);
    Teacher findTeacherById(Long id);
    void  updateTeacherRoleAdmin(Teacher teacher);
}
