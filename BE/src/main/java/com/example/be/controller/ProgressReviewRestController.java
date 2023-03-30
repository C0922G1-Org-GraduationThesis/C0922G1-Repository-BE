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
     * Created by: VuLX
     * Date created: 29/3/2023
     * Function: display list progress-review
     *
     * @return HttpStatus.NO_CONTENT if result is null or HttpStatus.OK if result is not null
     */

    @GetMapping("api/progressReview")
    public ResponseEntity<List<ProgressReview>> findAll() {
        List<ProgressReview> progressReviews = progressReviewService.findAll();
        if (progressReviews == null) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(progressReviews, HttpStatus.OK);
    }

    /**
     * Created by: VuLX
     * Date created: 29/3/2023
     * Function: create  progress-review
     *
     * @return HttpStatus.NO_CONTENT if result is null or HttpStatus.OK if result is not null
     */

    @PostMapping("api/progressReview/save")
    public ResponseEntity<?> saveProgressReview(@RequestBody ProgressReview progressReviews) {
        ProgressReview progressReview = progressReviewService.save(progressReviews);
        return new ResponseEntity<>(progressReviews, HttpStatus.OK);
    }

    /**
     * Created by: VuLX
     * Date created: 29/3/2023
     * Function: find progress-review by id
     *
     * @return HttpStatus.NO_CONTENT if result is null or HttpStatus.OK if result is not null
     */
    @GetMapping("api/progressReview/{id}")
    public ResponseEntity<?> findProgressReview(@PathVariable Long progressReviewId) {
        ProgressReview progressReview = progressReviewService.findById(progressReviewId);
        if (progressReview == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(progressReview, HttpStatus.CREATED);
    }
}
