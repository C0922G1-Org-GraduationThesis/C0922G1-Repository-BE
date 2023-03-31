package com.example.be.dto.teacher;

import com.example.be.model.Degree;
import com.example.be.model.Faculty;
import org.springframework.validation.Errors;

import java.util.List;

public class TeacherDTO {
    private Long teacherId;
    private String teacherCode;
    private String teacherName;
    private String teacherDateOfBirth;
    private String teacherEmail;
    private String teacherPhoneNumber;
    private boolean teacherGender;
    private String teacherAddress;
    private String teacherImg;
    private Faculty faculty;
    private Degree degree;

    public TeacherDTO(String teacherCode, String teacherName, String teacherDateOfBirth, String teacherEmail, String teacherPhoneNumber, boolean teacherGender, String teacherAddress, String teacherImg, Faculty faculty, Degree degree) {
        this.teacherCode = teacherCode;
        this.teacherName = teacherName;
        this.teacherDateOfBirth = teacherDateOfBirth;
        this.teacherEmail = teacherEmail;
        this.teacherPhoneNumber = teacherPhoneNumber;
        this.teacherGender = teacherGender;
        this.teacherAddress = teacherAddress;
        this.teacherImg = teacherImg;
        this.faculty = faculty;
        this.degree = degree;
    }

    public TeacherDTO(Long teacherId, String teacherCode, String teacherName, String teacherDateOfBirth, String teacherEmail, String teacherPhoneNumber, boolean teacherGender, String teacherAddress, String teacherImg, Faculty faculty, Degree degree) {
        this.teacherId = teacherId;
        this.teacherCode = teacherCode;
        this.teacherName = teacherName;
        this.teacherDateOfBirth = teacherDateOfBirth;
        this.teacherEmail = teacherEmail;
        this.teacherPhoneNumber = teacherPhoneNumber;
        this.teacherGender = teacherGender;
        this.teacherAddress = teacherAddress;
        this.teacherImg = teacherImg;
        this.faculty = faculty;
        this.degree = degree;
    }

    public TeacherDTO() {
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherCode() {
        return teacherCode;
    }

    public void setTeacherCode(String teacherCode) {
        this.teacherCode = teacherCode;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherDateOfBirth() {
        return teacherDateOfBirth;
    }

    public void setTeacherDateOfBirth(String teacherDateOfBirth) {
        this.teacherDateOfBirth = teacherDateOfBirth;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
    }

    public String getTeacherPhoneNumber() {
        return teacherPhoneNumber;
    }

    public void setTeacherPhoneNumber(String teacherPhoneNumber) {
        this.teacherPhoneNumber = teacherPhoneNumber;
    }

    public boolean isTeacherGender() {
        return teacherGender;
    }

    public void setTeacherGender(boolean teacherGender) {
        this.teacherGender = teacherGender;
    }

    public String getTeacherAddress() {
        return teacherAddress;
    }

    public void setTeacherAddress(String teacherAddress) {
        this.teacherAddress = teacherAddress;
    }

    public String getTeacherImg() {
        return teacherImg;
    }

    public void setTeacherImg(String teacherImg) {
        this.teacherImg = teacherImg;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public void checkValidateCreateTeacher(List<IEmailAndPhoneNumberDTO> list, TeacherDTO teacherDTO, Errors errors) {
        if (teacherDTO.getTeacherName().matches("")) {
            errors.rejectValue("teacherName", "teacherName", "Tên giáo viên không được để trống");
        } else {
            int minLength = teacherDTO.getTeacherName().length();
            int maxLength = teacherDTO.getTeacherName().length();
            if (minLength <= 1 || maxLength >= 50) {
                errors.rejectValue("teacherName", "teacherName", "Tên giáo viên phải nằm trong khoảng 1->50 kí tự");
            }
        }

        if (teacherDTO.getTeacherDateOfBirth().matches("")) {
            errors.rejectValue("dateOfBirth", "dateOfBirth", "Ngày sinh không được để trống");
        }

        if (teacherDTO.getDegree().getDegreeName().matches("")) {
            errors.rejectValue("degree", "degree", "Học vị không được để trống");
        }

        if (teacherDTO.getTeacherAddress().matches("")) {
            errors.rejectValue("teacherAddress", "teacherAddress", "Địa chỉ không được để trống");
        }

        if (teacherDTO.getTeacherPhoneNumber().matches("")) {
            errors.rejectValue("phoneNumber", "phoneNumber", "Số điện thoại không được để trống");
        } else if (!teacherDTO.getTeacherPhoneNumber().matches("[0][1-9]{9}")) {
            errors.rejectValue("phoneNumber", "phoneNumber", "Số điện thoại bắt đầu bằng 0 và phải có 10 số");
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (teacherDTO.getTeacherPhoneNumber().equals(list.get(i).getPhoneNumber())) {
                    errors.rejectValue("phoneNumber", "phoneNumber", "Số điện thoại đã được sử dụng");
                    break;
                }
            }
        }

        if (teacherDTO.getFaculty() == null) {
            errors.rejectValue("faculty", "faculty", "Học vị không được để trống");
        }

        if (teacherDTO.getTeacherEmail().matches("")) {
            errors.rejectValue("email", "email", "Email không được để trống");
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (teacherDTO.getTeacherEmail().equals(list.get(i).getEmail())) {
                    errors.rejectValue("email", "email", "Email đã được sử dụng");
                    break;
                }
            }
        }
    }

    public void checkValidateUpdateTeacher(List<IEmailAndPhoneNumberDTO> list, TeacherDTO teacherDTO, Errors errors) {
        if (teacherDTO.getTeacherName().matches("")) {
            errors.rejectValue("teacherName", "teacherName", "Tên giáo viên không được để trống");
        }

        if (teacherDTO.getTeacherDateOfBirth().matches("")) {
            errors.rejectValue("dateOfBirth", "dateOfBirth", "Ngày sinh không được để trống");
        }

        if (teacherDTO.getDegree().getDegreeName().matches("")) {
            errors.rejectValue("degree", "degree", "Học vị không được để trống");
        }

        if (teacherDTO.getTeacherAddress().matches("")) {
            errors.rejectValue("teacherAddress", "teacherAddress", "Địa chỉ không được để trống");
        }

        if (teacherDTO.getTeacherPhoneNumber().matches("")) {
            errors.rejectValue("phoneNumber", "phoneNumber", "Số điện thoại không được để trống");
        } else {
            for (int i = 0; i < list.size(); i++) {
                int count = 0;
                if (teacherDTO.getTeacherPhoneNumber().equals(list.get(i).getPhoneNumber()) && count == 2) {
                    errors.rejectValue("phoneNumber", "phoneNumber", "Số điện thoại đã được sử dụng");
                    count++;
                    break;
                }
            }
        }

        if (teacherDTO.getFaculty() == null) {
            errors.rejectValue("faculty", "faculty", "Học vị không được để trống");
        }

        if (teacherDTO.getTeacherEmail().matches("")) {
            errors.rejectValue("email", "email", "Email không được để trống");
        } else {
            int count = 0;
            for (int i = 0; i < list.size(); i++) {
                if (teacherDTO.getTeacherEmail().equals(list.get(i).getEmail()) && count == 2) {
                    errors.rejectValue("email", "email", "Email đã được sử dụng");
                    count++;
                    break;
                }
            }
        }
    }
}
