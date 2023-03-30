package com.example.be.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class QuestionDto {
    private Long questionId;
    @NotBlank
    @Size(min = 5)
    private String questionTopic;
    @NotBlank
    @Size(min = 5, max = 100)
    private String questionContent;

    private String dateTime;
    private StudentDto student;
    private AnswerDto answers;

    public QuestionDto() {
    }

    public StudentDto getStudent() {
        return student;
    }

    public void setStudent(StudentDto student) {
        this.student = student;
    }

    public AnswerDto getAnswers() {
        return answers;
    }

    public void setAnswers(AnswerDto answers) {
        this.answers = answers;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getQuestionTopic() {
        return questionTopic;
    }

    public void setQuestionTopic(String questionTopic) {
        this.questionTopic = questionTopic;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
