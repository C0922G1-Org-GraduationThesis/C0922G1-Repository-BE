package com.example.be.service;

import com.example.be.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IQuestionService {
    /**
     * Created by: LanTTN,
     * Date created : 30/03/2023
     * Function : find all question
     *
     * @param pageable
     */
    Page<Question> findAll(Pageable pageable);

    /**
     * Created by: LanTTN,
     * Date created : 30/03/2023
     * Function : save question
     *
     * @param questionContent, questionTopic, dateTime
     */
    void save(String questionContent, String questionTopic);
}
