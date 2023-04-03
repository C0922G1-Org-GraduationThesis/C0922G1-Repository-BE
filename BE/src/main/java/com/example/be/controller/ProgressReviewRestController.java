package com.example.be.controller;

import com.example.be.dto.ProgressReviewDto;
import com.example.be.dto.ProjectDto;
import com.example.be.model.ProgressDetail;
import com.example.be.model.ProgressReview;
import com.example.be.model.Project;
import com.example.be.model.Teacher;
import com.example.be.service.IProgressDetailService;
import com.example.be.service.IProgressReviewService;
import com.example.be.service.IProjectService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@CrossOrigin("*")

public class ProgressReviewRestController {
    @Autowired
    private IProgressReviewService progressReviewService;
    @Autowired
    private IProgressDetailService progressDetailService;
    @Autowired
    private IProjectService projectService;

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
     * Function: create new progress-review
     *
     * @return HttpStatus.NO_CONTENT if result is null or HttpStatus.OK if result is not null
     */

    @PostMapping("api/progressReview/save/{projectId}")
    public ResponseEntity<?> saveProgressReview(@PathVariable Long projectId, @Valid @RequestBody ProgressReviewDto progressReviewsDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldError(), HttpStatus.NOT_ACCEPTABLE);
        }
        ProgressReview progressReviews = new ProgressReview();
        BeanUtils.copyProperties(progressReviewsDto, progressReviews);
        Project project = projectService.findById(projectId);
        progressReviews.setProject(project);
        Teacher teacher = project.getTeam().getTeacher();
        progressReviews.setTeacher(teacher);
        Date date = new Date();
        progressReviews.setProgressReviewDateCreate(date.toString());
        ProgressDetail progressDetail = progressDetailService.findProgressDetailByProjectId(projectId);
        progressDetail.setProgressDetailPercent(progressReviews.getProgressReviewPercent());
        ProgressDetail progressDetailNext = progressDetailService.findById(progressDetail.getProgressDetailId() + 1);
        if (progressReviews.getProgressReviewPercent() == 100 && progressDetail.getProgressDetailId() < 4) {
            progressDetail.setProgressStatus(false);
            progressDetailNext.setProgressStatus(true);
        }
        if (progressDetail.getStage().getStageId() == 4 && progressDetail.getProgressDetailPercent() == 100) {
            progressDetail.setProgressStatus(false);
            project.setProjectStatus(false);
        }
        ProgressReview progressReview = progressReviewService.save(progressReviews);

        return new ResponseEntity<>(progressReview, HttpStatus.OK);
    }

    /**
     * Created by: VuLX
     * Date created: 29/3/2023
     * Function: find progress-review by id
     *
     * @return HttpStatus.NO_CONTENT if result is null or HttpStatus.OK if result is not null
     */
    @GetMapping("api/progressReview/{progressReviewId}")
    public ResponseEntity<?> findProgressReview(@PathVariable Long progressReviewId) {
        ProgressReview progressReview = progressReviewService.findById(progressReviewId);
        if (progressReview == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(progressReview, HttpStatus.CREATED);
    }

    /**
     * Created by: VuLX
     * Date created: 30/3/2023
     * Function: find progress-review by projectId
     *
     * @return HttpStatus.NO_CONTENT if result is null or HttpStatus.OK if result is not null
     */

    @GetMapping("api/progressReview/list/{projectId}")
    public ResponseEntity<List<ProgressReview>> findProgressReviewByProjectId(@PathVariable Long projectId) {
        List<ProgressReview> progressReviews = progressReviewService.findAllByProjectId(projectId);
        if (progressReviews == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(progressReviews, HttpStatus.OK);
    }

    /**
     * Created by: VuLX
     * Date created: 01/04/2023
     * <p>
     * Function: find list-progress-review by record
     *
     * @return HttpStatus.NO_CONTENT if result is null or HttpStatus.OK if result is not null
     */

    @GetMapping("api/progressReview/list/{projectId}/{record}")
    public ResponseEntity<List<ProgressReview>> findProgressReviewByProjectId(@PathVariable Long projectId, @PathVariable int record) {
        List<ProgressReview> progressReviews = progressReviewService.findAllByProjectIdAndRecord(projectId, record);
        if (progressReviews == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(progressReviews, HttpStatus.OK);
    }

    /**
     * Created by: VuLX
     * Date created: 02/04/2023
     * Function: find size-list-progress-detail
     *
     * @return HttpStatus.NO_CONTENT if result is null or HttpStatus.OK if result is not null
     */

    @GetMapping("api/progressReview/size/{projectId}")
    public ResponseEntity<?> findMaxSizeProgressReviewByProjectId(@PathVariable Long projectId) {
        int maxSize = progressReviewService.findAllByProjectIdAndSize(projectId);
        return new ResponseEntity<>(maxSize, HttpStatus.OK);
    }

    /**
     * Created by: VuLX
     * Date created: 01/04/2023
     * Function: find list-progress-detail
     *
     * @return HttpStatus.NO_CONTENT if result is null or HttpStatus.OK if result is not null
     */

    @GetMapping("api/progressDetail/list/{projectId}")
    public ResponseEntity<List<ProgressDetail>> findAllByProjectId(@PathVariable Long projectId) {
        List<ProgressDetail> progressDetails = progressDetailService.findAllByProjectId(projectId);
        if (progressDetails == null) {
            return new ResponseEntity<List<ProgressDetail>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<ProgressDetail>>(progressDetails, HttpStatus.OK);
    }


    /**
     * Created by: VuLX
     * Date created: 01/04/2023
     * Function: find project By projectId
     *
     * @return HttpStatus.NO_CONTENT if result is null or HttpStatus.OK if result is not null
     */
    @GetMapping("api/progressReview/project/{projectId}")
    public ResponseEntity<ProjectDto> findProjectDtoById(@PathVariable Long projectId) {
        Project project = projectService.findById(projectId);
        if (project == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ProjectDto projectDto = new ProjectDto();
        BeanUtils.copyProperties(project, projectDto);
        return new ResponseEntity<>(projectDto, HttpStatus.OK);
    }
}
