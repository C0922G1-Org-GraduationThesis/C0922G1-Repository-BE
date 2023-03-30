package com.example.be.repository;

import com.example.be.model.ProgressReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IProgressReviewRepository extends JpaRepository<ProgressReview, Long> {

}
