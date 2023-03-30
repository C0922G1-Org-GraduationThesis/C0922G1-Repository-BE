package com.example.be.controller;

import com.example.be.model.ProgressReview;
import com.example.be.service.IProgressReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/progress-reviews")
public class ProgressReviewRestController {
    @Autowired
    private IProgressReviewService progressReviewService;


    /**
     * Created by: SyVT
     * Date created: 29/3/2023
     * Function: find progress-review by id
     *
     * @return HttpStatus.NO_CONTENT if result is null or HttpStatus.OK if result is not null
     */
    @GetMapping("{id}")
    public ResponseEntity<?> findMaxPercentProgressReport(@PathVariable Long project_id, @PathVariable int stage_id) {
        int progressReportPercent = progressReviewService.findMaxPercentProgressReport(project_id, stage_id);
        if (progressReportPercent == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(progressReportPercent, HttpStatus.OK);
    }
}
