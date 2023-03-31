package com.example.be.controller.codegym.controller;

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
public class ProgressViewRestController_findMaxPercentProgressReport {
    @Autowired
    private MockMvc mockMvc;


    @Test
    public void findMaxPercentProgressReport_projectId_1() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/progress-reviews/{projectId}{stageId}", "null", "1"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void findMaxPercentProgressReport_projectId_2() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/progress-reviews/{projectId}{stageId}", "", "1"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void findMaxPercentProgressReport_projectId_3() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/progress-reviews/{projectId}{stageId}", "3", "1"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void findMaxPercentProgressReport_projectId_4() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/progress-reviews/{projectId}{stageId}", "1", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpectAll(
                        jsonPath("progressReportPercent").value(100)
                );
    }
    @Test
    public void findMaxPercentProgressReport_stageId_1() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/progress-reviews/{projectId}{stageId}", "1", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void findMaxPercentProgressReport_stageId_2() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/progress-reviews/{projectId}{stageId}", "1", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void findMaxPercentProgressReport_stageId_3() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/progress-reviews/{projectId}{stageId}", "1", "3"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void findMaxPercentProgressReport_stageId_4() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/progress-reviews/{projectId}{stageId}", "1", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpectAll(
                        jsonPath("progressReportPercent").value(100)
                );
    }
}
