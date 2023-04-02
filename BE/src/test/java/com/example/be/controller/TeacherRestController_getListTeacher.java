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
public class TeacherRestController_getListTeacher {

    @Autowired
    private MockMvc mockMvc;


    /**
     * create by : HungPV ,
     * Date Create : 30/03/2023
     * Function : test get all teacher has name = null and page = 0
     */
    @Test
    public void getAllTeacher_7_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/teachers/list?name=null&page=0"))
                .andDo(print())
                .andExpect(status().is4xxClientError());


    }

    /**
     * create by : HungPV ,
     * Date Create : 30/03/2023
     * Function : test get all teacher has name = '' and page = null
     */
    @Test
    public void getAllTeacher_7_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/teachers/list?name=&page=null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());


    }

    /**
     * create by : HungPV ,
     * Date Create : 30/03/2023
     * Function : test get all teacher has name = null and page = null
     */
    @Test
    public void getAllTeacher_7_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/teachers/list?name=null&page=null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * create by : HungPV ,
     * Date Create : 30/03/2023
     * Function : test get all teacher has name = '' and page = 0
     */
    @Test
    public void getAllTeacher_8() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/teachers/list?name=&page=0"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(8))
                .andExpect(jsonPath("content[0].teacherId").value(2))
                .andExpect(jsonPath("content[0].teacherPhoneNumber").value("0934256789"))
                .andExpect(jsonPath("content[0].teacherCode").value("GV-002"))
                .andExpect(jsonPath("content[0].teacherEmail").value("huong@gmail.com"))
                .andExpect(jsonPath("content[0].teacherName").value("Nguyễn Thị Hương"))
                .andExpect(jsonPath("content[0].teacherImg").value("def"))
                .andExpect(jsonPath("content[0].faculty").value("Xây dựng"))
                .andExpect(jsonPath("content[0].degree").value("Thạc sĩ"))
                .andExpect(jsonPath("content[7].teacherId").value(9))
                .andExpect(jsonPath("content[7].teacherPhoneNumber").value("0987123459"))
                .andExpect(jsonPath("content[7].teacherCode").value("GV-009"))
                .andExpect(jsonPath("content[7].teacherEmail").value("tam@gmail.com"))
                .andExpect(jsonPath("content[7].teacherName").value("Trần Thanh Tâm"))
                .andExpect(jsonPath("content[7].teacherImg").value("jkl"))
                .andExpect(jsonPath("content[7].faculty").value("Tài chính"))
                .andExpect(jsonPath("content[7].degree").value("Cao đẳng"));
    }

    /**
     * create by : HungPV ,
     * Date Create : 30/03/2023
     * Function : test get all teacher has name = 1256 not database and page = 0
     */
    @Test
    public void getAllTeacher_9() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/teachers/list?name=1256&page=0"))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * create by : HungPV ,
     * Date Create : 30/03/2023
     * Function : test get all teacher has name = '' and page = 2 not database,
     */
    @Test
    public void getAllTeacher_10() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/teachers/list?name=&page=2"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * create by : HungPV ,
     * Date Create : 30/03/2023
     * Function : test get one teacher has name = Đạt'' and page = '',
     */
    @Test
    public void getAllTeacher_11() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/teachers/list?name=Đạt&page="))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(1))
                .andExpect(jsonPath("content[0].teacherId").value(3))
                .andExpect(jsonPath("content[0].teacherPhoneNumber").value("0978521346"))
                .andExpect(jsonPath("content[0].teacherCode").value("GV-003"))
                .andExpect(jsonPath("content[0].teacherEmail").value("datnguyen@gmail.com"))
                .andExpect(jsonPath("content[0].teacherName").value("Nguyễn Thanh Đạt"))
                .andExpect(jsonPath("content[0].teacherImg").value("ghi"))
                .andExpect(jsonPath("content[0].faculty").value("Điện tử viễn thông"))
                .andExpect(jsonPath("content[0].degree").value("Đại học"));
    }
}
