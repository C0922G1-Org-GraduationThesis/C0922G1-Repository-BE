package com.example.be.service.Impl;

import com.example.be.model.ProgressReview;
import com.example.be.repository.IProgressReviewRepository;
import com.example.be.service.IProgressReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProgressReviewService implements IProgressReviewService {
    @Autowired
    private IProgressReviewRepository progressReviewRepository;

    /**
     * Created by: VuLX
     * Date created: 29/3/2023
     * Function: display list progress-review
     */
    @Override
    public List<ProgressReview> findAll() {
        return progressReviewRepository.findAll();
    }

    /**
     * Created by: VuLX
     * Date created: 29/3/2023
     * Function: display  progress-review by id
     */

    @Override
    public ProgressReview findById(Long progressReviewId) {
        return progressReviewRepository.findById(progressReviewId).orElse(null);
    }

    /**
     * Created by: VuLX
     * Date created: 29/3/2023
     * Function: create  progress-review
     */

    @Override
    public ProgressReview save(ProgressReview progressReview) {
        return progressReviewRepository.save(progressReview);
    }
}
