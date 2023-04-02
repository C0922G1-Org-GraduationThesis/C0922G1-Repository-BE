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
public class ProjectRestController_pagingAndGetAllProject {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Created by: hoangNNH
     * Date created: 30/03/2023
     * This function use to test get list project has no parameter and size = 0
     */
    @Test
    public void pagingAndGetAllProject_5() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/projects/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: hoangNNH
     * Date created: 30/03/2023
     * This function use to test get list project has no parameter and size > 0
     */
    @Test
    public void pagingAndGetAllProject_6() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/projects?page=0"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(3))
                .andExpect(jsonPath("content[0].projectId").value(1))
                .andExpect(jsonPath("content[0].projectName").value("Thiết kế ứng dụng đặt vé xem phim"))
                .andExpect(jsonPath("content[0].projectContent").value("Thiết kế ứng dụng đặt vé xem phim"))
                .andExpect(jsonPath("content[0].projectImg").value("https://cdn.pixabay.com/photo/2023/03/18/12/28/bonfire-7860562__340.jpg"))
                .andExpect(jsonPath("content[0].projectDescription").value("starlight"))
                .andExpect(jsonPath("content[0].projectStatus").value(true))
                .andExpect(jsonPath("content[1].projectId").value(2))
                .andExpect(jsonPath("content[1].projectName").value("bến xe đà nẵng"))
                .andExpect(jsonPath("content[1].projectContent").value("Thiết kế ứng dụng quản lý nhà xe"))
                .andExpect(jsonPath("content[1].projectImg").value("https://cdn.pixabay.com/photo/2023/03/18/12/28/bonfire-7860562__340.jpg"))
                .andExpect(jsonPath("content[1].projectDescription").value("bến xe"))
                .andExpect(jsonPath("content[1].projectStatus").value(true));
    }

    /**
     * Created by: hoangNNH
     * Date created: 30/03/2023
     * This function use to test get list project has page=0 & name=null
     */
    @Test
    public void pagingAndGetAllProject_7() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/projects?page=0&name=null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    /**
     * Created by: hoangNNH
     * Date created: 30/03/2023
     * This function use to test get list project has page=null & name=web
     */
    @Test
    public void pagingAndGetAllProject_7_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/projects?page=null&name=web"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: hoangNNH
     * Date created: 30/03/2023
     * This function use to test get list project has page=0 & name=
     */
    @Test
    public void pagingAndGetAllProject_8() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/projects?name=&page=0"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
    /**
     * Created by: hoangNNH
     * Date created: 30/03/2023
     * This function use to test get list project has page= & name=web
     */
    @Test
    public void pagingAndGetAllProject_8_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/projects?name=web&page="))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: hoangNNH
     * Date created: 30/03/2023
     * This function use to test get list project has name=web & page=0
     */
    @Test
    public void pagingAndGetAllProject_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/projects?name=web&page=0"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
