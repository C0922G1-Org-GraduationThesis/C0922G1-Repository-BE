package com.example.be.service.Impl;


import com.example.be.model.Team;
import com.example.be.repository.ITeamRepository;
import com.example.be.service.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TeamService implements ITeamService {
    @Autowired
    private ITeamRepository teamRepository;

    /**
     * Create by: HauNN
     * Date create: 29/03/2023
     * Function: find all team by name containing
     *
     * @return list page team if result is not error else return null
     * @Param: teamName, pageable
     */
    @Override
    public Page<Team> findAll(String teamName, Pageable pageable) {
        return this.teamRepository.findAll(teamName, pageable);
    }

    /**
     * Create by: HauNN
     * Date create: 29/03/2023
     * Function: find by team id
     *
     * @return team if result is not error else return null
     * @Param: id
     */
    @Override
    public Team findById(Long id) {
        return this.teamRepository.findById(id).orElse(null);
    }

    /**
     * Create by: HauNN
     * Date create: 29/03/2023
     * Function: save team
     *
     * @return team if result is not error else return null
     * @Param: team
     */
    @Transactional
    @Override
    public Team saveTeam(Team team) {
        Team teamOptional = this.teamRepository.findByName(team.getTeamName()).orElse(null);

        if (teamOptional != null) {
            return null;
        }

        if (team.getTeacher() != null) {
            return null;
        }

        if (team.getProject() != null) {
            return null;
        }
        return this.teamRepository.save(team);

    }
}

