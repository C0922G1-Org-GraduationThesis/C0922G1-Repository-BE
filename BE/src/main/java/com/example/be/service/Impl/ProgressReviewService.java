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

    @Override
    public int findMaxPercentProgressReport(Long project_id, int stage_id) {
        return progressReviewRepository.findMaxPercentProgressReport(project_id,stage_id);
    }

}
