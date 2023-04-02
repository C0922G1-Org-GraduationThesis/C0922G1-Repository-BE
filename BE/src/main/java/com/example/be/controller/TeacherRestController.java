package com.example.be.controller;

import com.example.be.dto.teacher.*;
import com.example.be.model.Degree;
import com.example.be.model.Faculty;
import com.example.be.model.Teacher;
import com.example.be.service.IDegreeService;
import com.example.be.service.IFacultyService;
import com.example.be.service.ITeacherService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/teachers")
public class TeacherRestController {
    @Autowired
    private IDegreeService iDegreeService;
    @Autowired
    private IFacultyService iFacultyService;
    @Autowired
    private ITeacherService iTeacherService;

    /**
     * Create by: TanNN
     * Date created: 31/03/2023
     * Function: getAllDegree
     *
     * @return HttpStatus.OK when the data is saved to the database, HttpStatus.BAD_REQUEST when an error occurs
     */
    @GetMapping("/degreeAll")
    public ResponseEntity getAllDegree() {
        List<IDegreeDTO> listDegree = iDegreeService.getAllDegree();
        if (listDegree == null) {
            return new ResponseEntity(listDegree, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(listDegree, HttpStatus.OK);
    }

    /**
     * Create by: TanNN
     * Date created: 31/03/2023
     * Function: getAllFaculty
     *
     * @return HttpStatus.OK when the data is saved to the database, HttpStatus.BAD_REQUEST when an error occurs
     */
    @GetMapping("facultyAll")
    public ResponseEntity getAllFaculty() {
        List<IFacultyDTO> listDegree = iFacultyService.getAllFaculty();
        if (listDegree == null) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(listDegree, HttpStatus.OK);
    }

    /**
     * Create by: TanNN
     * Date created: 31/03/2023
     * Function: getTeacher
     *
     * @param id
     * @return HttpStatus.OK when the data is saved to the database, HttpStatus.BAD_REQUEST when an error occurs
     */
    @GetMapping("detailTeacher/{id}")
    public ResponseEntity getTeacher(@PathVariable("id") Long id) {
        Teacher teacher = new Teacher();
        ITeacherDTO teacherDTO = iTeacherService.getTeacher(id);
        if (teacherDTO == null) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        teacher.setTeacherId(teacherDTO.getTeacherId());
        teacher.setTeacherImg(teacherDTO.getTeacherImg());
        teacher.setTeacherName(teacherDTO.getTeacherName());
        teacher.setTeacherDateOfBirth(teacherDTO.getTeacherDateOfBirth());
        teacher.setDegree(new Degree(teacherDTO.getDegreeId(), teacherDTO.getDegreeName()));
        teacher.setTeacherAddress(teacherDTO.getTeacherAddress());

        if (teacherDTO.getTeacherGender()) {
            teacher.setTeacherGender(true);
        } else {
            teacher.setTeacherGender(false);
        }
        teacher.setTeacherPhoneNumber(teacherDTO.getTeacherPhoneNumber());
        teacher.setFaculty(new Faculty(teacherDTO.getFacultyId(), teacherDTO.getFacultyName()));
        teacher.setTeacherEmail(teacherDTO.getTeacherEmail());

        if (teacher.getTeacherId() == null) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(teacher, HttpStatus.OK);
    }

    /**
     * Create by: TanNN
     * Date created: 31/03/2023
     * Function: createTeacher
     *
     * @param teacherDTO
     * @return HttpStatus.OK when the data is saved to the database, HttpStatus.BAD_REQUEST when an error occurs
     */
    @PostMapping("createTeacher")
    public ResponseEntity<?> createTeacher(@Validated @RequestBody TeacherDTO teacherDTO, BindingResult bindingResult) {

        teacherDTO.checkValidateCreateTeacher(iTeacherService.findAll(), teacherDTO, bindingResult);
        System.out.println(iTeacherService.getAllPhoneNumberAndEmail());
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }

        Teacher teacher = new Teacher();
        String teacherCode = "GV-" + (iTeacherService.maxIdTeacher().getTeacherId() + 1);
        teacherDTO.setTeacherCode(teacherCode);
        BeanUtils.copyProperties(teacherDTO, teacher);
        iTeacherService.addTeacher(teacher);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Create by: TanNN
     * Date created: 31/03/2023
     * Function: updateTeacher
     *
     * @param teacherDTO
     * @return HttpStatus.OK when the data is saved to the database, HttpStatus.BAD_REQUEST when an error occurs
     */
    @PatchMapping("updateTeacher/{id}")
    public ResponseEntity updateTeacher(@PathVariable("id") Long id, @Validated @RequestBody TeacherDTO teacherDTO, BindingResult bindingResult) {
        teacherDTO.checkValidateUpdateTeacher(iTeacherService.findAll(), teacherDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        teacherDTO.setTeacherId(id);
        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(teacherDTO, teacher);
        iTeacherService.updateTeacher(teacher);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("getAllPhoneNumberAndEmail")
    public ResponseEntity<?> listEmailAndPhoneNumber() {
        System.out.println(iTeacherService.getAllPhoneNumberAndEmail());
        List<Teacher> iEmailAndPhoneNumberDTOS = iTeacherService.findAll();

        return new ResponseEntity<>(iEmailAndPhoneNumberDTOS, HttpStatus.OK);
    }

}
