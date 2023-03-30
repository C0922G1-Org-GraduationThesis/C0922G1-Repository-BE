package com.example.be.dto;

import com.example.be.model.Project;
import com.example.be.model.Student;
import com.example.be.model.Teacher;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

public class TeamDTO {
    private Long teamId;
    @Size(max = 45)
    @NotBlank(message = "Không được để trống")
    @NotNull(message = "Phải nhập trường này")
    @Pattern(regexp = "^[A-Z][\\p{L}\\d\\s]*$",
            message =
                    "Tên nhóm không được chứa kí tự đặc biệt, " +
                            "chữ cái đầu tiên phải viết hoa")
    private String teamName;
    private Integer memberOfTeam;
    private Set<Student> studentSet;

    public TeamDTO(Long teamId, String teamName) {
        this.teamId = teamId;
        this.teamName = teamName;
    }

    public TeamDTO() {
    }

    public TeamDTO(String teamName) {
        this.teamName = teamName;
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


    public Set<Student> getStudentSet() {
        return studentSet;
    }

    public void setStudentSet(Set<Student> studentSet) {
        this.studentSet = studentSet;
    }

    public Integer getMemberOfTeam() {
        return memberOfTeam;
    }

    public void setMemberOfTeam(Integer memberOfTeam) {
        this.memberOfTeam = memberOfTeam;
    }
}
