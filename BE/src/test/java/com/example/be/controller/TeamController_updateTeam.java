package com.example.be.controller;

import com.example.be.dto.TeamDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TeamController_updateTeam {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void updateTeam_24() throws Exception {
        TeamDto teamDto = new TeamDto();
        teamDto.setTeamId(1L);
        teamDto.setTeacherId(1L);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/teams/edit/1")
                        .content(this.objectMapper.writeValueAsString(teamDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void updateTeam_19() throws Exception {
        TeamDto teamDto = new TeamDto();
        teamDto.setTeamId(1L);
        teamDto.setTeacherId(null);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/teams/edit/1")
                        .content(this.objectMapper.writeValueAsString(teamDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

}
