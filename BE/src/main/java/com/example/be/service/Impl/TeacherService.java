package com.example.be.service.Impl;

import com.example.be.dto.teacher.IEmailAndPhoneNumberDTO;
import com.example.be.dto.teacher.ITeacherDTO;
import com.example.be.dto.teacher.TeacherDTO;

import com.example.be.model.Teacher;
import com.example.be.repository.ITeacherRepository;
import com.example.be.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService implements ITeacherService {
    @Autowired
    private ITeacherRepository iTeacherRepository;

    @Override
    public Optional<Teacher> findByID(Long id) {
        return iTeacherRepository.findById(id);
    }

    @Override
    public ITeacherDTO getTeacher(Long idTeacher) {
        return iTeacherRepository.getTeacher(idTeacher);
    }

    @Override
    public ITeacherDTO maxIdTeacher() {
        return iTeacherRepository.maxIdTeacher();
    }

    @Override
    public List<Teacher> findAll() {
        return iTeacherRepository.findAll();
    }

    @Override
    public void addTeacher(Teacher teacher) {
        iTeacherRepository.addTeacher(teacher.getTeacherName(), teacher.getTeacherDateOfBirth(), teacher.getDegree().getDegreeId(), teacher.getTeacherAddress(), teacher.isTeacherGender(), teacher.getTeacherPhoneNumber(), teacher.getFaculty().getFacultyId(), teacher.getTeacherEmail(), teacher.getTeacherCode(), teacher.getTeacherImg());
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        iTeacherRepository.updateTeacher(teacher.getTeacherName(), teacher.getTeacherDateOfBirth(), teacher.getDegree().getDegreeId(),teacher.getTeacherAddress(),teacher.isTeacherGender(), teacher.getTeacherPhoneNumber(), teacher.getFaculty().getFacultyId(), teacher.getTeacherEmail(), teacher.getTeacherImg(), teacher.getTeacherId());
    }

    @Override
    public List<IEmailAndPhoneNumberDTO> getAllPhoneNumberAndEmail() {
        return iTeacherRepository.getAllPhoneNumberAndEmail();
    }

}
