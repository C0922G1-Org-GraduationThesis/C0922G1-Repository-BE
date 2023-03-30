package com.example.be.controller;

import com.example.be.dto.IMailStudentDto;
import com.example.be.model.Project;
import com.example.be.model.Team;
import com.example.be.service.Impl.ProjectService;
import com.example.be.service.Impl.StudentService;
import com.example.be.service.Impl.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.internet.AddressException;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/projects")
public class ProjectRestController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private StudentService studentService;

    /**
     * Created by: NuongHT
     * Date create: 29/03/2023
     * Function: tạo api get all topic value -> browser/cancel topic
     *
     * @return HttpStatus.NO_CONTENT if result is isEmty or HttpStatus.OK if result is Emty.
     */

    @GetMapping("/listPage")
    public ResponseEntity<Page<Project>> getStudentList(@PageableDefault(size = 2) Pageable pageable) {
        Page<Project> projectPage = projectService.findPagePro(pageable);
        if (projectPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(projectPage, HttpStatus.OK);
    }

    /**
     * Created by: NuongHT
     * Date create: 29/03/2023
     * Function: tạo api send mail
     *
     * @param teamId
     * @throws AddressException
     */

    @GetMapping("/send/{teamId}")
    public void sendEMail(@PathVariable("teamId") Long teamId) throws AddressException {
        List<IMailStudentDto> list = studentService.getInfomation(teamId);
        studentService.sendSimpleMessage(list, "Bạn có mail mới", "Đề tài của bạn quá ô kê được duyệt.", 1);
    }

    /**
     * Created by: NuongHT
     * Date create: 29/03/2023
     * Function: tạo api browser topic set status for project,browser successfull will send mail for group student.
     *
     * @param projectId
     * @return HttpStatus.NO_CONTENT if result is null or HttpStatus.OK if result is not null.
     */

    @PutMapping("/browser/{projectId}")
    public ResponseEntity<List<IMailStudentDto>> updateBrowserPro(@PathVariable("projectId") Long projectId) {
        Project project = projectService.findProById(projectId);
        if (project == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        projectService.updatePro(projectId);
        List<IMailStudentDto> list = studentService.getInfomation(projectId);
        studentService.sendSimpleMessage(list, "Bạn có mail mới! ", "", 0);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Created by: NuongHT
     * Date create: 29/03/2023
     * Function: tạo api cancel browser topic set status for project,cancel successfull will send mail for group student.
     * @param projectId
     * @return HttpStatus.NO_CONTENT if result is null or HttpStatus.OK if result is not null.
     */

    @PutMapping("/cancel/{projectId}")
    public ResponseEntity<?> updateCancelPro(@PathVariable("projectId") Long projectId) {
        Project project = projectService.findProById(projectId);
        if (project == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        projectService.updatePro2(projectId);
        List<IMailStudentDto> list = studentService.getInfomation(projectId);
        studentService.sendSimpleMessage2(list, "Bạn có mail mới! ", "",1);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
