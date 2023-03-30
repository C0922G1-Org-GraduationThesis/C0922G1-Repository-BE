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
public class ProgressRestController_getListProgressProject {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getListProgressProject_5() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/progress/lit","")).andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Danh sach rong,..
     * @throws Exception
     */
    @Test
    public void getListProgressProject_6() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/progress/list?page=0","")).andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(1))
                .andExpect(jsonPath("content[0].projectId").value(1))
                .andExpect(jsonPath("content[0].teamName").value("FB09"))
                .andExpect(jsonPath("content[0].projectName").value("Thiết kế ứng dụng đặt vé xem phim"))
                .andExpect(jsonPath("content[0].memberTotal").value(4));
    }

    /**
     * Danh sach rong,..
     * @throws Exception
     */


}
