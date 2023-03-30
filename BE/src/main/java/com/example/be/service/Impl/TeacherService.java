package com.example.be.service.Impl;

import com.example.be.model.Teacher;
import com.example.be.repository.ITeacherRepository;
import com.example.be.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService implements ITeacherService {
    @Autowired
    private ITeacherRepository teacherRepository;

    /**
     * Created by: Phạm Tiến
     * Date: 29/03/2023
     * Function: findTeacherByEmail(email)
     * Return: Teacher
     */
    @Override
    public Teacher findTeacherByEmail(String email) {
        return teacherRepository.findTeacherByEmail(email);
    }

    /**
     * Created by: Phạm Tiến
     * Date: 29/03/2023
     * Function: findTeacherById(id)
     * Return: Teacher
     */

    @Override
    public Teacher findTeacherById(Long id) {
        return teacherRepository.findTeacherByTeacherId(id);
    }

    /**
     * Created by: Phạm Tiến
     * Date: 29/03/2023
     * Function: updateTeacherRoleAdmin(teacher)
     */

    @Override
    public void updateTeacherRoleAdmin(Teacher teacher) {
        teacherRepository.updateTeacherRoleAdmin(teacher.getTeacherName(), teacher.getTeacherEmail(), teacher.getTeacherPhoneNumber(),
                teacher.getTeacherAddress(), teacher.getTeacherId());
    }
}
