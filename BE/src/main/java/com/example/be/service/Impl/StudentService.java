package com.example.be.service.Impl;

import com.example.be.dto.StudentDto;
import com.example.be.dto.StudentInfo;
import com.example.be.model.Student;
import com.example.be.repository.IStudentRepository;
import com.example.be.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    /**
     * Create by : VinhLD
     * Date create 29/03/2023
     * Function: show list student
     *
     * @param pageable
     * @param nameSearch
     * @return json list student
     */

    @Override
    public Page<StudentDto> getStudentList(Pageable pageable, String nameSearch) {
        return studentRepository.getStudentList(pageable, nameSearch);
    }

    /**
     * Create by : VinhLD
     * Date create 29/03/2023
     * Function: show the instructor's list of students
     *
     * @param pageable
     * @param nameSearch
     * @param idTeacher
     * @return json the instructor's list of students
     */
    @Override
    public Page<StudentInfo> findAllStudent(Pageable pageable, String nameSearch, Long idTeacher) {
        return studentRepository.findAllStudent(pageable,nameSearch,idTeacher);
    }
}
