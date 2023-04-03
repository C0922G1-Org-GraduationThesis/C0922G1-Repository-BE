package com.example.be.controller;

import com.example.be.dto.ProgressReviewDto;
import com.example.be.dto.ProjectDTO;
import com.example.be.model.*;
import com.example.be.repository.IProgressDetailRepository;
import com.example.be.service.IProgressDetailService;
import com.example.be.service.IProgressReviewService;
import com.example.be.service.IProjectService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
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
    @Autowired
    private IProgressDetailRepository progressDetailRepository;
    Long projectId = 0L;

    /**
     * Created by: VuLX
     * Date created: 29/3/2023
     * Function: display list progress-review
     *
     * @return HttpStatus.NO_CONTENT if result is null or HttpStatusOK if result is not null
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
     * @return HttpStatus.NO_CONTENT if result is null or HttpStatusOK if result is not null
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
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String formattedDate = formatter.format(date);
        progressReviews.setProgressReviewDateCreate(formattedDate);
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
        progressDetailRepository.save(progressDetail);
        progressDetailRepository.save(progressDetailNext);
        ProgressReview progressReview = progressReviewService.saveProgressReview(progressReviews);

        return new ResponseEntity<>(progressReview, HttpStatus.OK);
    }


    /**
     * Created by: VuLX
     * Date created: 29/3/2023
     * Function: find progress-review by id
     *
     * @return HttpStatus.NO_CONTENT if result is null or HttpStatusOK if result is not null
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
     * @return HttpStatus.NO_CONTENT if result is null or HttpStatusOK if result is not null
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
     * @return HttpStatus.NO_CONTENT if result is null or HttpStatusOK if result is not null
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
     * @return HttpStatus.NO_CONTENT if result is null or HttpStatusOK if result is not null
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
     * @return HttpStatus.NO_CONTENT if result is null or HttpStatusOK if result is not null
     */

    @GetMapping("api/progressDetail/list/{projectId}")
    public ResponseEntity<List<ProgressDetail>> findAllByProjectId(@PathVariable Long projectId) {
        List<ProgressDetail> progressDetails = progressDetailService.findAllByProjectId(projectId);
        if (progressDetails == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(progressDetails, HttpStatus.OK);
    }


    /**
     * Created by: VuLX
     * Date created: 01/04/2023
     * Function: find project By projectId
     *
     * @return HttpStatus.NO_CONTENT if result is null or HttpStatusOK if result is not null
     */
    @GetMapping("api/progressReview/project/{projectId}")
    public ResponseEntity<ProjectDTO> findProjectDtoById(@PathVariable Long projectId) {
        Project project = projectService.findById(projectId);
        if (project == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ProjectDTO projectDto = new ProjectDTO();
        BeanUtils.copyProperties(project, projectDto);
        this.projectId = projectId;
        System.out.println(this.projectId);
        return new ResponseEntity<>(projectDto, HttpStatus.OK);
    }


    /**
     * Created by: SyVT
     * Date created: 29/3/2023
     * Function: find Max Percent progress-review by id
     *
     * @return HttpStatus.NO_CONTENT if result is null or HttpStatusOK if result is not null
     */
    @GetMapping("/api/progress-reviews/{project_id}/{stage_id}")
    public ResponseEntity<?> findMaxPercentProgressReport(@PathVariable Long project_id, @PathVariable int stage_id) {
        int progressReportPercent = progressReviewService.findMaxPercentProgressReport(project_id, stage_id);
        if (progressReportPercent == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(progressReportPercent, HttpStatus.OK);

    }

    boolean flag = false;

    @Scheduled(cron = "0 44 22 * * ?")
    public void changeStatusProgressDetailAuto() {
        System.out.println(this.projectId);
        this.flag = true;
        changeProgressDetailStatus(this.projectId);
    }

    @GetMapping("/api/progressReview/saveAuto/{projectId}")
    public void changeProgressDetailStatus(@PathVariable Long projectId) {
        Project project = projectService.findById(projectId);
        System.out.println(this.projectId + "68686868");
        ProgressDetail progressDetailAuto = progressDetailService.findProgressDetailByProjectId(projectId);
        if (progressDetailAuto.getStage().getStageId() == 4 && flag) {
            progressDetailAuto.setProgressStatus(false);
            project.setProjectStatus(false);
            if (progressDetailAuto.getStage().getStageId() < 4 && flag)
                progressDetailAuto.setProgressStatus(false);
            ProgressDetail progressDetailNext = progressDetailService.findById(progressDetailAuto.getProgressDetailId() + 1);
            progressDetailNext.setProgressStatus(true);
            progressDetailRepository.save(progressDetailAuto);
            progressDetailRepository.save(progressDetailNext);
            System.out.println(progressDetailNext.getProgressStatus());
        }
        System.out.println("a hi hi đồ ngốc");
    }
//Sau 17 giây sẽ tự động insert vào
//    @Scheduled(fixedDelay = 17000)
//    public void saveProgressDetailAuto() {
//        saveAutoProgressDetail();
//    }

    public void saveAutoProgressDetail() {
        System.out.println("aaaaa");
        List<Project> projectList = projectService.findProjectListEnableAndSetStatusIsTrue();
        Stage stage1 = new Stage();
        stage1.setStageId(1);
        Stage stage2 = new Stage();
        stage2.setStageId(2);
        Stage stage3 = new Stage();
        stage3.setStageId(3);
        Stage stage4 = new Stage();
        stage4.setStageId(4);
        for (Project project1 : projectList) {
            ProgressDetail progressDetail1 = new ProgressDetail("Báo cáo giai đoạn 1", 1, "2023-03-01", "2023-03-30", true, project1.getProjectId(), stage1);
            ProgressDetail progressDetail2 = new ProgressDetail("Báo cáo giai đoạn 2", 0, "2023-04-01", "2023-04-30", false, project1.getProjectId(), stage2);
            ProgressDetail progressDetail3 = new ProgressDetail("Báo cáo giai đoạn 3", 0, "2023-05-01", "2023-05-30", false, project1.getProjectId(), stage3);
            ProgressDetail progressDetail4 = new ProgressDetail("Báo cáo giai đoạn 4", 0, "2023-06-01", "2023-06-30", false, project1.getProjectId(), stage4);
            if (project1.getProjectStatus()) {
                progressDetailRepository.save(progressDetail1);
                progressDetailRepository.save(progressDetail2);
                progressDetailRepository.save(progressDetail3);
                progressDetailRepository.save(progressDetail4);
            }
        }

    }


}
