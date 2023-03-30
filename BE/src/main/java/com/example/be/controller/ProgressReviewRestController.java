package com.example.be.controller;

import com.example.be.dto.ProgressReviewDto;
import com.example.be.model.ProgressReview;
import com.example.be.model.Project;
import com.example.be.model.Teacher;
import com.example.be.service.IProgressReviewService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@CrossOrigin("*")

public class ProgressReviewRestController {
    @Autowired
    private IProgressReviewService progressReviewService;

    /**
     * Created by: VuLX
     * Date created: 29/3/2023
     * Function: display list progress-review

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
     * Function: create new progress-review
     * @return HttpStatus.NO_CONTENT if result is null or HttpStatus.OK if result is not null
     */

    @PostMapping("api/progressReview/save")
    public ResponseEntity<?> saveProgressReview(@Valid @RequestBody ProgressReviewDto progressReviewsDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getFieldError(),HttpStatus.NOT_ACCEPTABLE);
        }
        ProgressReview progressReviews = new ProgressReview();
        BeanUtils.copyProperties(progressReviewsDto,progressReviews);
        Teacher teacher = new Teacher();
        teacher.setTeacherId(progressReviewsDto.getTeacherDto().getTeacherId());
        Project project = new Project();
        project.setProjectId(progressReviewsDto.getProjectDto().getProjectId());
        progressReviews.setProject(project);
        progressReviews.setTeacher(teacher);
        ProgressReview progressReview = progressReviewService.save(progressReviews);
        return new ResponseEntity<>(progressReview, HttpStatus.OK);
    }

    /**
     * Created by: VuLX
     * Date created: 29/3/2023
     * Function: find progress-review by id
     * @return HttpStatus.NO_CONTENT if result is null or HttpStatus.OK if result is not null
     */
    @GetMapping("api/progressReview/{progressReviewId}")
        public ResponseEntity<?>findProgressReview(@PathVariable Long progressReviewId){
        ProgressReview progressReview = progressReviewService.findById(progressReviewId);
        if (progressReview == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(progressReview, HttpStatus.CREATED);
        }

    /**
     * Created by: VuLX
     * Date created: 30/3/2023
     * Function: find progress-review by projectId
     * @return HttpStatus.NO_CONTENT if result is null or HttpStatus.OK if result is not null
     */

        @GetMapping("api/progressReview/list/{projectId}")
        public ResponseEntity<List<ProgressReview>>findProgressReviewByProjectId(@PathVariable Long projectId){
       List<ProgressReview> progressReviews = progressReviewService.findAllByProjectId(projectId);
       if (progressReviews == null){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
       return new ResponseEntity<>(progressReviews,HttpStatus.OK);
        }
}
