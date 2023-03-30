package com.example.be.dto;

public class ProgressDto {
    private Long projectId;
    private String teamName;
    private String projectName;
    private int memberTotal;

    public ProgressDto() {
    }

    public ProgressDto(Long projectId, String teamName, String projectName, int memberTotal) {
        this.projectId = projectId;
        this.teamName = teamName;
        this.projectName = projectName;
        this.memberTotal = memberTotal;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getMemberTotal() {
        return memberTotal;
    }

    public void setMemberTotal(int memberTotal) {
        this.memberTotal = memberTotal;
    }
}
