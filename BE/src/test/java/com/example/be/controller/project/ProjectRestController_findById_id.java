package com.example.be.controller.project;

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
public class ProjectRestController_findById_id {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Create by: HauNN
     * Date create: 29/03/2023
     * Function: test id is null
     */
    @Test
    public void findById_1() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/projects/detail/{id}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HauNN
     * Date create: 29/03/2023
     * Function: test id is empty
     */
    @Test
    public void findById_2() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/projects/detail/{id}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HauNN
     * Date create: 29/03/2023
     * Function: test id invalid
     */
    @Test
    public void findById_3() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/projects/detail/{id}", "-1"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HauNN
     * Date create: 30/03/2023
     * Function: test id valid
     */
    @Test
    public void getInfoStudent_id_4() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/projects/detail/1", 1))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpectAll(
                        jsonPath("projectId").value(1),
                        jsonPath("projectName").value("Thiết kế ứng dụng đặt vé xem phim"),
                        jsonPath("projectContent").value("Thiết kế ứng dụng đặt vé xem phim"),
                        jsonPath("projectImg").value("https://cdn.pixabay.com/photo/2023/03/18/12/28/bonfire-7860562__340.jpg"),
                        jsonPath("projectDescription").value("starlight"),
                        jsonPath("projectStatus").value("true"));
    }
}
