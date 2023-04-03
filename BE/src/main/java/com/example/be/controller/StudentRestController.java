package com.example.be.controller;

import com.example.be.dto.StudentDto;
import com.example.be.dto.StudentDto1;
import com.example.be.model.Student;
import com.example.be.service.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

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

    /**
     * Create by : VinhLD
     * Date create : 29/3/2023
     * Function: show list student
     * @param nameSearch
     * @param pageable
     * @return HttpStatus.OK if connect to database return json list student or HttpStatus.NOT_FOUND if list student is empty
     */

    @GetMapping("")
    public ResponseEntity<Page<StudentDto1>> getAllStudent(@RequestParam(value = "nameSearch",defaultValue = "") String nameSearch,
                                                          @PageableDefault(size = 4) Pageable pageable) {
        Page<StudentDto1> studentDtos = studentService.getStudentList(pageable, nameSearch);
        if (studentDtos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return  new ResponseEntity<>(studentDtos, HttpStatus.OK);
    }
}
