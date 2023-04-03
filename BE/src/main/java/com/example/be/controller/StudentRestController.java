package com.example.be.controller;
import com.example.be.dto.StudentDto;
import com.example.be.dto.StudentInfo;
import com.example.be.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
     * Create by : VinhLD
     * Date create : 29/3/2023
     * Function: show list student
     * @param nameSearch
     * @param pageable
     * @return HttpStatus.OK if connect to database return json list student or HttpStatus.NOT_FOUND if list student is empty
     */

    @GetMapping("")
    public ResponseEntity<Page<StudentDto>> getAllStudent(@RequestParam(value = "nameSearch",defaultValue = "") String nameSearch,
                                                          @PageableDefault(size = 4) Pageable pageable) {
        Page<StudentDto> studentDtos = studentService.getStudentList(pageable, nameSearch);
        if (studentDtos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return  new ResponseEntity<>(studentDtos, HttpStatus.OK);

    }


    /**
     * Create by : Vinh LD
     * Date create: 29/3/2023
         * Function: show the instructor's list of students
     * @param nameSearch
     * @param pageable
     * @param teacherId
     * @return HttpStatus.OK if connect to database return json the instructor's list of students or HttpStatus.NOT_FOUND if the instructor's list of students is empty
     */

    @GetMapping("/list-id-teacher/{teacherId}")
    public ResponseEntity<Page<StudentInfo>>getStudentListIdTeacher(@RequestParam(value = "nameSearch",defaultValue = "") String nameSearch,
                                                                    @PageableDefault(size = 4) Pageable pageable,
                                                                    @PathVariable Long teacherId){
        Page<StudentInfo> studentInfos= studentService.findAllStudent(pageable,nameSearch,teacherId);
        if (studentInfos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(studentInfos,HttpStatus.OK);
    }


}
