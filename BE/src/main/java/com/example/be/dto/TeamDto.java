package com.example.be.dto;

public class TeamDto {

    private Long teamId;

    private String teamName;

    private int memberOfTeam;

    private Long teacherId;

    public TeamDto() {
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public int getMemberOfTeam() {
        return memberOfTeam;
    }

    public void setMemberOfTeam(int memberOfTeam) {
        this.memberOfTeam = memberOfTeam;
    }
}
