package com.example.be.service.Impl;


import com.example.be.dto.ITeamDto;
import com.example.be.dto.TeacherDto;
import com.example.be.model.Teacher;
import com.example.be.model.Team;
import com.example.be.repository.ITeamRepository;
import com.example.be.service.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

@Service
public class TeamService implements ITeamService {

    @Autowired
    private ITeamRepository teamRepository;

    /**
     * Created by: DucND
     * Date create: 29/03/2023
     * Function: get all teacher and paging
     * @param: pageable
     * @return list instructor and paging
     */
    @Override
    public Page<TeacherDto> getAllInstructor(Pageable pageable) {
        return teamRepository.getAllInstructor(pageable);
    }

    /**
     * Created by: DucND
     * Date create: 29/03/2023
     * Function: find team by id
     * @param: teamId
     * @return the team you looking for
     */
    @Override
    public ITeamDto findTeamById(Long teamId) {
        return teamRepository.findTeamById(teamId);
    }


    /**
     * Created by: DucND
     * Date create: 29/03/2023
     * Function: add or edit instructor for team
     * @param: teacherId, teamId
     */
    @Override
    public void updateTeam(Long teacherId, Long teamId) {
        teamRepository.updateTeam(teacherId,teamId);
    }

}
