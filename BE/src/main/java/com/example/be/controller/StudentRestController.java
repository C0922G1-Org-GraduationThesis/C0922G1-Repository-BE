package com.example.be.controller;
import com.example.be.model.Student;
import com.example.be.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/students")
public class StudentRestController {
    @Autowired
    private IStudentService studentService;

    @PostMapping("create")
    public ResponseEntity save( @RequestBody Student student){
       studentService.addStudent(student.getStudentName(),student.getStudentCode(),
               student.getStudentDateOfBirth(),student.getStudentEmail(),student.getStudentPhoneNumber(),
               student.isStudentGender(),student.getStudentAddress(),student.getStudentImg(),student.getClazz().getClazzId());
       return new ResponseEntity(student, HttpStatus.OK);
    }
}
