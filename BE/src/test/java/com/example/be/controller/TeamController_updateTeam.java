package com.example.be.controller;

import com.example.be.dto.TeamDto;
import com.example.be.model.Teacher;
import com.example.be.model.Team;
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
        teamDto.setTeacherId(2l);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/edit/{teamId}",2)
                        .content(this.objectMapper.writeValueAsString(teamDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
