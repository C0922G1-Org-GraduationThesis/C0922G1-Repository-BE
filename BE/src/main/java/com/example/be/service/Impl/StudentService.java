package com.example.be.service.Impl;

import com.example.be.dto.StudentDto1;
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

    /**
     * Create by: HauNN
     * Date create: 29/03/2023
     * Function: find student by id
     *
     * @return student if result is not null else return null
     * @Param: id
     */
    @Override
    public Student findById(Long id) {
        return this.studentRepository.findById(id).orElse(null);
    }

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

    @Override
    public Student findById(long studentId) {
        return studentRepository.findById(studentId);
    }

    @Override
    public void updateStudent(long studentId, Student student) {
        studentRepository.updateStudent(student.getStudentName(),student.getStudentCode(),
                student.getStudentDateOfBirth(),student.getStudentEmail(),
                student.getStudentPhoneNumber(),student.isStudentGender(),student.getStudentAddress(),
                student.getStudentImg(),student.getClazz().getClazzId(),studentId);
    }

    @Override
    public Long maxIdStudent() {
        return studentRepository.getStudentId();
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
    public Page<StudentDto1> getStudentList(Pageable pageable, String nameSearch) {
        return studentRepository.getStudentList(pageable, nameSearch);
    }
}
