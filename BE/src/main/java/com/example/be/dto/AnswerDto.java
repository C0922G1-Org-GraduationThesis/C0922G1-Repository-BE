package com.example.be.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AnswerDto {
    private Long answerId;
    @NotBlank
    @Size(min = 5,max = 100)
    private String answerContent;
    private String dateTime;
    private TeacherDto teacher;
    private QuestionDto question;

    public AnswerDto() {
    }

    public Long getAnswerId(long l) {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    public TeacherDto getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherDto teacher) {
        this.teacher = teacher;
    }

    public Long getAnswerId() {
        return answerId;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public QuestionDto getQuestion() {
        return question;
    }

    public void setQuestion(QuestionDto question) {
        this.question = question;
    }
}
