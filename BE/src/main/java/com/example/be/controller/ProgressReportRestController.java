package com.example.be.controller;

import com.example.be.dto.ProgressReportDTO;
import com.example.be.model.ProgressReport;
import com.example.be.service.IProgressReportService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/progress-reports")
public class ProgressReportRestController {

    @Autowired
    private IProgressReportService progressReportService;

    /**
     * Created by: SyVT,
     * Date created : 29/03/2023
     * Function : Save ProgressReport
     *
     * @return HttpStatus.CREATED if result is not error or HttpStatus.NOT_ACCEPTABLE if no content
     */
    @PostMapping()
    public ResponseEntity<?> saveProgressReport(@Validated @RequestBody ProgressReport progressReport, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.NOT_ACCEPTABLE);
        }
        this.progressReportService.saveProgressReport(progressReport);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Created by: SyVT,
     * Date created : 29/03/2023
     * Function : find All ProgressReport
     *
     * @return HttpStatus.OK if result is not error or HttpStatus.NO_CONTENT if no content
     */
    @GetMapping()
    public ResponseEntity<List<ProgressReport>> findAllProgressReport() {
        List<ProgressReport> progressReportList = progressReportService.findAllProgressReport();
        if (progressReportList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(progressReportList, HttpStatus.OK);
    }

    /**
     * Created by: SyVT,
     * Date created : 29/03/2023
     * Function : find ProgressReport By progressReportId
     *
     * @return HttpStatus.OK if result is not error or HttpStatus.NO_CONTENT if no content
     */
    @GetMapping("/{id}")
    public ResponseEntity<ProgressReport> findProgressReportById(@PathVariable Long id) {
        ProgressReport progressReport = progressReportService.findProgressReportById(id);
        if (progressReport == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(progressReport, HttpStatus.OK);
    }

    /**
     * Created by: SyVT,
     * Date created : 29/03/2023
     * Function : find ProgressReport By projectId and stageId
     *
     * @return HttpStatus.OK if result is not error or HttpStatus.NO_CONTENT if no content
     */
    @GetMapping("/{project_id}/{stage_id}")
    public ResponseEntity<List<ProgressReport>> findProgressReportByProjectIdAndStageId(@PathVariable("project_id") Long projectId,
                                                                                        @PathVariable("stage_id") int stageId) {
        List<ProgressReport> progressReportList = progressReportService.findAllProgressReportByProjectIdAndStageId(projectId, stageId);
        if (progressReportList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(progressReportList, HttpStatus.OK);
    }

    /**
     * Created by: SyVT,
     * Date created : 29/03/2023
     * Function : find ProgressReport By projectId and stageId
     *
     * @return HttpStatus.OK if result is not error or HttpStatus.NO_CONTENT if no content
     */
    @GetMapping("/maxPercent/{project_id}/{stage_id}")
    public ResponseEntity<ProgressReport> findProgressReportMaxPercentByProjectIdAndStageId(@PathVariable("project_id") Long projectId,
                                                                                            @PathVariable("stage_id") int stageId) {
        ProgressReport progressReport = progressReportService.findProgressReportMaxPercentByStageIdAndProjectId(projectId, stageId);
        if (progressReport == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(progressReport, HttpStatus.OK);
    }
}
