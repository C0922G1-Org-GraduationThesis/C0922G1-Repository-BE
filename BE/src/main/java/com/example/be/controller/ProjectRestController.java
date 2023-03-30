package com.example.be.controller;
import com.example.be.dto.ProjectDTO;
import com.example.be.model.Project;
import com.example.be.model.Team;
import com.example.be.service.IProjectService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/projects")
public class ProjectRestController {
    @Autowired
    private IProjectService projectService;

    /**
     * Create by: HauNN
     * Date create: 29/03/2023
     * Function: find all project by name containing
     *
     * @return HttpStatus.OK, else return HttpStatus.NO_CONTENT if result is empty
     * @Param: searchName, size, page
     */

    @GetMapping("/")
    public ResponseEntity<Page<Project>> findAll(@RequestParam String searchName,
                                                 @RequestParam int size,
                                                 @RequestParam int page) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Project> projects = this.projectService.findAllByNameContaining(searchName, pageable);

        if (projects.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    /**
     * Create by: HauNN
     * Date create: 29/03/2023
     * Function: save project
     *
     * @return HttpStatus.OK if result is not error else return HttpStatus.NOT_ACCEPTABLE
     * @Param: projectDTO, bindingResult
     */
    @PostMapping("/save")
    public ResponseEntity<List<FieldError>> saveProject(@Validated @RequestBody ProjectDTO projectDTO,
                                                        BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.NOT_ACCEPTABLE);
        }

        Project project = new Project();
        BeanUtils.copyProperties(projectDTO, project);
        Team team = new Team();
        team.setTeamId(projectDTO.getTeamDTO().getTeamId());
        project.setTeam(team);

        if (this.projectService.save(project) != null) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    /**
     * Create by: HauNN
     * Date create: 29/03/2023
     * Function: find project by id
     *
     * @return HttpStatus.OK if result not null else return HttpStatus.NO_CONTENT
     * @Param: id
     */
    @GetMapping("/detail/{id}")
    public ResponseEntity<Project> findById(@PathVariable Long id) {
        Project project = this.projectService.findById(id);

        if (project != null) {
            return new ResponseEntity<>(project, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
