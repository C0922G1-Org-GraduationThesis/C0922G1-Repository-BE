package com.example.be.service;

import com.example.be.dto.ITeamDto;
import com.example.be.dto.TeacherDto;
import com.example.be.model.Teacher;
import com.example.be.model.Team;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITeamService {
    /**
     * Created by: DucND
     * Date create: 29/03/2023
     * Function: paging list teacher
     */
    Page<TeacherDto> getAllInstructor(Pageable pageable);

    /**
     * Created by: DucND
     * Date create: 29/03/2023
     * Function: find team by id
     */
    ITeamDto findTeamById(Long teamId);

    /**
     * Created by: DucND
     * Date create: 29/03/2023
     * Function: edit team with teacher
     */
    void updateTeam(Long teacherId, Long teamId);
}
