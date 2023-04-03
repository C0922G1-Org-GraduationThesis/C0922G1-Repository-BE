package com.example.be.repository;

import com.example.be.model.ProgressReview;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProgressReviewRepository extends JpaRepository<ProgressReview, Long> {
    /**
     * Created by: VuLX
     * Date created: 01/04/2023
     */
    @Query(value = "select * from  progress_review p where p.project_id = :id order by p.progress_review_date_create desc", nativeQuery = true)
    List<ProgressReview> findAllByProjectId(@Param("id") Long projectId);
}
