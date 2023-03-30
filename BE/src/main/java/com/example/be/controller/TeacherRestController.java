package com.example.be.controller;

import com.example.be.dto.ITeacherDto;
import com.example.be.service.Impl.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/teachers")
public class TeacherRestController {
    @Autowired
    private TeacherService teacherService;

    /**
     * create by : HungPV ,
     * Date Create : 29/03/2023
     * Function : show list has paging and search
     * @param name
     * @param pageable
     * @return HttpStatus.BAD_REQUEST if result is error or HttpStatus.OK if result is not error
     */
    @GetMapping("/list")
    public ResponseEntity<Page<ITeacherDto>> getAllTeacher(@RequestParam(defaultValue = "") String name,
                                                           @PageableDefault(size = 8, page = 0) Pageable pageable) {
        Page<ITeacherDto> teacherPage = teacherService.getAllTeacher(name, pageable);
        if (teacherPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(teacherPage, HttpStatus.OK);
    }

    /**
     * create by : HungPV ,
     * Date Create : 29/03/2023
     * Function : get teacher by id
     * @param id
     * @return HttpStatus.NOT_FOUND if result is error or HttpStatus.OK if result is not error
     */
    @GetMapping("/list/{id}")
    public ResponseEntity<ITeacherDto> getTeacherById(@PathVariable Long id) {
        Optional<ITeacherDto> categoryOptional = teacherService.findTeacherById(id);
        return categoryOptional.map(teacher -> new ResponseEntity<>(teacher, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * create by : HungPV ,
     * Date Create : 29/03/2023
     * Function : delete teacher by id
     * @param id
     * @return notFound if delete is error HttpStatus.OK if result is not error
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ITeacherDto> deleteTeacherById(@PathVariable Long id) {
        Optional<ITeacherDto> teacher = teacherService.findTeacherById(id);

        if (!teacher.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        teacherService.deleteTeacherById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
