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
public class ProjectRestController_findAll_size {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Create by: HauNN
     * Date create: 29/03/2023
     * Function: test size is null
     */
    @Test
    public void findAllProject_7() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/projects/?size={size}&searchName=thiết&page=0", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HauNN
     * Date create: 29/03/2023
     * Function: test size is empty
     */
    @Test
    public void findAllProject_8() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/projects/?size={size}&searchName=thiết&page=0",""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HauNN
     * Date create: 29/03/2023
     * Function: test size invalid
     */
    @Test
    public void findAllProject_9() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/projects/?size={size}&searchName=thiết&page=0","0"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HauNN
     * Date create: 30/03/2023
     * Function: test size valid
     */
    @Test
    public void findAllProject_11() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/projects/?searchName=thiết&size=5&page=0"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpectAll(
                        jsonPath("totalPages").value(1),
                        jsonPath("totalElements").value(2),
                        jsonPath("content[0].projectId").value(1),
                        jsonPath("content[0].projectName").value("Thiết kế ứng dụng đặt vé xem phim"),
                        jsonPath("content[0].projectContent").value("Thiết kế ứng dụng đặt vé xem phim"),
                        jsonPath("content[0].projectImg").value("https://cdn.pixabay.com/photo/2023/03/18/12/28/bonfire-7860562__340.jpg"),
                        jsonPath("content[0].projectDescription").value("starlight"),
                        jsonPath("content[0].projectStatus").value("true"),
                        jsonPath("content[1].projectId").value(5),
                        jsonPath("content[1].projectName").value("Thiết kế ứng dụng quản lý trường học"),
                        jsonPath("content[1].projectContent").value("Thiết kế ứng dụng quản lý trường học"),
                        jsonPath("content[1].projectImg").value( "https://cdn.pixabay.com/photo/2023/03/18/12/28/bonfire-7860562__340.jpg"),
                        jsonPath("content[1].projectDescription").value("Trường học"),
                        jsonPath("content[1].projectStatus").value("true"));
    }
 }
