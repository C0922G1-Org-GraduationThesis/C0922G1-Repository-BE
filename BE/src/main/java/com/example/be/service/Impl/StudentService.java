package com.example.be.service.Impl;


import com.example.be.model.Student;
import com.example.be.repository.IStudentRepository;
import com.example.be.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository studentRepository;

    /**
     * Create by: HauNN
     * Date create: 29/03/2023
     * Function: find all student by name containing or code containing
     *
     * @return list page student if result is not error else return null
     * @Param: searchStr, pageable
     */
    @Override
    public Page<Student> findAllByNameOrStudentCode(String searchStr, Pageable pageable) {
        return this.studentRepository.findAllByNameOrStudentCode(searchStr, pageable);
    }

    /**
     * Create by: HauNN
     * Date create: 29/03/2023
     * Function: find all student by team id
     *
     * @return list page student if result is not error else return null
     * @Param: teamId, pageable
     */
    @Override
    public Page<Student> findAllByTeamId(Long teamId, Pageable pageable) {
        return this.studentRepository.findAllByTeamId(teamId, pageable);
    }
}
