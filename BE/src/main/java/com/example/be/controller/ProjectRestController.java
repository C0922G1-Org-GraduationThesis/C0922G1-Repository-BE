package com.example.be.controller;
import com.example.be.model.Project;
import com.example.be.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/projects")
public class ProjectRestController {
    @Autowired
    private IProjectService projectService;
    /**
     * Created by: hoangNNH
     * Date created: 29/03/2023
     * Function: get project list
     *
     * @param page, name
     * @return HttpStatus.NO_CONTENT if result is error or HttpStatusOK if result is not error
     */
    @GetMapping("")
    public ResponseEntity<Page<Project>> pagingAndGetAllProject(
            @RequestParam(defaultValue = "0", required = false) int page,
            @RequestParam(defaultValue = "", required = false) String name) {
        Pageable pageable = PageRequest.of(page, 3);
        Page<Project> projectPage = this.projectService.getAllProject(pageable, name);
        if (!projectPage.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(projectPage, HttpStatus.OK);
    }
    /**
     * Created by: hoangNNH
     * Date created: 29/03/2023
     * Function: get project by id
     *
     * @return HttpStatus.NO_CONTENT if result is error or HttpStatusOK if result is not error
     */
    @GetMapping("detail/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long id) {
        Project project = this.projectService.getProjectById(id);
        if (project== null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(project, HttpStatus.OK);
    }
}
