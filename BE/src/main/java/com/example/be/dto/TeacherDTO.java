package com.example.be.dto;

import com.example.be.model.*;

import java.util.Set;

public class TeacherDTO {
    private Long teacherId;
    private String teacherCode;
    private String teacherName;
    private String dateOfBirth;
    private String email;
    private String phoneNumber;
    private boolean teacherGender;
    private String teacherAddress;
    private String img;
    private boolean flagDelete;
    private Faculty faculty;
    private Degree degree;
    private Account account;
    private Team team;
    private Set<NotificationTeacher> notificationTeacherSet;
    private Clazz clazz;
    private Set<Document> documentSet;

}
