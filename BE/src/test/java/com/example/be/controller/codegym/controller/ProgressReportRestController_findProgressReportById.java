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

/**
 * Created by: SyVT
 * Date created: 30/3/2023
 * Function: Test JUnit findProgressReportByProgressReportId
 *
 */
@SpringBootTest
@AutoConfigureMockMvc
public class ProgressReportRestController_findProgressReportById {
    @Autowired
    private MockMvc mockMvc;


    @Test
    public void findProgressReport_id_1() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/progress-reports/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void findProgressReport_id_2() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/progress-reports/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

        @Test
    public void findProgressReport_id_3() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/progress-reports/{id}", "13"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void findProgressReport_id_4() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/progress-reports/{id}", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpectAll(jsonPath("progressReportId").value(1),
                        jsonPath("progressReportContent").value("Báo cáo giai đoạn 1 test nội dung"),
                        jsonPath("progressReportTime").value("2023-03-28 07:00:00"),
                        jsonPath("progressReportFile").value("https://cdn.pixabay.com/photo/2023/03/25/10/59/hedgehog-fly-7875687_640.jpg"),
                        jsonPath("stage.stageId").value(1),
                        jsonPath("project.projectId").value(1));

    }


}
