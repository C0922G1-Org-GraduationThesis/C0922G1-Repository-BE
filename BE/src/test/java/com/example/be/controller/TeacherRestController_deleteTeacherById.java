package com.example.be.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TeacherRestController_deleteTeacherById {

    @Autowired
    private MockMvc mockMvc;

    /**
     * create by : HungPV ,
     * Date Create : 30/03/2023
     * Function : test delete teacher by id = null
     */
    @Test
    public void deleteTeacherById_id_1() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.delete(
                                "/api/teachers/delete/null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * create by : HungPV ,
     * Date Create : 30/03/2023
     * Function : test delete teacher by id = ''
     */
    @Test
    public void deleteTeacherById_id_2() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.delete(
                                "/api/teachers/delete/'' "))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * create by : HungPV ,
     * Date Create : 30/03/2023
     * Function : test delete teacher by id = 1000 not database
     */
    @Test
    public void deleteTeacherById_id_3() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.delete(
                                "/api/teachers/delete/1000 "))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * create by : HungPV ,
     * Date Create : 30/03/2023
     * Function : test delete teacher by id = 2 has in database
     */
    @Test
    public void deleteTeacherById_id_4() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.delete(
                                "/api/teachers/delete/2 "))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
