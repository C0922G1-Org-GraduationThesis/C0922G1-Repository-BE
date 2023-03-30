package com.example.be.dto;

import com.example.be.model.Stage;

public class ProgressStudentDto {
    private String studentName;
    private String studentEmail;
    private String studentPhoneNumber;
    private String studentImg;

    private ProjectDTO projectDTO;
    private Stage stage;

    public ProgressStudentDto(String studentName, String studentEmail, String studentPhoneNumber, String studentImg) {
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.studentPhoneNumber = studentPhoneNumber;
        this.studentImg = studentImg;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentPhoneNumber() {
        return studentPhoneNumber;
    }

    public void setStudentPhoneNumber(String studentPhoneNumber) {
        this.studentPhoneNumber = studentPhoneNumber;
    }

    public String getStudentImg() {
        return studentImg;
    }

    public void setStudentImg(String studentImg) {
        this.studentImg = studentImg;
    }
}
