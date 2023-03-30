package com.example.be.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.be.dto.TeamDTO;
import com.example.be.model.Project;
import com.example.be.model.Teacher;
import com.example.be.model.Team;
import com.example.be.service.ITeamService;
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

@RestController
@CrossOrigin("*")
@RequestMapping("/api/teams")
public class TeamRestController {
    @Autowired
    private ITeamService teamService;

    /**
     * Create by: HauNN
     * Date create: 29/03/2023
     * Function: save team
     *
     * @return HttpStatus.OK if result is not error else return HttpStatus.EXPECTATION_FAILED
     * @Param: teamDTO, bindingResult
     */
    @PostMapping("/save")
    public ResponseEntity<List<FieldError>> saveTeam(@Validated @RequestBody TeamDTO teamDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.NOT_ACCEPTABLE);
        }

        Team team = new Team();
        BeanUtils.copyProperties(teamDTO, team);

        if (this.teamService.saveTeam(team) != null) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    /**
     * Create by: HauNN
     * Date create: 29/03/2023
     * Function: find team by id
     *
     * @return HttpStatus.OK if result is not error else return HttpStatus.NO_CONTENT if result is empty
     * @Param: id
     */
    @GetMapping("/detail/{id}")
    public ResponseEntity<Team> findById(@PathVariable Long id) {
        Team team = this.teamService.findById(id);

        if (team != null) {
            return new ResponseEntity<>(team, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
