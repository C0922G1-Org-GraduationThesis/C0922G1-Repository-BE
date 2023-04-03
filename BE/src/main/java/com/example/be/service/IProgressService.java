package com.example.be.service;

import com.example.be.dto.ProgressDto;
import com.example.be.dto.ProgressProjectDto;
import com.example.be.dto.ProgressStudentDto;
import java.util.List;

public interface IProgressService {
    /**
     * Created by: VuLX
     * Date created: 01/04/2023
     */
    List<ProgressDto> findAll();
    /**
     * Created by: VuLX
     * Date created: 01/04/2023
     */
    List<ProgressStudentDto>findAllStudentOfTeam(Long projectId);
    /**
     * Created by: VuLX
     * Date created: 01/04/2023
     */
    ProgressProjectDto findByProjectId(Long projectId);

}
