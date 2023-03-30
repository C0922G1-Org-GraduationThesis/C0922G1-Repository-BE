package com.example.be.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class NotificationTeacherRestController_getAllNotificationTeacher {
    @Autowired
    private MockMvc mockMvc;

    /**
     * Created by: hoangNNH
     * Date created: 30/03/2023
     * This function use to test get notification-teacher list
     */
    @Test
    public void getAllNotificationTeacher_5() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/notification-teachers/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * Created by: hoangNNH
     * Date created: 30/03/2023
     * This function use to test get notification-teacher list
     */
    @Test
    public void getAllNotificationTeacher_6() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/notification-teachers"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$[0].notificationTeacherId").value(1));
    }
}
