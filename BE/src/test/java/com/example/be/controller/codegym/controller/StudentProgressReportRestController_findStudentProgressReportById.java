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
public class StudentProgressReportRestController_findStudentProgressReportById {
    @Autowired
    private MockMvc mockMvc;


    @Test
    public void findStudyProgressReport_id_7() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/studentProgressReport/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void findStudyProgressReport_id_8() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/studentProgressReport/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void findStudyProgressReport_id_9() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/studentProgressReport/{id}", "3"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void findStudyProgressReport_id_10() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/studentProgressReport/{id}", "2"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void findStudyProgressReport_id_11() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/studentProgressReport/{id}", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$[0].progressReportContent").value("Báo cáo giai đoạn 2 khởi công"))
                .andExpect(jsonPath("$[0].progressReportFile").value("https://cdn.pixabay.com/photo/2022/10/04/19/16/sea-7498910__340.jpg"))
                .andExpect(jsonPath("$[0].progressReportTime").value("2023-03-31 17:00:00.0"))
                .andExpect(jsonPath("$[0].studentName").value("Jane Doe"))
                .andExpect(jsonPath("$[0].studentImg").value("profile3.png"))
                .andExpect(jsonPath("$[4].progressReportContent").value("Báo cáo giai đoạn 1 test nội dung"))
                .andExpect(jsonPath("$[4].progressReportFile").value("https://cdn.pixabay.com/photo/2023/03/25/10/59/hedgehog-fly-7875687_640.jpg"))
                .andExpect(jsonPath("$[4].progressReportTime").value("2023-03-28 07:00:00.0"))
                .andExpect(jsonPath("$[4].studentName").value("Jane Doe"))
                .andExpect(jsonPath("$[4].studentImg").value("profile3.png")) ;
    }

}
