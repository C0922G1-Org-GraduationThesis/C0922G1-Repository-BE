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
public class TeamController_getAllInstructor {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAllInstructor_5() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/teams"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getAllInstructor_6() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/teams?page=0"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(6))
                .andExpect(jsonPath("content[0].teacher").value("Phạm Công Tiến"))
                .andExpect(jsonPath("content[0].total").value(1))
                .andExpect(jsonPath("content[4].teacher").value("Lê Thanh Dũng"))
                .andExpect(jsonPath("content[4].total").value(0));
    }
}
