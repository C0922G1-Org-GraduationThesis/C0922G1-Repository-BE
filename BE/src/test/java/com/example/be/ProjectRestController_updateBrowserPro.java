package com.example.be;

import com.example.be.model.Project;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProjectRestController_updateBrowserPro {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * this function use to test param check equal null.
     *
     * @author NuongHT
     * @Time 9:12 30/03/2023
     */
    @Test
    public void updateBrowserPro_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.put("/api/projects/browser/{projectId}", "null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function use to test check equal empty parameter.
     *
     * @author NuongHT
     * @Time 9:12 30/03/2023
     */
    @Test
    public void updateBrowserPro_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.put("/api/projects/browser/{projectId}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * this function use to test check parram not exist in database.
     *
     * @author NuongHT
     * @Time 9:12 30/03/2023
     */
    @Test
    public void updateBrowserPro_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.put("/api/projects/browser/{projectId}", "100"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * this function use to test check parram exist in database.
     *
     * @author NuongHT
     * @Time 9:12 30/03/2023
     */
    @Test
    public void updateBrowserPro_4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.put("/api/projects/browser/{projectId}", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }



    /**
     * this function use to test check parram exist in database and update status topic.
     *
     * @author NuongHT
     * @Time 9:12 30/03/2023
     */
    @Test
    public void updateBrowserPro_24() throws Exception {
        Project project = new Project();
        project.setProjectStatus(true);

        this.mockMvc.perform(
                        MockMvcRequestBuilders.put("/api/projects/browser/{projectId}", "1")
                                .content(this.objectMapper.writeValueAsString(project))
                                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}
