package com.example.be.dto;

import com.example.be.model.Faculty;

/**
 *create by : HungPV ,
 * Date Create : 29/03/2023
 * Function : ITeacherDto
 * @return method getter
 */
public interface ITeacherDto {
    Long getTeacherId();
    String getTeacherName();
    String getTeacherCode();
    String getTeacherImg();
    String getTeacherPhoneNumber();
    String getTeacherEmail();
    String getTeacherAddress();
    String getTeacherDateOfBirth();
    String getTeacherGender();
    String getFaculty();
    String getDegree();
    int getDegreeId();
    String getDegreeName();
    int getFacultyId();
    String getFacultyName();
}
