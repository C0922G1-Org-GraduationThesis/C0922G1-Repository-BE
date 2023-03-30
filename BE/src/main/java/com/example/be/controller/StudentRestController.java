package com.example.be.controller;

import com.example.be.model.Student;
import com.example.be.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/students")
public class StudentRestController {
    @Autowired
    private IStudentService studentService;

    /**
     * Created by: TienP
     * Date: 29/03/2023
     * Function: findStudentByEmail(email)
     * @Return: new ResponseEntity<>(HttpStatus.BAD_REQUEST) if result is error,
     * else new ResponseEntity<>(student, HttpStatus.OK)
     */
    @RequestMapping(value = "/detail/{email}", method = RequestMethod.GET)
    public ResponseEntity<Student> findStudentByEmail(@PathVariable String email){
        Student student = studentService.findStudentByEmail(email);
        if (student == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
}
