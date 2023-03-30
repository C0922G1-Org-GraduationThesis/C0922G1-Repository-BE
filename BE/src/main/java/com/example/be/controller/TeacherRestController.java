package com.example.be.controller;

import com.example.be.dto.UserRoleAdminDto;
import com.example.be.model.Teacher;
import com.example.be.service.ITeacherService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/teachers")
public class TeacherRestController {
    @Autowired
    private ITeacherService teacherService;

    /**
     * Created by: Phạm Tiến
     * Date: 29/03/2023
     * Function: findStudentById(email)
     * @Return: new ResponseEntity<>(HttpStatus.BAD_REQUEST) if result is error,
     * else new ResponseEntity<>(student, HttpStatus.OK)
     */
    @RequestMapping(value = "detail/{email}", method = RequestMethod.GET)
    public ResponseEntity<Teacher> findStudentById(@PathVariable String email) {
        Teacher teacher = teacherService.findTeacherByEmail(email);
        if (teacher == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }

    /**
     * Created by: Phạm Tiến
     * Date: 29/03/2023
     * Function: updateTeacherRoleAdmin(teacher,bindingResult )
     * @Return: new ResponseEntity<>(HttpStatus.BAD_REQUEST) if result is error,
     * else new ResponseEntity<>(student, HttpStatus.OK)
     */
    @RequestMapping(value = "/update-user-role-admin", method = RequestMethod.PATCH)
    public ResponseEntity<List<FieldError>> updateTeacherRoleAdmin(@RequestBody UserRoleAdminDto userRoleAdminDto,
                                                                   BindingResult bindingResult) {
        Teacher teacherUpdate = teacherService.findTeacherById(userRoleAdminDto.getTeacherId());
        if (teacherUpdate == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.BAD_REQUEST);
        } else {
            BeanUtils.copyProperties(userRoleAdminDto, teacherUpdate);
            teacherService.updateTeacherRoleAdmin(teacherUpdate);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}