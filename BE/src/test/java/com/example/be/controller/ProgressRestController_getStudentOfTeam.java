package com.example.be.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc

public class ProgressRestController_getStudentOfTeam {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getStudentOfTeam_10() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/progress/progressStudent/{projectId}", "null")).andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getStudentOfTeam_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/progress/progressStudent/{projectId}", "")).andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getStudentOfTeam_12() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/progress/progressStudent/{projectId}", 22)).andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getStudentOfTeam_13() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/progress/progressStudent/{projectId}", 2)).andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getStudentOfTeam_14() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/progress/progressStudent/{projectId}", 1)).andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpectAll(
                        jsonPath("$[0].studentName").value("John Doe"),
                        jsonPath("$[0].studentEmail").value("john.doe@gmail.com"),
                        jsonPath("$[0].studentPhoneNumber").value("090001004"),
                        jsonPath("$[0].studentImg").value("profile2.png")
                        , jsonPath("$", hasSize(1)));
    }
}
