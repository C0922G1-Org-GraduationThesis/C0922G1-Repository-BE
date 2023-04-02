package com.example.be.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TeamController_findTeamById {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void findTeamById_id_1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/teams/detail/{teamId}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void findTeamById_id_2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/teams/detail/{teamId}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void findTeamById_id_3() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/teams/detail/{teamId}", "100"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void findTeamById_id_4() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/teams/detail/{teamId}", "3"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpectAll(
                        jsonPath("teamId").value(3),
                        jsonPath("teamName").value("Hậu và những người bạn"),
                        jsonPath("memberOfTeam").value(4),
                        jsonPath("teacher.teacherId").value(2));
    }

}
