package com.example.be.controller;

import com.example.be.dto.AnswerDto;
import com.example.be.dto.QuestionDto;
import com.example.be.dto.StudentDto;
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
public class QuestionRestController_saveQuestion {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Created by: LanTTN
     * Date created : 30/03/2023
     * Function: test save question
     * when questionTopic == null
     *
     * @throws Exception
     */
    @Test
    public void saveQuestion_questionTopic_13() throws Exception {
        QuestionDto questionDto = new QuestionDto();
        questionDto.setQuestionContent("Cho em hỏi cái này với ạ?");
        questionDto.setDateTime("2023-02-02");

        StudentDto studentDto = new StudentDto();
        studentDto.setStudentId(1L);
        questionDto.setStudent(studentDto);

        AnswerDto answerDto = new AnswerDto();
        answerDto.setAnswerId(1L);
        questionDto.setAnswers(answerDto);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/questions/save-question")
                        .content(this.objectMapper.writeValueAsString(questionDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * Created by: LanTTN
     * Date created : 30/03/2023
     * Function: test save question
     * when questionTopic == ""
     *
     * @throws Exception
     */
    @Test
    public void saveQuestion_questionTopic_14() throws Exception {
        QuestionDto questionDto = new QuestionDto();
        questionDto.setQuestionTopic("");
        questionDto.setQuestionContent("Cho em hỏi cái này với ạ?");
        questionDto.setDateTime("2023-02-02");

        StudentDto studentDto = new StudentDto();
        studentDto.setStudentId(1L);
        questionDto.setStudent(studentDto);

        AnswerDto answerDto = new AnswerDto();
        answerDto.setAnswerId(1L);
        questionDto.setAnswers(answerDto);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/questions/save-question")
                        .content(this.objectMapper.writeValueAsString(questionDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * Created by: LanTTN
     * Date created : 30/03/2023
     * Function: test save question
     * when questionTopic < min
     *
     * @throws Exception
     */
    @Test
    public void saveQuestion_questionTopic_16() throws Exception {
        QuestionDto questionDto = new QuestionDto();
        questionDto.setQuestionTopic("abc");
        questionDto.setQuestionContent("Cho em hỏi cái này với ạ?");
        questionDto.setDateTime("2023-02-02");

        StudentDto studentDto = new StudentDto();
        studentDto.setStudentId(1L);
        questionDto.setStudent(studentDto);

        AnswerDto answerDto = new AnswerDto();
        answerDto.setAnswerId(1L);
        questionDto.setAnswers(answerDto);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/questions/save-question")
                        .content(this.objectMapper.writeValueAsString(questionDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * Created by: LanTTN
     * Date created : 30/03/2023
     * Function: test save question
     * when all item
     *
     * @throws Exception
     */
    @Test
    public void saveQuestion_questionTopic_18() throws Exception {
        QuestionDto questionDto = new QuestionDto();
        questionDto.setQuestionTopic("Giai đoạn 1");
        questionDto.setQuestionContent("Cho em hỏi cái này với ạ?");
        questionDto.setDateTime("2023-02-02 15:22:34");

        StudentDto studentDto = new StudentDto();
        studentDto.setStudentId(1L);
        questionDto.setStudent(studentDto);

        AnswerDto answerDto = new AnswerDto();
        answerDto.setAnswerId(1L);
        questionDto.setAnswers(answerDto);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/questions/save-question")
                        .content(this.objectMapper.writeValueAsString(questionDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * Created by: LanTTN
     * Date created : 30/03/2023
     * Function: test save question
     * when question content == null
     *
     * @throws Exception
     */
    @Test
    public void saveQuestion_questionContent_13() throws Exception {
        QuestionDto questionDto = new QuestionDto();
        questionDto.setQuestionTopic("Giai đoạn 1");
        questionDto.setDateTime("2023-02-02");

        StudentDto studentDto = new StudentDto();
        studentDto.setStudentId(1L);
        questionDto.setStudent(studentDto);

        AnswerDto answerDto = new AnswerDto();
        answerDto.setAnswerId(1L);
        questionDto.setAnswers(answerDto);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/questions/save-question")
                        .content(this.objectMapper.writeValueAsString(questionDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * Created by: LanTTN
     * Date created : 30/03/2023
     * Function: test save question
     * when question content == ""
     *
     * @throws Exception
     */
    @Test
    public void saveQuestion_questionContent_14() throws Exception {
        QuestionDto questionDto = new QuestionDto();
        questionDto.setQuestionTopic("Giai đoạn 1");
        questionDto.setQuestionContent("");
        questionDto.setDateTime("2023-02-02 15:22:34");

        StudentDto studentDto = new StudentDto();
        studentDto.setStudentId(1L);
        questionDto.setStudent(studentDto);

        AnswerDto answerDto = new AnswerDto();
        answerDto.setAnswerId(1L);
        questionDto.setAnswers(answerDto);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/questions/save-question")
                        .content(this.objectMapper.writeValueAsString(questionDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * Created by: LanTTN
     * Date created : 30/03/2023
     * Function: test save question
     * when question content < min
     *
     * @throws Exception
     */
    @Test
    public void saveQuestion_questionContent_16() throws Exception {
        QuestionDto questionDto = new QuestionDto();
        questionDto.setQuestionTopic("Giai đoạn 1");
        questionDto.setQuestionContent("abc");
        questionDto.setDateTime("2023-02-02");

        StudentDto studentDto = new StudentDto();
        studentDto.setStudentId(1L);
        questionDto.setStudent(studentDto);

        AnswerDto answerDto = new AnswerDto();
        answerDto.setAnswerId(1L);
        questionDto.setAnswers(answerDto);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/questions/save-question")
                        .content(this.objectMapper.writeValueAsString(questionDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * Created by: LanTTN
     * Date created : 30/03/2023
     * Function: test save question
     * when question content > max
     *
     * @throws Exception
     */
    @Test
    public void saveQuestion_questionContent_17() throws Exception {
        QuestionDto questionDto = new QuestionDto();
        questionDto.setQuestionTopic("Giai đoạn 1");
        questionDto.setQuestionContent("Trong quá trình xây dựng một công trình lớn, bạn đã phải đối mặt với những thách thức gì và cách bạn đã vượt qua chúng?");
        questionDto.setDateTime("2023-02-02");

        StudentDto studentDto = new StudentDto();
        studentDto.setStudentId(1L);
        questionDto.setStudent(studentDto);

        AnswerDto answerDto = new AnswerDto();
        answerDto.setAnswerId(1L);
        questionDto.setAnswers(answerDto);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/questions/save-question")
                        .content(this.objectMapper.writeValueAsString(questionDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * Created by: LanTTN
     * Date created : 30/03/2023
     * Function: test save question
     * when all item valid
     *
     * @throws Exception
     */
    @Test
    public void saveQuestion_questionContent_18() throws Exception {
        QuestionDto questionDto = new QuestionDto();
        questionDto.setQuestionTopic("Giai đoạn 1");
        questionDto.setQuestionContent("Cột tròn khác gì cột chữ nhật ạ");
        questionDto.setDateTime("2023-03-22 12:22:22");

        StudentDto studentDto = new StudentDto();
        studentDto.setStudentId(1L);
        questionDto.setStudent(studentDto);

        AnswerDto answerDto = new AnswerDto();
        answerDto.setAnswerId(1L);
        questionDto.setAnswers(answerDto);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/questions/save-question")
                        .content(this.objectMapper.writeValueAsString(questionDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

    }
}
