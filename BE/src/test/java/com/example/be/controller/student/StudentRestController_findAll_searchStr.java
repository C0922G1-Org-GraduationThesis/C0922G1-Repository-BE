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
public class StudentRestController_findAll_searchStr {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Create by: HauNN
     * Date create: 30/03/2023
     * Function: test searchStr is null
     */
    @Test
    public void findAllStudent_7() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/students/?searchStr={searchStr}&page=0&size=2", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HauNN
     * Date create: 30/03/2023
     * Function: test searchStr is empty
     */
    @Test
    public void findAllStudent_8() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/students/?searchStr={searchStr}&page=0&size=2", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HauNN
     * Date create: 30/03/2023
     * Function: test searchStr invalid
     */
    @Test
    public void findAllStudent_9() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/students/?searchStr={searchStr}&page=0&size=2", "a123"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Create by: HauNN
     * Date create: 30/03/2023
     * Function: test searchStr valid
     */
    @Test
    public void findAllStudent_11() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/students/?searchStr=Doe&page=0&size=2"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpectAll(
                        jsonPath("totalPages").value(1),
                        jsonPath("totalElements").value(2),
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
                        jsonPath("content[0].flagLeader").value("false"),
                        jsonPath("content[1].studentId").value(2),
                        jsonPath("content[1].studentName").value("Jane Doe"),
                        jsonPath("content[1].studentCode").value("SV-003"),
                        jsonPath("content[1].studentDateOfBirth").value("01/01/2001"),
                        jsonPath("content[1].studentEmail").value("jane.doe@gmail.com"),
                        jsonPath("content[1].studentPhoneNumber").value("090001005"),
                        jsonPath("content[1].studentGender").value("false"),
                        jsonPath("content[1].studentAddress").value("Sơn Trà, Đà Nẵng"),
                        jsonPath("content[1].studentImg").value("profile3.png"),
                        jsonPath("content[1].flagDelete").value("false"),
                        jsonPath("content[1].flagLeader").value("true")
                );
    }
}
