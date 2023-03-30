package com.example.be.controller.student;

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
public class StudentRestController_findByTeamId_size {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Create by: HauNN
     * Date create: 30/03/2023
     * Function: test size is null
     */
    @Test
    public void findAllStudentByTeamId_7() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/students/team/1&page=0&size={size}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HauNN
     * Date create: 30/03/2023
     * Function: test size is empty
     */
    @Test
    public void findAllStudentByTeamId_8() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/students/team/1&page=0&size={size}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HauNN
     * Date create: 30/03/2023
     * Function: test size invalid
     */
    @Test
    public void findAllStudentByTeamId_9() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/students/team/1&page=0&size={size}", "-2"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HauNN
     * Date create: 30/03/2023
     * Function: test size is does not exist in database
     */
    @Test
    public void findAllStudentByTeamId_10() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/students/team/1&page=0&size={size}", "1000000000000"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HauNN
     * Date create: 30/03/2023
     * Function: test size valid
     */
    @Test
    public void findAllStudentByTeamId_11() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/students/team/1?page=0&size=2"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpectAll(
                        jsonPath("totalPages").value(1),
                        jsonPath("totalElements").value(1),
                        jsonPath("content[0].studentId").value(1),
                        jsonPath("content[0].studentName").value("John Doe"),
                        jsonPath("content[0].studentCode").value("SV-002"),
                        jsonPath("content[0].studentDateOfBirth").value("15/03/2002"),
                        jsonPath("content[0].studentEmail").value("john.doe@gmail.com"),
                        jsonPath("content[0].studentPhoneNumber").value("090001004"),
                        jsonPath("content[0].studentGender").value("true"),
                        jsonPath("content[0].studentAddress").value("Thanh Khê, Đà Nẵng"),
                        jsonPath("content[0].studentImg").value("profile2.png"),
                        jsonPath("content[0].flagDelete").value("false"),
                        jsonPath("content[0].flagLeader").value("false")
                );
    }
}
