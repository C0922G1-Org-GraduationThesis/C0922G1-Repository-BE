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
public class AnswerRestController_showAnswer {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Created by: LanTTN
     * Date created : 30/03/2023
     * Function: test find all answer
     * when don't have data
     *
     * @throws Exception
     */
    @Test
    public void showAnswer_questionId_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/answers"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: LanTTN
     * Date created : 30/03/2023
     * Function: test find all answer
     * when id == ""
     *
     * @throws Exception
     */
    @Test
    public void showAnswer_questionId_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/answers?questionId="))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: LanTTN
     * Date created : 30/03/2023
     * Function: test find all answer
     * when don't have id in data
     *
     * @throws Exception
     */
    @Test
    public void showAnswer_questionId_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/answers?questionId=5"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: LanTTN
     * Date created : 30/03/2023
     * Function: test item first in all answer
     * when have data
     *
     * @throws Exception
     */
    @Test
    public void showAnswer_questionId_4_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/answers?questionId=1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$[0].answerId").value(1L))
                .andExpect(jsonPath("$[0].answerContent").value("Chưa đúng yêu cầu"))
                .andExpect(jsonPath("$[0].dateTime").value("2023-2-22 12:22:23"))
                .andExpect(jsonPath("$[0].teacher.teacherId").value(1))
                .andExpect(jsonPath("$[0].question.questionId").value(1));
    }

    /**
     * Created by: LanTTN
     * Date created : 30/03/2023
     * Function: test item last in all answer
     * when have data
     *
     * @throws Exception
     */
    @Test
    public void showAnswer_questionId_4_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/answers?questionId=1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$[-1].answerId").value(3L))
                .andExpect(jsonPath("$[-1].answerContent").value("Chưa đúng yêu cầu"))
                .andExpect(jsonPath("$[-1].dateTime").value("2023-2-22 16:22:23"))
                .andExpect(jsonPath("$[-1].teacher.teacherId").value(1))
                .andExpect(jsonPath("$[-1].question.questionId").value(4));;
    }

}
