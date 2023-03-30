package com.example.be.controller;

import com.example.be.model.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class QuestionRestController_showQuestion {

    @Autowired
    private QuestionRestController questionRestController;

    @Autowired
    private MockMvc mockMvc;

    /**
     * Created by: LanTTN
     * Date created : 30/03/2023
     * Function: test find all question
     * when don't have data
     *
     * @throws Exception
     */
    @Test
    public void showQuestion_5() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/questions/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: LanTTN
     * Date created : 30/03/2023
     * Function: test find first question in page = 0 and element first
     * when have data
     *
     * @throws Exception
     */
    @Test
    public void showQuestion_6_firstPage_lastElement() throws Exception {
        ResponseEntity<Page<Question>> responseEntity =
                this.questionRestController.showQuestion(PageRequest.of(0, 1));
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(4, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(4, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("Khi chọn loại nền móng căn cứ vào những yếu tố nào ạ?",
                responseEntity.getBody().getContent().get(0).getQuestionContent());
        Assertions.assertEquals("Giai đoạn 1",
                responseEntity.getBody().getContent().get(0).getQuestionTopic());
    }

    /**
     * Created by: LanTTN
     * Date created : 30/03/2023
     * Function: test find first question in page = 3 and element last
     * when have data
     *
     * @throws Exception
     */
    @Test
    public void showQuestion_6_lastPage_lastElement() throws Exception {
        ResponseEntity<Page<Question>> responseEntity =
                this.questionRestController.showQuestion(PageRequest.of(3, 1));
        Assertions.assertEquals(200, responseEntity.getStatusCodeValue());
        Assertions.assertEquals(4, responseEntity.getBody().getTotalPages());
        Assertions.assertEquals(4, responseEntity.getBody().getTotalElements());
        Assertions.assertEquals("Nên chọn loại hình nghệ thuật nào cho ứng dụng?",
                responseEntity.getBody().getContent().get(responseEntity.getBody().getNumberOfElements() - 1).getQuestionContent());
        Assertions.assertEquals("Giai đoạn 4",
                responseEntity.getBody().getContent().get(responseEntity.getBody().getNumberOfElements() - 1).getQuestionTopic());
    }
}

