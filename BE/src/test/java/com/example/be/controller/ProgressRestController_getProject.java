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
public class ProgressRestController_getProject {
@Autowired
    private MockMvc mockMvc;

@Test
    public void getProjectEnable_1() throws Exception {
    this.mockMvc.perform(
            MockMvcRequestBuilders
                    .get("/api/progress/project/{projectId}","null"))
                    .andDo(print()).andExpect(status().is4xxClientError());

}
@Test
    public void getProjectEnable_2() throws Exception {
    this.mockMvc.perform(
            MockMvcRequestBuilders
                    .get("/api/progress/project/{projectId}",""))
                    .andDo(print()).andExpect(status().is4xxClientError());

}
@Test
    public void getProjectEnable_3() throws Exception {
    this.mockMvc.perform(
            MockMvcRequestBuilders
                    .get("/api/progress/project/{projectId}","12"))
                    .andDo(print()).andExpect(status().is4xxClientError());

}

    @Test
    public void getProjectEnable_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/progress/project/{projectId}", "1"))
                .andDo(print()).andExpect(status().is2xxSuccessful()).andExpectAll(
                        jsonPath("projectId").value(1),
                        jsonPath("projectName").value("Thiết kế ứng dụng đặt vé xem phim"),
                        jsonPath("projectContent").value("Thiết kế ứng dụng đặt vé xem phim"),
                        jsonPath("projectImg").value("https://cdn.pixabay.com/photo/2023/03/18/12/28/bonfire-7860562__340.jpg"),
                        jsonPath("projectDescription").value("starlight"),
                        jsonPath("projectStatus").value(true),
                        jsonPath("flagDelete").value(false)
                );


    }
}
