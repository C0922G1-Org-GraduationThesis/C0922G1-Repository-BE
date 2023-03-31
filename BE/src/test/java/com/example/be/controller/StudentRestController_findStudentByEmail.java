package com.example.be.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 * Created by:TienP
 * Date: 29/03/2023
 */

@SpringBootTest
@AutoConfigureMockMvc
public class StudentRestController_findStudentByEmail {
    @Autowired
    private MockMvc mockMvc;

    //[email] = null
    @Test
    public void findStudentByEmail_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/public/students/detail/{email}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //[email] = rỗng ("")
    @Test
    public void findStudentByEmail_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/public/students/detail/{email}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //[email] không tồn tại trong DB
    @Test
    public void findStudentByEmail_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/public/students/detail/{email}", "tien1234@gmail.com"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //[email] tồn tại trong DB
    @Test
    public void findTeacherByEmail_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/public/students/detail/{email}", "phanvana@gmail.com"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
