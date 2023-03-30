package com.example.be.controller.project;

import com.example.be.dto.ProjectDTO;
import com.example.be.dto.TeamDTO;
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
public class ProjectRestController_saveProject {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void saveProject_name_13() throws Exception {
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setName(null);
        projectDTO.setContent("Đăng ký sinh viên online");
        projectDTO.setImg("picture.png");
        projectDTO.setDescription("Dự án đăng ký...");
        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setTeamId(6L);
        projectDTO.setTeamDTO(teamDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/projects/save")
                        .content(this.objectMapper.writeValueAsString(projectDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void saveProject_name_14() throws Exception {
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setName("");
        projectDTO.setContent("Đăng ký sinh viên online");
        projectDTO.setImg("picture.png");
        projectDTO.setDescription("Dự án đăng ký...");
        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setTeamId(6L);
        projectDTO.setTeamDTO(teamDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/projects/save")
                        .content(this.objectMapper.writeValueAsString(projectDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void saveProject_name_15() throws Exception {
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setName("$///123Dự:',.");
        projectDTO.setContent("Đăng ký sinh viên online");
        projectDTO.setImg("picture.png");
        projectDTO.setDescription("Dự án đăng ký...");
        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setTeamId(6L);
        projectDTO.setTeamDTO(teamDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/projects/save")
                        .content(this.objectMapper.writeValueAsString(projectDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void saveProject_name_17() throws Exception {
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setName("$///123Dự:',.$///123Dự:',.Đăng ký sinh viên online',.$///123Dự:'" +
                ",.$///123Dự:',.$///123Dự:',." +
                " Đăng ký sinh viên online:',.$///123Dự:',.$///123Dự:',.$///123Dự:',.$///123Dự:',.$///123Dự:',." +
                "$///123Dự:',.$///123Dự:',.$///123DĐăng ký sinh viên onlineDự:',.$///123Dự:',.$///123Dự:',." +
                "$///123Dự:',.$///123Dự:',. Đăng ký sinh viên online, Đăng ký sinh viên online Đăng ký sinh viên online ");
        projectDTO.setContent("Đăng ký sinh viên online");
        projectDTO.setImg("picture.png");
        projectDTO.setDescription("Dự án đăng ký...");
        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setTeamId(6L);
        projectDTO.setTeamDTO(teamDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/projects/save")
                        .content(this.objectMapper.writeValueAsString(projectDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void saveProject_content_13() throws Exception {
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setName("Dự án sinh viên");
        projectDTO.setContent(null);
        projectDTO.setImg("picture.png");
        projectDTO.setDescription("Dự án đăng ký...");
        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setTeamId(6L);
        projectDTO.setTeamDTO(teamDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/projects/save")
                        .content(this.objectMapper.writeValueAsString(projectDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void saveProject_content_14() throws Exception {
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setName("Dự án sinh viên");
        projectDTO.setContent("");
        projectDTO.setImg("picture.png");
        projectDTO.setDescription("Dự án đăng ký...");
        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setTeamId(6L);
        projectDTO.setTeamDTO(teamDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/projects/save")
                        .content(this.objectMapper.writeValueAsString(projectDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void saveProject_img_13() throws Exception {
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setName("Dự án sinh viên");
        projectDTO.setContent("Đăng ký sinh viên online");
        projectDTO.setImg(null);
        projectDTO.setDescription("Dự án đăng ký...");
        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setTeamId(6L);
        projectDTO.setTeamDTO(teamDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/projects/save")
                        .content(this.objectMapper.writeValueAsString(projectDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void saveProject_img_14() throws Exception {
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setName("Dự án sinh viên");
        projectDTO.setContent("Đăng ký sinh viên online");
        projectDTO.setImg("");
        projectDTO.setDescription("Dự án đăng ký...");
        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setTeamId(6L);
        projectDTO.setTeamDTO(teamDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/projects/save")
                        .content(this.objectMapper.writeValueAsString(projectDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void saveProject_description_13() throws Exception {
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setName("Dự án sinh viên");
        projectDTO.setContent("Đăng ký sinh viên online");
        projectDTO.setImg("picture.png");
        projectDTO.setDescription(null);
        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setTeamId(6L);
        projectDTO.setTeamDTO(teamDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/projects/save")
                        .content(this.objectMapper.writeValueAsString(projectDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void saveProject_description_14() throws Exception {
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setName("Dự án sinh viên");
        projectDTO.setContent("Đăng ký sinh viên online");
        projectDTO.setImg("picture.png");
        projectDTO.setDescription("");
        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setTeamId(6L);
        projectDTO.setTeamDTO(teamDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/projects/save")
                        .content(this.objectMapper.writeValueAsString(projectDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void saveProject_team_13() throws Exception {
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setName("Dự án sinh viên");
        projectDTO.setContent("Đăng ký sinh viên online");
        projectDTO.setImg("picture.png");
        projectDTO.setDescription("Dự án");
        projectDTO.setTeamDTO(null);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/projects/save")
                        .content(this.objectMapper.writeValueAsString(projectDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void saveProject_team_14() throws Exception {
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setName("Dự án sinh viên");
        projectDTO.setContent("Đăng ký sinh viên online");
        projectDTO.setImg("picture.png");
        projectDTO.setDescription("Dự án");
        projectDTO.setTeamDTO(new TeamDTO());


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/projects/save")
                        .content(this.objectMapper.writeValueAsString(projectDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void saveProject_description_18() throws Exception {
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setName("Dự án sinh viên");
        projectDTO.setContent("Đăng ký sinh viên online");
        projectDTO.setImg("picture.png");
        projectDTO.setDescription("Dự án giải quyết vấn đề đăng ký sinh viên");
        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setTeamId(6L);
        projectDTO.setTeamDTO(teamDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/projects/save")
                        .content(this.objectMapper.writeValueAsString(projectDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
