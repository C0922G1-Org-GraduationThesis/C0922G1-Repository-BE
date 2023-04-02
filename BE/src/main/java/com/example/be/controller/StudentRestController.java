package com.example.be.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.be.model.Student;
import com.example.be.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
     * Create by: HauNN
     * Date create: 29/03/2023
     * Function: find all student by name containing or code containing
     *
     * @return HttpStatus.OK if result is not error, return HttpStatus.NO_CONTENT if result is empty
     * @Param: searchStr, size, page
     */
    @GetMapping("/")
    public ResponseEntity<Page<Student>> findAllByNameOrStudentCode
    (@RequestParam String searchStr,
     @RequestParam int size,
     @RequestParam int page) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Student> students = this.studentService.findAllByNameOrStudentCode(searchStr, pageable);

        if (students.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    /**
     * Create by: HauNN
     * Date create: 29/03/2023
     * Function: find all student by team id
     *
     * @return HttpStatus.OK if result is not error, return HttpStatus.NO_CONTENT if result is empty
     * @Param: teamId, size, page
     */
    @GetMapping("/team/{teamId}/{page}/{size}")
    public ResponseEntity<Page<Student>> findAllByTeamId
    (@PathVariable Long teamId,
     @PathVariable int page,
     @PathVariable int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Student> students = this.studentService.findAllByTeamId(teamId, pageable);

        if (students.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    /**
     * Create by: HauNN
     * Date create: 29/03/2023
     * Function: find student by id
     *
     * @return HttpStatus.OK if result is not error, return HttpStatus.NO_CONTENT if result is null
     * @Param: teamId, size, page
     */
    @GetMapping("/detail/{id}")
    public ResponseEntity<Student> findById(@PathVariable Long id) {
        Student student = this.studentService.findById(id);

        if (student == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
}