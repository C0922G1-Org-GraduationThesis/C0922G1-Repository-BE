package com.example.be.service;

import com.example.be.model.ProgressReview;

import java.util.List;

public interface IProgressReviewService {
    List<ProgressReview>findAll();
    ProgressReview findById(Long progressReviewId);
    ProgressReview save(ProgressReview progressReview);
    List<ProgressReview> findAllByProjectId(Long projectId);
}
