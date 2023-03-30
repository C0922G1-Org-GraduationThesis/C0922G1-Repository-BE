package com.example.be.dto;

import com.example.be.model.ProgressReport;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

public class ProjectDTO {
    private Long projectId;
    @Size(max = 250, message = "Tên đề tài không được dài quá 250 kí tự")
    @NotBlank(message = "Không được để trống")
    @NotNull(message = "Phải nhập trường này")
    @Pattern(regexp = "^[A-Z][\\p{L}\\d\\s]*$",
            message =
                    "Tên đề tài không được chứa kí tự đặc biệt, " +
                            "chữ cái đầu tiên phải viết hoa")
    private String name;
    @Size(max = 2000, message = "Nội dung miêu tả không được dài quá 2000 kí tự")
    @NotBlank(message = "Không được để trống")
    @NotNull(message = "Phải nhập trường này")
    private String content;
    @NotBlank(message = "Không được để trống")
    @NotNull(message = "Phải nhập trường này")
    private String img;
    @NotBlank(message = "Không được để trống")
    @NotNull(message = "Phải nhập trường này")
    private String description;
    private TeamDTO teamDTO;

    public ProjectDTO() {
    }

    public ProjectDTO(String name, String content, String img, String description) {
        this.name = name;
        this.content = content;
        this.img = img;
        this.description = description;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public TeamDTO getTeamDTO() {
        return teamDTO;
    }

    public void setTeamDTO(TeamDTO teamDTO) {
        this.teamDTO = teamDTO;
    }
}
