package com.example.be.controller;

import com.example.be.dto.PasswordDto;
import com.example.be.dto.UserRoleAdminDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class TeacherRestController_updateTeacherRoleAdmin {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    //[teacherName] = null
    @Test
    public void updateTeacherRoleAdmin_teacherName_19() throws Exception {
        UserRoleAdminDto userRoleAdminDto = new UserRoleAdminDto();
        userRoleAdminDto.setTeacherId(1L);
        userRoleAdminDto.setTeacherName(null);
        userRoleAdminDto.setTeacherEmail("Tien@gmail.com");
        userRoleAdminDto.setTeacherPhoneNumber("0905123456");
        userRoleAdminDto.setTeacherAddress("Tam Đại, Phú Ninh, Quảng Nam");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/public/teachers/update-user-role-admin")
                        .content(this.objectMapper.writeValueAsString(userRoleAdminDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //[teacherName] = null
    @Test
    public void updateTeacherRoleAdmin_teacherEmail_19() throws Exception {
        UserRoleAdminDto userRoleAdminDto = new UserRoleAdminDto();
        userRoleAdminDto.setTeacherId(1L);
        userRoleAdminDto.setTeacherName("Nguyen Thi A");
        userRoleAdminDto.setTeacherEmail(null);
        userRoleAdminDto.setTeacherPhoneNumber("0905123456");
        userRoleAdminDto.setTeacherAddress("Tam Đại, Phú Ninh, Quảng Nam");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/public/teachers/update-user-role-admin")
                        .content(this.objectMapper.writeValueAsString(userRoleAdminDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //[teacherPhoneNumber] = null
    @Test
    public void updateTeacherRoleAdmin_teacherPhoneNumber_19() throws Exception {

        UserRoleAdminDto userRoleAdminDto = new UserRoleAdminDto();
        userRoleAdminDto.setTeacherId(1L);
        userRoleAdminDto.setTeacherName("Nguyen Thi A");
        userRoleAdminDto.setTeacherEmail("adf@gmail.com");
        userRoleAdminDto.setTeacherPhoneNumber(null);
        userRoleAdminDto.setTeacherAddress("Tam Đại, Phú Ninh, Quảng Nam");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/public/teachers/update-user-role-admin")
                        .content(this.objectMapper.writeValueAsString(userRoleAdminDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //[teacherAddress] = null
    @Test
    public void updateTeacherRoleAdmin_teacherAddress_19() throws Exception {

        UserRoleAdminDto userRoleAdminDto = new UserRoleAdminDto();
        userRoleAdminDto.setTeacherId(1L);
        userRoleAdminDto.setTeacherName("Nguyen Thi A");
        userRoleAdminDto.setTeacherEmail("NguyenThiA@gmail.com");
        userRoleAdminDto.setTeacherPhoneNumber("0905123456");
        userRoleAdminDto.setTeacherAddress(null);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/public/teachers/update-user-role-admin")
                        .content(this.objectMapper.writeValueAsString(userRoleAdminDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    //[teacherName] = ""
    @Test
    public void updateTeacherRoleAdmin_teacherName_20() throws Exception {

        UserRoleAdminDto userRoleAdminDto = new UserRoleAdminDto();
        userRoleAdminDto.setTeacherId(1L);
        userRoleAdminDto.setTeacherName("");
        userRoleAdminDto.setTeacherEmail("Tien@gmail.com");
        userRoleAdminDto.setTeacherPhoneNumber("0905123456");
        userRoleAdminDto.setTeacherAddress("Tam Đại, Phú Ninh, Quảng Nam");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/public/teachers/update-user-role-admin")
                        .content(this.objectMapper.writeValueAsString(userRoleAdminDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //[teacherEmail] = ""
    @Test
    public void updateTeacherRoleAdmin_teacherEmail_20() throws Exception {

        UserRoleAdminDto userRoleAdminDto = new UserRoleAdminDto();
        userRoleAdminDto.setTeacherId(1L);
        userRoleAdminDto.setTeacherName("Nguyen Thi A");
        userRoleAdminDto.setTeacherEmail("");
        userRoleAdminDto.setTeacherPhoneNumber("0905123456");
        userRoleAdminDto.setTeacherAddress("Tam Đại, Phú Ninh, Quảng Nam");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/public/teachers/update-user-role-admin")
                        .content(this.objectMapper.writeValueAsString(userRoleAdminDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //[teacherPhoneNumber] = ""
    @Test
    public void updateTeacherRoleAdmin_teacherPhoneNumber_20() throws Exception {

        UserRoleAdminDto userRoleAdminDto = new UserRoleAdminDto();
        userRoleAdminDto.setTeacherId(1L);
        userRoleAdminDto.setTeacherName("Nguyen Thi A");
        userRoleAdminDto.setTeacherEmail("adf@gmail.com");
        userRoleAdminDto.setTeacherPhoneNumber("");
        userRoleAdminDto.setTeacherAddress("Tam Đại, Phú Ninh, Quảng Nam");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/public/teachers/update-user-role-admin")
                        .content(this.objectMapper.writeValueAsString(userRoleAdminDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //[teacherAddress] = ""
    @Test
    public void updateTeacherRoleAdmin_teacherAddress_20() throws Exception {

        UserRoleAdminDto userRoleAdminDto = new UserRoleAdminDto();
        userRoleAdminDto.setTeacherId(1L);
        userRoleAdminDto.setTeacherName("Nguyen Thi A");
        userRoleAdminDto.setTeacherEmail("NguyenThiA@gmail.com");
        userRoleAdminDto.setTeacherPhoneNumber("0905123456");
        userRoleAdminDto.setTeacherAddress("");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/public/teachers/update-user-role-admin")
                        .content(this.objectMapper.writeValueAsString(userRoleAdminDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //[teacherPhoneNumber] sai format ("Số điện thoại phải gồm 10 số 090xxxxxxx, 093xxxxxxx, 097xxxxxxx")
    @Test
    public void updateTeacherRoleAdmin_teacherPhoneNumber_21() throws Exception {

        UserRoleAdminDto userRoleAdminDto = new UserRoleAdminDto();
        userRoleAdminDto.setTeacherId(1L);
        userRoleAdminDto.setTeacherName("Nguyen Thi A");
        userRoleAdminDto.setTeacherEmail("NguyenThiA@gmail.com");
        userRoleAdminDto.setTeacherPhoneNumber("0915123456");
        userRoleAdminDto.setTeacherAddress("Tam Đại, Phú Ninh, Quảng Nam");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/public/teachers/update-user-role-admin")
                        .content(this.objectMapper.writeValueAsString(userRoleAdminDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //[teacherEmail] sai format
    @Test
    public void updateTeacherRoleAdmin_teacherEmail_21() throws Exception {

        UserRoleAdminDto userRoleAdminDto = new UserRoleAdminDto();
        userRoleAdminDto.setTeacherId(1L);
        userRoleAdminDto.setTeacherName("Nguyen Thi A");
        userRoleAdminDto.setTeacherEmail("NguyenThi.gmail.com");
        userRoleAdminDto.setTeacherPhoneNumber("0915123456");
        userRoleAdminDto.setTeacherAddress("Tam Đại, Phú Ninh, Quảng Nam");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/public/teachers/update-user-role-admin")
                        .content(this.objectMapper.writeValueAsString(userRoleAdminDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //[teacherName] sai format
    @Test
    public void updateTeacherRoleAdmin_teacherName_21() throws Exception {

        UserRoleAdminDto userRoleAdminDto = new UserRoleAdminDto();
        userRoleAdminDto.setTeacherId(1L);
        userRoleAdminDto.setTeacherName("NGUYen thi A");
        userRoleAdminDto.setTeacherEmail("NguyenThiA@gmail.com");
        userRoleAdminDto.setTeacherPhoneNumber("0905123456");
        userRoleAdminDto.setTeacherAddress("Tam Đại, Phú Ninh, Quảng Nam");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/public/teachers/update-user-role-admin")
                        .content(this.objectMapper.writeValueAsString(userRoleAdminDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //[teacherName] > maxlength (5o kí tự)
    @Test
    public void updateTeacherRoleAdmin_teacherName_23() throws Exception {

        UserRoleAdminDto userRoleAdminDto = new UserRoleAdminDto();
        userRoleAdminDto.setTeacherId(1L);
        userRoleAdminDto.setTeacherName("Nguyen Thi Ngoc Huyen Linh Thi Ngoc Huyen Linh Thi Ngoc Huyen Linh " +
                "Ngoc Huyen Linh Thi Ngoc Huyen Linh Thi Ngoc Huyen Linh Ngoc Huyen Linh Thi Ngoc Huyen Linh Thi Ngoc Huyen Linh");
        userRoleAdminDto.setTeacherEmail("NguyenThiA@gmail.com");
        userRoleAdminDto.setTeacherPhoneNumber("0905123456");
        userRoleAdminDto.setTeacherAddress("Tam Đại, Phú Ninh, Quảng Nam");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/public/teachers/update-user-role-admin")
                        .content(this.objectMapper.writeValueAsString(userRoleAdminDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //[teacherName] > maxlength (75 kí tự)
    @Test
    public void updateTeacherRoleAdmin_teacherAddress_23() throws Exception {

        UserRoleAdminDto userRoleAdminDto = new UserRoleAdminDto();
        userRoleAdminDto.setTeacherId(1L);
        userRoleAdminDto.setTeacherName("Nguyen Thi A");
        userRoleAdminDto.setTeacherEmail("NguyenThiA@gmail.com");
        userRoleAdminDto.setTeacherPhoneNumber("0905123456");
        userRoleAdminDto.setTeacherAddress("Tam Đại, Phú Ninh ,Điện Bàn, Tam Đại, Phú Ninh ,Điện Bàn, " +
                "Tam Đại, Phú Ninh ,Điện Bàn, Tam Đại, Phú Ninh ,Điện Bàn, Tam Đại, Phú Ninh ,Điện Bàn, Tam Đại, Phú Ninh ,Điện Bàn, v " +
                "Tam Đại, Phú Ninh ,Điện Bàn, Quảng Nam");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/public/teachers/update-user-role-admin")
                        .content(this.objectMapper.writeValueAsString(userRoleAdminDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //All [item] đều hợp lệ
    @Test
    public void updateTeacherRoleAdmin_24() throws Exception {

        UserRoleAdminDto userRoleAdminDto = new UserRoleAdminDto();
        userRoleAdminDto.setTeacherId(1L);
        userRoleAdminDto.setTeacherName("Nguyen Thi A");
        userRoleAdminDto.setTeacherEmail("NguyenThiA@gmail.com");
        userRoleAdminDto.setTeacherPhoneNumber("0905123456");
        userRoleAdminDto.setTeacherAddress("Tam Dai, Phu Ninh, Quang Nam");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/public/teachers/update-user-role-admin")
                        .content(this.objectMapper.writeValueAsString(userRoleAdminDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
