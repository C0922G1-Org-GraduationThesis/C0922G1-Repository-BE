package com.example.be.controller;

import com.example.be.dto.AnswerDto;
import com.example.be.dto.QuestionDto;
import com.example.be.dto.TeacherDto;
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
public class AnswerRestController_saveAnswer {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Created by: LanTTN
     * Date created : 30/03/2023
     * Function: test save answer
     * when answer content == null
     *
     * @throws Exception
     */
    @Test
    public void saveAnswer_answerContent_13() throws Exception {
        AnswerDto answerDto = new AnswerDto();

        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setTeacherId(1L);
        answerDto.setTeacher(teacherDto);

        QuestionDto questionDto = new QuestionDto();
        questionDto.setQuestionId(1L);
        answerDto.setQuestion(questionDto);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/answers/save-answer")
                        .content(this.objectMapper.writeValueAsString(questionDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * Created by: LanTTN
     * Date created : 30/03/2023
     * Function: test save answer
     * when answer content == ""
     *
     * @throws Exception
     */
    @Test
    public void saveAnswer_answerContent_14() throws Exception {
        AnswerDto answerDto = new AnswerDto();
        answerDto.setAnswerContent("");

        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setTeacherId(1L);
        answerDto.setTeacher(teacherDto);

        QuestionDto questionDto = new QuestionDto();
        questionDto.setQuestionId(1L);
        answerDto.setQuestion(questionDto);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/answers/save-answer")
                        .content(this.objectMapper.writeValueAsString(questionDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * Created by: LanTTN
     * Date created : 30/03/2023
     * Function: test save answer
     * when answer content < min
     *
     * @throws Exception
     */
    @Test
    public void saveAnswer_answerContent_16() throws Exception {
        AnswerDto answerDto = new AnswerDto();
        answerDto.setAnswerContent("abc");

        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setTeacherId(1L);
        answerDto.setTeacher(teacherDto);

        QuestionDto questionDto = new QuestionDto();
        questionDto.setQuestionId(1L);
        answerDto.setQuestion(questionDto);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/answers/save-answer")
                        .content(this.objectMapper.writeValueAsString(questionDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * Created by: LanTTN
     * Date created : 30/03/2023
     * Function: test save answer
     * when answer content > max
     *
     * @throws Exception
     */
    @Test
    public void saveAnswer_answerContent_17() throws Exception {
        AnswerDto answerDto = new AnswerDto();
        answerDto.setAnswerContent("Cột tròn khác cột chữ nhật ở chỗ là hình dáng, cách bố trí thép dọc. Cột tròn chịu lực nén từ trong ra ngoài.");

        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setTeacherId(1L);
        answerDto.setTeacher(teacherDto);

        QuestionDto questionDto = new QuestionDto();
        questionDto.setQuestionId(1L);
        answerDto.setQuestion(questionDto);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/answers/save-answer")
                        .content(this.objectMapper.writeValueAsString(questionDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * Created by: LanTTN
     * Date created : 30/03/2023
     * Function: test save answer
     * when all item valid
     *
     * @throws Exception
     */
    @Test
    public void saveAnswer_answerContent_18() throws Exception {
        AnswerDto answerDto = new AnswerDto();
        answerDto.setAnswerContent("Cột tròn khác cột chữ nhật ở chỗ là hình dáng");

        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setTeacherId(1L);
        answerDto.setTeacher(teacherDto);

        QuestionDto questionDto = new QuestionDto();
        questionDto.setQuestionId(1L);
        answerDto.setQuestion(questionDto);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/answers/save-answer")
                        .content(this.objectMapper.writeValueAsString(questionDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
