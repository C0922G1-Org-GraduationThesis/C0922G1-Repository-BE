package com.example.be.repository;

import com.example.be.model.ProgressReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProgressReviewRepository extends JpaRepository<ProgressReview, Long> {
    @Query(value = "select * from  progress_review where project_id = :id",nativeQuery = true)
    List<ProgressReview> findAllByProjectId(@Param("id") Long projectId);
}
