package com.example.be.service;

import com.example.be.model.ProgressDetail;

import java.util.List;

public interface IProgressDetailService {
    /**
     * Created by: VuLX
     * Date created: 01/04/2023
     */
    List<ProgressDetail>findAllByProjectId(Long projectId);
    /**
     * Created by: VuLX
     * Date created: 01/04/2023
     */
    ProgressDetail findProgressDetailByProjectId(Long projectId);
    /**
     * Created by: VuLX
     * Date created: 01/04/2023
     */
    ProgressDetail findById(Long progressDetailId);
}
