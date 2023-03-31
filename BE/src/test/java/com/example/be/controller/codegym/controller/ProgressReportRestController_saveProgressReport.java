package com.example.be.controller.codegym.controller;

import com.example.be.dto.ProgressReportDTO;
import com.example.be.dto.ProjectDTO;
import com.example.be.dto.StageDTO;
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

/**
 * Created by: SyVT
 * Date created: 30/3/2023
 * Function:Test JUnit saveProgressReport
 *
 */
@SpringBootTest
@AutoConfigureMockMvc
public class ProgressReportRestController_saveProgressReport {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createProgressReport_ProgressReportContent_13() throws Exception {

        ProgressReportDTO progressReportDTO = new ProgressReportDTO();
        progressReportDTO.setProgressReportContent(null);
        progressReportDTO.setProgressReportFile("desktop/text.text");
        progressReportDTO.setProgressReportTime("2023/12/12 09:00:00");
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setProjectId(2L);
        progressReportDTO.setProjectDTO(projectDTO);
        StageDTO stageDTO = new StageDTO();
        stageDTO.setStageId(2);
        progressReportDTO.setStage(stageDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/progress-reports")
                        .content(this.objectMapper.writeValueAsString(progressReportDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createProgressReport_ProgressReportContent_14() throws Exception {

        ProgressReportDTO progressReportDTO = new ProgressReportDTO();
        progressReportDTO.setProgressReportContent("");
        progressReportDTO.setProgressReportFile("desktop/text.text");
        progressReportDTO.setProgressReportTime("2023/12/12 09:00:00");
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setProjectId(2L);
        progressReportDTO.setProjectDTO(projectDTO);
        StageDTO stageDTO = new StageDTO();
        stageDTO.setStageId(2);
        progressReportDTO.setStage(stageDTO);


        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/progress-reports")
                        .content(this.objectMapper.writeValueAsString(progressReportDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createProgressReport_ProgressReportContent_16() throws Exception {

        ProgressReportDTO progressReportDTO = new ProgressReportDTO();
        progressReportDTO.setProgressReportContent("Các cầu thủ U20 Indonesia đã chuẩn bị rất kỹ càng để hướng tới sân chơi U20 World Cup 2023. Tuy nhiên sau việc " +
                "FIFA quyết định tước quyền đăng cai giải đấu này của Indonesia, giấc mơ của các cầu thủ trẻ xứ Vạn đảo đã tan thành mây khói. \n" +
                "\n" +
                "Theo tờ CNN Indonesia tiết lộ, khi biết việc nước nhà bị tước quyền đăng cai U20 World Cup 2023, nhiều cầu thủ U20 Indonesia đã bật khóc nức nở. Tờ báo xứ Vạn đảo dẫn lời trợ lý Nova Arianto khi ông còn rơm rớm nước mắt, đôi mắt thì đỏ hoe: \n" +
                "\n" +
                "\"Tôi và mọi người đã nỗ lực rất nhiều kể từ năm 2020 để chuẩn bị cho giải đấu lớn này. Cuối cùng, đây là lần thứ 2 chúng tôi không được dự World Cup. Có lẽ tôi không phải cầu thủ nên tôi chỉ biết tiếc cho họ vì những cơ hội tốt để phát triển bản thân đã vụt tắt\".");
        progressReportDTO.setProgressReportFile("desktop/text.text");
        progressReportDTO.setProgressReportTime("2023/12/12 09:00:00");
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setProjectId(2L);
        progressReportDTO.setProjectDTO(projectDTO);
        StageDTO stageDTO = new StageDTO();
        stageDTO.setStageId(2);
        progressReportDTO.setStage(stageDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/progress-reports")
                        .content(this.objectMapper.writeValueAsString(progressReportDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createProgressReport_ProgressReportContent_17() throws Exception {

        ProgressReportDTO progressReportDTO = new ProgressReportDTO();
        progressReportDTO.setProgressReportContent("Các");
        progressReportDTO.setProgressReportFile("desktop/text.text");
        progressReportDTO.setProgressReportTime("2023/12/12 09:00:00");
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setProjectId(2L);
        progressReportDTO.setProjectDTO(projectDTO);
        StageDTO stageDTO = new StageDTO();
        stageDTO.setStageId(2);
        progressReportDTO.setStage(stageDTO);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/progress-reports")
                        .content(this.objectMapper.writeValueAsString(progressReportDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }    @Test
    public void createProgressReport_ProgressReportContent_18() throws Exception {

        ProgressReportDTO progressReportDTO = new ProgressReportDTO();
        progressReportDTO.setProgressReportContent("Các cầu thủ Indonesia");
        progressReportDTO.setProgressReportFile("desktop/text.text");
        progressReportDTO.setProgressReportTime("2023/12/12 09:00:00");
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setProjectId(2L);
        progressReportDTO.setProjectDTO(projectDTO);
        StageDTO stageDTO = new StageDTO();
        stageDTO.setStageId(2);
        progressReportDTO.setStage(stageDTO);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/progress-reports")
                        .content(this.objectMapper.writeValueAsString(progressReportDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void createProgressReport_ProgressReportFile_13() throws Exception {

        ProgressReportDTO progressReportDTO = new ProgressReportDTO();
        progressReportDTO.setProgressReportContent("Các cầu thủ Indonesia");
        progressReportDTO.setProgressReportFile(null);
        progressReportDTO.setProgressReportTime("2023/12/12 09:00:00");
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setProjectId(2L);
        progressReportDTO.setProjectDTO(projectDTO);
        StageDTO stageDTO = new StageDTO();
        stageDTO.setStageId(2);
        progressReportDTO.setStage(stageDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/progress-reports")
                        .content(this.objectMapper.writeValueAsString(progressReportDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createProgressReport_ProgressReportFile_14() throws Exception {

        ProgressReportDTO progressReportDTO = new ProgressReportDTO();
        progressReportDTO.setProgressReportContent("Các cầu thủ Indonesia");
        progressReportDTO.setProgressReportFile("null");
        progressReportDTO.setProgressReportTime("2023/12/12 09:00:00");
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setProjectId(2L);
        progressReportDTO.setProjectDTO(projectDTO);
        StageDTO stageDTO = new StageDTO();
        stageDTO.setStageId(2);
        progressReportDTO.setStage(stageDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/progress-reports")
                        .content(this.objectMapper.writeValueAsString(progressReportDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createProgressReport_ProgressReportFile_18() throws Exception {

        ProgressReportDTO progressReportDTO = new ProgressReportDTO();
        progressReportDTO.setProgressReportContent("Các cầu thủ Indonesia");
        progressReportDTO.setProgressReportFile("desktop/text.text");
        progressReportDTO.setProgressReportTime("2023/12/12 09:00:00");
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setProjectId(2L);
        progressReportDTO.setProjectDTO(projectDTO);
        StageDTO stageDTO = new StageDTO();
        stageDTO.setStageId(2);
        progressReportDTO.setStage(stageDTO);
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/progress-reports")
                        .content(this.objectMapper.writeValueAsString(progressReportDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void createProgressReport_ProgressReportTime_13() throws Exception {

        ProgressReportDTO progressReportDTO = new ProgressReportDTO();
        progressReportDTO.setProgressReportContent("Các cầu thủ Indonesia");
        progressReportDTO.setProgressReportFile("desktop/text.text");
        progressReportDTO.setProgressReportTime(null);
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setProjectId(2L);
        progressReportDTO.setProjectDTO(projectDTO);
        StageDTO stageDTO = new StageDTO();
        stageDTO.setStageId(2);
        progressReportDTO.setStage(stageDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/progress-reports")
                        .content(this.objectMapper.writeValueAsString(progressReportDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createProgressReport_ProgressReportTime_14() throws Exception {

        ProgressReportDTO progressReportDTO = new ProgressReportDTO();
        progressReportDTO.setProgressReportContent("Các cầu thủ Indonesia");
        progressReportDTO.setProgressReportFile("desktop/text.text");
        progressReportDTO.setProgressReportTime("");
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setProjectId(2L);
        progressReportDTO.setProjectDTO(projectDTO);
        StageDTO stageDTO = new StageDTO();
        stageDTO.setStageId(2);
        progressReportDTO.setStage(stageDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/progress-reports")
                        .content(this.objectMapper.writeValueAsString(progressReportDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createProgressReport_ProgressReportTime_15() throws Exception {

        ProgressReportDTO progressReportDTO = new ProgressReportDTO();
        progressReportDTO.setProgressReportContent("Các cầu thủ Indonesia");
        progressReportDTO.setProgressReportFile("desktop/text.text");
        progressReportDTO.setProgressReportTime("2023-11-11 12:12:12");
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setProjectId(2L);
        progressReportDTO.setProjectDTO(projectDTO);
        StageDTO stageDTO = new StageDTO();
        stageDTO.setStageId(2);
        progressReportDTO.setStage(stageDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/progress-reports")
                        .content(this.objectMapper.writeValueAsString(progressReportDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void createProgressReport_ProgressReportTime_20() throws Exception {

        ProgressReportDTO progressReportDTO = new ProgressReportDTO();
        progressReportDTO.setProgressReportContent("Các cầu thủ Indonesia");
        progressReportDTO.setProgressReportFile("desktop/text.text");
        progressReportDTO.setProgressReportTime("2023/11/11 12:12:12");
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setProjectId(2L);
        progressReportDTO.setProjectDTO(projectDTO);
        StageDTO stageDTO = new StageDTO();
        stageDTO.setStageId(2);
        progressReportDTO.setStage(stageDTO);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/progress-reports")
                        .content(this.objectMapper.writeValueAsString(progressReportDTO))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

}
