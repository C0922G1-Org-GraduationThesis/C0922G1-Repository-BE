package com.example.be.controller;

import com.example.be.dto.PasswordDto;
import com.example.be.payload.request.LoginRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
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
@SpringBootTest
@AutoConfigureMockMvc
public class SecurityController_changePassword {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    //[item] oldPassword = null
    @Test
    public void changePassword_oldPassword_19() throws Exception {
        PasswordDto passwordDto = new PasswordDto();
        passwordDto.setUsername("dat@gmail.com");
        passwordDto.setOldPassword(null);
        passwordDto.setNewPassword("1234567");
        passwordDto.setPasswordConfirm("1234567");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/public/change-password")
                        .content(this.objectMapper.writeValueAsString(passwordDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //[item] oldPassword = ""
    @Test
    public void changePassword_oldPassword_20() throws Exception {
        PasswordDto passwordDto = new PasswordDto();
        passwordDto.setUsername("dat@gmail.com");
        passwordDto.setOldPassword("");
        passwordDto.setNewPassword("1231234");
        passwordDto.setPasswordConfirm("1231234");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/public/change-password")
                        .content(this.objectMapper.writeValueAsString(passwordDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //[item] newPassword = null
    @Test
    public void changePassword_newPassword_19() throws Exception {
        PasswordDto passwordDto = new PasswordDto();
        passwordDto.setUsername("dat@gmail.com");
        passwordDto.setOldPassword("123123123");
        passwordDto.setNewPassword(null);
        passwordDto.setPasswordConfirm("123123456");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/public/change-password")
                        .content(this.objectMapper.writeValueAsString(passwordDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //[item] newPassword = ""
    @Test
    public void changePassword_newPassword_20() throws Exception {
        PasswordDto passwordDto = new PasswordDto();
        passwordDto.setUsername("dat@gmail.com");
        passwordDto.setOldPassword("123312312");
        passwordDto.setNewPassword("");
        passwordDto.setPasswordConfirm("12312345");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/public/change-password")
                        .content(this.objectMapper.writeValueAsString(passwordDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //[item] passwordConfirm = null
    @Test
    public void changePassword_passwordConfirm_19() throws Exception {
        PasswordDto passwordDto = new PasswordDto();
        passwordDto.setUsername("dat@gmail.com");
        passwordDto.setOldPassword("123123312");
        passwordDto.setNewPassword("1231234123");
        passwordDto.setPasswordConfirm(null);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/public/change-password")
                        .content(this.objectMapper.writeValueAsString(passwordDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //[item] passwordConfirm = ""
    @Test
    public void changePassword_passwordConfirm_20() throws Exception {
        PasswordDto passwordDto = new PasswordDto();
        passwordDto.setUsername("dat@gmail.com");
        passwordDto.setOldPassword("123123123");
        passwordDto.setNewPassword("1231234123");
        passwordDto.setPasswordConfirm("");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/public/change-password")
                        .content(this.objectMapper.writeValueAsString(passwordDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //[newPassword] không >= minlength
    @Test
    public void changePassword_newPassword_22() throws Exception {
        PasswordDto passwordDto = new PasswordDto();
        passwordDto.setUsername("dat@gmail.com");
        passwordDto.setOldPassword("123123123");
        passwordDto.setNewPassword("123123"); //Nhỏ hơn 8 kí tự
        passwordDto.setPasswordConfirm("123123");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/public/change-password")
                        .content(this.objectMapper.writeValueAsString(passwordDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //[passwordConfirm] không >= minlength
    @Test
    public void changePassword_passwordConfirm_22() throws Exception {
        PasswordDto passwordDto = new PasswordDto();
        passwordDto.setUsername("dat@gmail.com");
        passwordDto.setOldPassword("123123123");
        passwordDto.setNewPassword("123123");
        passwordDto.setPasswordConfirm("123123");//Nhỏ hơn 8 kí tự
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/public/change-password")
                        .content(this.objectMapper.writeValueAsString(passwordDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

//    All [item] đều hợp lệ
    @Test
    public void changePassword_24() throws Exception {
        PasswordDto passwordDto = new PasswordDto();
        passwordDto.setUsername("dat@gmail.com");
        passwordDto.setOldPassword("123456789");
        passwordDto.setNewPassword("12345678");
        passwordDto.setPasswordConfirm("12345678");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/public/change-password")
                        .content(this.objectMapper.writeValueAsString(passwordDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    //[item] passwordConfirm different from newPassword
    @Test
    public void changePassword_29() throws Exception {
        PasswordDto passwordDto = new PasswordDto();
        passwordDto.setUsername("dat@gmail.com");
        passwordDto.setOldPassword("123123123");
        passwordDto.setNewPassword("12312341235");
        passwordDto.setPasswordConfirm("232334343");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/public/change-password")
                        .content(this.objectMapper.writeValueAsString(passwordDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //[item] oldPassword different from password form database
    @Test
    public void changePassword_30() throws Exception {
        PasswordDto passwordDto = new PasswordDto();
        passwordDto.setUsername("dat@gmail.com");
        passwordDto.setOldPassword("123123125");
        passwordDto.setNewPassword("1231234123");
        passwordDto.setPasswordConfirm("1231234123");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .patch("/api/public/change-password")
                        .content(this.objectMapper.writeValueAsString(passwordDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
