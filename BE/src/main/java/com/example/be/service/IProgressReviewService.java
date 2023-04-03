package com.example.be.service;

import com.example.be.model.ProgressReview;

import java.util.List;

public interface IProgressReviewService {
    /**
     * Created by: VuLX
     * Date created: 01/04/2023
     */
    List<ProgressReview>findAll();
    /**
     * Created by: VuLX
     * Date created: 01/04/2023
     */
    ProgressReview findById(Long progressReviewId);
    /**
     * Created by: VuLX
     * Date created: 01/04/2023
     */
    ProgressReview save(ProgressReview progressReview);
    /**
     * Created by: VuLX
     * Date created: 01/04/2023
     */
    List<ProgressReview> findAllByProjectId(Long projectId);
    /**
     * Created by: VuLX
     * Date created: 01/04/2023
     */
    List<ProgressReview> findAllByProjectIdAndRecord(Long projectId, int record);
    /**
     * Created by: VuLX
     * Date created: 01/04/2023
     */
    int findAllByProjectIdAndSize(Long projectId);
}
