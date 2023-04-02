package com.example.be.controller;

import com.example.be.dto.ITeacherDto;
import com.example.be.dto.ITeamDto;
import com.example.be.dto.TeacherDto;
import com.example.be.dto.TeamDto;
import com.example.be.service.ITeacherService;
import com.example.be.service.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/teams")
public class TeamRestController {
    @Autowired
    private ITeamService teamService;
    @Autowired
    private ITeacherService teacherService;

    /**
     * Created by: DucND
     * Date create: 01/04/2023
     * Function: tạo api get teacher by id
     *
     * @return HttpStatus.NOT_FOUND if result is empty or HttpStatus.OK if in the data have record teachers.
     * @param: id
     */
    @GetMapping("/teacher/{id}")
    public ResponseEntity<ITeacherDto> getTeacherById(@PathVariable Long id) {
        Optional<ITeacherDto> categoryOptional = teacherService.findTeacherById(id);
        return categoryOptional.map(teacher -> new ResponseEntity<>(teacher, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Created by: DucND
     * Date create: 29/03/2023
     * Function: tạo api get all and paging information teacher
     *
     * @return HttpStatus.NOT_FOUND if result is empty or HttpStatus.OK if in the data there are record teachers.
     * @param: pageable
     */
    @GetMapping("")
    public ResponseEntity<Page<TeacherDto>> getAllInstructor(@PageableDefault(size = 5) Pageable pageable) {
        Page<TeacherDto> instructorPage = teamService.getAllInstructor(pageable);
        if (instructorPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(instructorPage, HttpStatus.OK);
        }
    }

    /**
     * Created by: DucND
     * Date create: 29/03/2023
     * Function: create api find team by id
     *
     * @return HttpStatus.NOT_FOUND if result is null or HttpStatus.OK if there is a team with the teamId to look for.
     * @param: teamId
     */
    @GetMapping("/detail/{id}")
    public ResponseEntity<ITeamDto> findTeamById(@PathVariable Long id) {
        ITeamDto team = teamService.findTeamById(id);
        if (team == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(team, HttpStatus.OK);
        }
    }

    /**
     * Created by: DucND
     * Date create: 29/03/2023
     * Function: create api edit,add instructor team
     *
     * @return HttpStatus.NOT_FOUND if result team is null, not found or HttpStatus.OK if result is edit success.
     * @param: teamId, teamDto
     */
    @PatchMapping("/edit/{teamId}")
    public ResponseEntity<?> updateTeam(@Valid @RequestBody TeamDto teamDto, BindingResult bindingResult, @PathVariable Long teamId) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getAllErrors());
        }
        ITeamDto team = teamService.findTeamById(teamId);
        if (team == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            teamService.updateTeam(teamDto.getTeacherId(), teamId);
            return new ResponseEntity(teamDto, HttpStatus.OK);
        }
    }
}
