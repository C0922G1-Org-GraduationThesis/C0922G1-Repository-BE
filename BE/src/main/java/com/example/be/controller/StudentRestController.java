package com.example.be.controller;

import com.example.be.dto.StudentDto;
import com.example.be.model.Student;
import com.example.be.service.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin("*")
@RequestMapping("/students")
public class StudentRestController {
    @Autowired
    private IStudentService studentService;

    @PostMapping("/create")
    public ResponseEntity<?> save(@RequestBody StudentDto studentDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Student student = new Student();
        BeanUtils.copyProperties(studentDto, student);
        String studentCode = "sv-" + (studentService.maxIdStudent() + 1);
        System.out.println(studentCode);
        studentService.addStudent(student.getStudentName(), studentCode,
                student.getStudentDateOfBirth(), student.getStudentEmail(), student.getStudentPhoneNumber(),
                student.isStudentGender(), student.getStudentAddress(), student.getStudentImg(), student.getClazz().getClazzId());
        return new ResponseEntity(student, HttpStatus.OK);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Student> findById(@PathVariable long studentId) {
        Student student = studentService.findById(studentId);
        if (student == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(student, HttpStatus.OK);
        }
    }

    @PatchMapping("/update/{studentId}")
    public ResponseEntity<Student> updateStudent(@Validated @RequestBody StudentDto studentDto, @PathVariable long studentId, BindingResult bindingResult) {
        Student student = studentService.findById(studentId);
        if (student == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            if (bindingResult.hasErrors()) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            BeanUtils.copyProperties(studentDto, student);
            studentService.updateStudent(studentId, student);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
