package com.example.be.controller.team;

import com.example.be.dto.TeamDTO;
import com.example.be.model.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TeamRestController_saveTeam {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void saveTeam_name_13() throws Exception {
        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setTeamName(null);
        teamDTO.setMemberOfTeam(2);
        Set<Student> students = new HashSet<>();
        Student student1 = new Student();
        student1.setStudentId(1L);
        Student student2 = new Student();
        student2.setStudentId(2L);
        students.add(student1);
        students.add(student2);
        teamDTO.setStudentSet(students);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/students/save")
                        .content(this.objectMapper.writeValueAsString(teamDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void saveTeam_name_14() throws Exception {
        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setTeamName("");
        teamDTO.setMemberOfTeam(2);
        Set<Student> students = new HashSet<>();
        Student student1 = new Student();
        student1.setStudentId(1L);
        Student student2 = new Student();
        student2.setStudentId(2L);
        students.add(student1);
        students.add(student2);
        teamDTO.setStudentSet(students);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/students/save")
                        .content(this.objectMapper.writeValueAsString(teamDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void saveTeam_name_15() throws Exception {
        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setTeamName("C//09'''''1111@@22G1");
        teamDTO.setMemberOfTeam(2);
        Set<Student> students = new HashSet<>();
        Student student1 = new Student();
        student1.setStudentId(1L);
        Student student2 = new Student();
        student2.setStudentId(2L);
        students.add(student1);
        students.add(student2);
        teamDTO.setStudentSet(students);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/students/save")
                        .content(this.objectMapper.writeValueAsString(teamDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void saveTeam_name_17() throws Exception {
        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setTeamName("Đây là team c09 Đây là team c09 Đây là team c09 Đây là team c09 Đây là team c09 " +
                "Đây là team c09 Đây là team c09 Đây là team c09 Đây là team c09 Đây là team c09 Đây là team c09");
        teamDTO.setMemberOfTeam(2);
        Set<Student> students = new HashSet<>();
        Student student1 = new Student();
        student1.setStudentId(1L);
        Student student2 = new Student();
        student2.setStudentId(2L);
        students.add(student1);
        students.add(student2);
        teamDTO.setStudentSet(students);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/students/save")
                        .content(this.objectMapper.writeValueAsString(teamDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void saveTeam_memberOfTeam_13() throws Exception {
        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setTeamName("C0123G1");
        teamDTO.setMemberOfTeam(null);
        Set<Student> students = new HashSet<>();
        Student student1 = new Student();
        student1.setStudentId(1L);
        Student student2 = new Student();
        student2.setStudentId(2L);
        students.add(student1);
        students.add(student2);
        teamDTO.setStudentSet(students);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/students/save")
                        .content(this.objectMapper.writeValueAsString(teamDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void saveTeam_studentSet_13() throws Exception {
        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setTeamName("C0123G1");
        teamDTO.setMemberOfTeam(2);
        Set<Student> students = new HashSet<>();
        teamDTO.setStudentSet(students);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/students/save")
                        .content(this.objectMapper.writeValueAsString(teamDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void saveTeam_studentSet_14() throws Exception {
        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setTeamName("C0123G1");
        teamDTO.setMemberOfTeam(2);
        teamDTO.setStudentSet(null);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/students/save")
                        .content(this.objectMapper.writeValueAsString(teamDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void saveTeam_memberOfTeam_18() throws Exception {
        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setTeamName("C0123G1");
        teamDTO.setMemberOfTeam(2);
        Set<Student> students = new HashSet<>();
        Student student1 = new Student();
        student1.setStudentId(1L);
        Student student2 = new Student();
        student2.setStudentId(2L);
        students.add(student1);
        students.add(student2);
        teamDTO.setStudentSet(students);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/students/save")
                        .content(this.objectMapper.writeValueAsString(teamDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
