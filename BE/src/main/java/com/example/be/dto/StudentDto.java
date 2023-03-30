package com.example.be.dto;

import com.example.be.model.Clazz;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class StudentDto implements Validator {

    private Long studentId;
    @NotBlank(message = "không được để trống")
//    @Max(value = 50,message = "Tên không được vượt quá 50 ký tự")
    private String studentName;

    @NotBlank(message ="không được để trống" )
    private String studentCode;

    @NotBlank(message = "không được để trống")
//    @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])\\/(0[1-9]|1[012])\\/\\d{2}$\n",message = "Ngày sinh phải theo thứ tự DD/MM/YY")
    private String dateOfBirth;

    @NotNull(message = "không được để trống")
    @Email(message = "Email không hợp lệ")
    private String email;

    @NotBlank(message = "không được để trống")
//    @Pattern(regexp = "^[0-9]+$ \n")
    private String phoneNumber;

    private boolean studentGender;

    private String studentAddress;

    private String img;

    private boolean flagDelete;

    private Clazz clazz;

    public StudentDto() {
    }

    public StudentDto(Long studentId, String studentName, String studentCode, String dateOfBirth, String email, String phoneNumber, boolean studentGender, String studentAddress, String img, boolean flagDelete, Clazz clazz) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentCode = studentCode;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.studentGender = studentGender;
        this.studentAddress = studentAddress;
        this.img = img;
        this.flagDelete = flagDelete;
        this.clazz = clazz;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isStudentGender() {
        return studentGender;
    }

    public void setStudentGender(boolean studentGender) {
        this.studentGender = studentGender;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public boolean isFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(boolean flagDelete) {
        this.flagDelete = flagDelete;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
    }
}