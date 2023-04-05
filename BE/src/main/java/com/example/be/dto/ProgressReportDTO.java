package com.example.be.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

public class ProgressReportDTO {
    private int progressReportDTOId;
        @NotEmpty(message = "Không được để trống !")
    @Length(min =10,max = 200, message = "Ký tự không được nhỏ hơn 5 và vươt quá 200 ký tự")
    private String progressReportContent;
        @NotEmpty(message = "Không được để trống !")
    private String progressReportFile;
        @NotEmpty(message = "Không được để trống !")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
//    @Pattern(regexp = "^[0-9]{4}/(0[1-9]|1[0-2])/(0[1-9]|[1-2][0-9]|3[0-1]) (2[0-3]|[01][0-9]):[0-5][0-9]:[0-5][0-9]$", message = "Định dạng ngày giời phải theo format yyyy/mm/dd hh/mm/ss")
    private String progressReportTime;
        @NotEmpty(message = "Không được để trống !")
  @Length(min =10,max = 200, message = "Ký tự không được nhỏ hơn 5 và vươt quá 200 ký tự")
    private String progressReportFileName;

    private ProjectDTOO project;
    private StageDTO stage;

    public ProgressReportDTO(int progressReportDTOId, String progressReportContent, String progressReportFile, String progressReportTime, String progressReportFileName, ProjectDTOO project, StageDTO stage) {
        this.progressReportDTOId = progressReportDTOId;
        this.progressReportContent = progressReportContent;
        this.progressReportFile = progressReportFile;
        this.progressReportTime = progressReportTime;
        this.progressReportFileName = progressReportFileName;
        this.project = project;
        this.stage = stage;
    }

    public ProgressReportDTO() {
    }

    public String getProgressReportContent() {
        return progressReportContent;
    }

    public ProjectDTOO getProjectDTO() {
        return project;
    }

    public void setProjectDTO(ProjectDTOO projectDTO) {
        this.project = projectDTO;
    }

    public StageDTO getStage() {
        return stage;
    }

    public void setStage(StageDTO stage) {
        this.stage = stage;
    }

    public void setProgressReportContent(String progressReportContent) {
        this.progressReportContent = progressReportContent;
    }

    public String getProgressReportFile() {
        return progressReportFile;
    }

    public void setProgressReportFile(String progressReportFile) {
        this.progressReportFile = progressReportFile;
    }

    public String getProgressReportTime() {
        return progressReportTime;
    }

    public void setProgressReportTime(String progressReportTime) {

        this.progressReportTime = progressReportTime;
    }

    public int getProgressReportDTOId() {
        return progressReportDTOId;
    }

    public void setProgressReportDTOId(int progressReportDTOId) {
        this.progressReportDTOId = progressReportDTOId;
    }

    public String getProgressReportFileName() {
        return progressReportFileName;
    }

    public void setProgressReportFileName(String progressReportFileName) {
        this.progressReportFileName = progressReportFileName;
    }

    public ProjectDTOO getProject() {
        return project;
    }

    public void setProject(ProjectDTOO project) {
        this.project = project;
    }
}
