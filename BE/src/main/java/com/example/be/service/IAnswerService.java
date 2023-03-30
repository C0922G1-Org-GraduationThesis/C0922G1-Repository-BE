package com.example.be.service;

import com.example.be.model.Answers;

import java.util.List;

public interface IAnswerService {
    /**
     * Created by: LanTTN,
     * Date created : 30/03/2023
     * Function : find all answer
     *
     * @param questionId
     */
    List<Answers> findAll(Integer questionId);

    /**
     * Created by: LanTTN,
     * Date created : 30/03/2023
     * Function : save question
     *
     * @param answerContent, questionId, teacherId
     */
    void save(String answerContent, Long questionId, Long teacherId);
}
