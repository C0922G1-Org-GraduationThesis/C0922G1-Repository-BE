package com.example.be;


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
public class ProjectRestController_getStudentList {
    @Autowired
    private MockMvc mockMvc;

    /**
     * this function use to test case Returns a list with size = 0
     *
     * @author NuongHT
     * @Time 9:12 30/03/2023
     */
    @Test
    public void getListStudent_5() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/projects/listPage?null&page=0"))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * this function use to test case Returns a list with size > 0
     *
     * @author NuongHT
     * @Time 9:12 30/03/2023
     */
    @Test
    public void getListStudent_6() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/projects/listPage?page=0"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(3))
                .andExpect(jsonPath("content[0].projectId").value("2"))
                .andExpect(jsonPath("content[0].projectName").value("Thiết kế an ninh mạng"))
                .andExpect(jsonPath("content[0].projectImg").value("https://i0.wp.com/kienviet.net/wp-content/uploads/2015/08/21.jpg?fit=1000%2C563&ssl=1"))
                .andExpect(jsonPath("content[0].team.teamName").value("Team 2"))

                .andExpect(jsonPath("content[1].projectId").value("3"))
                .andExpect(jsonPath("content[1].projectName").value("Thiết kế benh vien mạng cntt"))
                .andExpect(jsonPath("content[1].projectImg").value("https://i0.wp.com/kienviet.net/wp-content/uploads/2015/08/21.jpg?fit=1000%2C563&ssl=1"))
                .andExpect(jsonPath("content[1].team.teamName").value("Team 3"));

    }

}
