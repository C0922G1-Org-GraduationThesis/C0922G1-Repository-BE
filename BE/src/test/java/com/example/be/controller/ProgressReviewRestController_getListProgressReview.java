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
public class ProgressReviewRestController_getListProgressReview {
    @Autowired
    private MockMvc mockMvc;



    @Test
    public void getProgressReview_10() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/progressReview/list/{projectId}", "null")).andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getProgressReview_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/progressReview/list/{projectId}", "")).andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getProgressReview_12() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/progressReview/list/{projectId}", 22)).andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getProgressReview_13() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/progressReview/list/{projectId}", 2)).andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getStudentOfTeam_14() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/progressReview/list/{projectId}", 1)).andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpectAll(
                        jsonPath("$[0].progressReviewId").value(4),
                        jsonPath("$[0].progressReviewTitle").value("Kết quả"),
                        jsonPath("$[0].progressReviewContent").value(" Tiến độ 3"),
                        jsonPath("$[0].progressReviewPercent").value(100),
                        jsonPath("$[0].progressReviewDateCreate").value("2023-03-25 16:30:11"),
                        jsonPath("$[0].teacher.teacherId").value(1),
                        jsonPath("$[0].teacher.teacherName").value("Phạm Công Tiến"),
                        jsonPath("$[0].project.projectId").value(1)
                        , jsonPath("$", hasSize(1)));
    }
}
