package com.example.be.controller;

import com.example.be.dto.ProgressReviewDto;
import com.example.be.dto.ProjectDto;
import com.example.be.dto.TeacherDto;
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
public class ProgressReviewRestController_saveProgressReview {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createProgressReview_title_13() throws Exception {
        ProgressReviewDto progressReviewDto = new ProgressReviewDto();
        progressReviewDto.setProgressReviewContent("Sai format trello");
        progressReviewDto.setProgressReviewPercent(66);
        progressReviewDto.setProgressReviewDateCreate("2023-03-25 16:30:11");
        ProjectDto projectDto = new ProjectDto();
        projectDto.setProjectId(Long.valueOf(2));
        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setTeacherId(Long.valueOf(1));
        progressReviewDto.setProjectDto(projectDto);
        progressReviewDto.setTeacherDto(teacherDto);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/studentRest/create")
                        .content(this.objectMapper.writeValueAsString(progressReviewDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
@Test
    public void createProgressReview_content_13() throws Exception {
        ProgressReviewDto progressReviewDto = new ProgressReviewDto();
        progressReviewDto.setProgressReviewTitle("Sai format trello");
        progressReviewDto.setProgressReviewPercent(66);
        progressReviewDto.setProgressReviewDateCreate("2023-03-25 16:30:11");
        ProjectDto projectDto = new ProjectDto();
        projectDto.setProjectId(Long.valueOf(2));
        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setTeacherId(Long.valueOf(1));
        progressReviewDto.setProjectDto(projectDto);
        progressReviewDto.setTeacherDto(teacherDto);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/studentRest/create")
                        .content(this.objectMapper.writeValueAsString(progressReviewDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createProgressReview_percent_13() throws Exception {
        ProgressReviewDto progressReviewDto = new ProgressReviewDto();
        progressReviewDto.setProgressReviewTitle("Sai format trello");
        progressReviewDto.setProgressReviewContent("Hello");
        progressReviewDto.setProgressReviewDateCreate("2023-03-25 16:30:11");
        ProjectDto projectDto = new ProjectDto();
        projectDto.setProjectId(2L);
        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setTeacherId(1L);
        progressReviewDto.setProjectDto(projectDto);
        progressReviewDto.setTeacherDto(teacherDto);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/studentRest/create")
                        .content(this.objectMapper.writeValueAsString(progressReviewDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createProgressReview_dateCreate_13() throws Exception {
        ProgressReviewDto progressReviewDto = new ProgressReviewDto();
        progressReviewDto.setProgressReviewTitle("Sai format trello");
        progressReviewDto.setProgressReviewContent("Hello");
        progressReviewDto.setProgressReviewPercent(66);
        ProjectDto projectDto = new ProjectDto();
        projectDto.setProjectId(2L);
        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setTeacherId(1L);
        progressReviewDto.setProjectDto(projectDto);
        progressReviewDto.setTeacherDto(teacherDto);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/studentRest/create")
                        .content(this.objectMapper.writeValueAsString(progressReviewDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createProgressReview_title_14() throws Exception {
        ProgressReviewDto progressReviewDto = new ProgressReviewDto();
        progressReviewDto.setProgressReviewTitle("Sai format trello");
        progressReviewDto.setProgressReviewContent("Hello");
        progressReviewDto.setProgressReviewPercent(66);
        progressReviewDto.setProgressReviewTitle("");
        ProjectDto projectDto = new ProjectDto();
        projectDto.setProjectId(2L);
        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setTeacherId(1L);
        progressReviewDto.setProjectDto(projectDto);
        progressReviewDto.setTeacherDto(teacherDto);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/studentRest/create")
                        .content(this.objectMapper.writeValueAsString(progressReviewDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createProgressReview_content_14() throws Exception {
        ProgressReviewDto progressReviewDto = new ProgressReviewDto();
        progressReviewDto.setProgressReviewTitle("Sai format trello");
        progressReviewDto.setProgressReviewContent("Hello");
        progressReviewDto.setProgressReviewPercent(66);
        progressReviewDto.setProgressReviewTitle("");
        ProjectDto projectDto = new ProjectDto();
        projectDto.setProjectId(2L);
        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setTeacherId(1L);
        progressReviewDto.setProjectDto(projectDto);
        progressReviewDto.setTeacherDto(teacherDto);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/studentRest/create")
                        .content(this.objectMapper.writeValueAsString(progressReviewDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createProgressReview_dateCreate_14() throws Exception {
        ProgressReviewDto progressReviewDto = new ProgressReviewDto();
        progressReviewDto.setProgressReviewTitle("Sai format trello");
        progressReviewDto.setProgressReviewContent("Hello");
        progressReviewDto.setProgressReviewPercent(66);
        progressReviewDto.setProgressReviewDateCreate("");
        ProjectDto projectDto = new ProjectDto();
        projectDto.setProjectId(2L);
        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setTeacherId(1L);
        progressReviewDto.setProjectDto(projectDto);
        progressReviewDto.setTeacherDto(teacherDto);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/studentRest/create")
                        .content(this.objectMapper.writeValueAsString(progressReviewDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createProgressReview_content_16() throws Exception {
        ProgressReviewDto progressReviewDto = new ProgressReviewDto();
        progressReviewDto.setProgressReviewTitle("Sai format trello");
        progressReviewDto.setProgressReviewContent("Hell");
        progressReviewDto.setProgressReviewPercent(66);
        progressReviewDto.setProgressReviewDateCreate("");
        ProjectDto projectDto = new ProjectDto();
        projectDto.setProjectId(2L);
        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setTeacherId(1L);
        progressReviewDto.setProjectDto(projectDto);
        progressReviewDto.setTeacherDto(teacherDto);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/studentRest/create")
                        .content(this.objectMapper.writeValueAsString(progressReviewDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createProgressReview_title_16() throws Exception {
        ProgressReviewDto progressReviewDto = new ProgressReviewDto();
        progressReviewDto.setProgressReviewTitle("ư");
        progressReviewDto.setProgressReviewContent("Hell");
        progressReviewDto.setProgressReviewPercent(66);
        progressReviewDto.setProgressReviewDateCreate("");
        ProjectDto projectDto = new ProjectDto();
        projectDto.setProjectId(2L);
        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setTeacherId(1L);
        progressReviewDto.setProjectDto(projectDto);
        progressReviewDto.setTeacherDto(teacherDto);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/studentRest/create")
                        .content(this.objectMapper.writeValueAsString(progressReviewDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
}
