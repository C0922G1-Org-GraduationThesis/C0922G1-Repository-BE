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
public class TeacherRestController_getTeacherById {
    @Autowired
    private MockMvc mockMvc;

    /**
     * create by : HungPV ,
     * Date Create : 30/03/2023
     * Function : test get teacher by id = null
     *
     * @return error 404 Not Found
     */
    @Test
    public void getTeacherById_id_1() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/teachers/list/null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * create by : HungPV ,
     * Date Create : 30/03/2023
     * Function : test get teacher by id = ''
     *
     * @return error 404 Not Found
     */
    @Test
    public void getTeacherById_id_2() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/teachers/list/'' "))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * create by : HungPV ,
     * Date Create : 30/03/2023
     * Function : test get teacher by id = 1000 not database
     *
     * @return error 404 Not Found
     */
    @Test
    public void getTeacherById_id_3() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/teachers/list/1000 "))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * create by : HungPV ,
     * Date Create : 30/03/2023
     * Function : test get teacher by id = 3 has in database
     *
     * @return 200 OK
     */
    @Test
    public void getTeacherById_id_4() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/api/teachers/list/3"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpectAll(
                        jsonPath("teacherId").value(3),
                        jsonPath("teacherPhoneNumber").value("0978521346"),
                        jsonPath("faculty").value("Điện tử viễn thông"),
                        jsonPath("teacherImg").value("ghi"),
                        jsonPath("degree").value("Đại học"),
                        jsonPath("teacherName").value("Nguyễn Thanh Đạt"),
                        jsonPath("teacherEmail").value("datnguyen@gmail.com"),
                        jsonPath("teacherCode").value("GV-003"));
    }
}
