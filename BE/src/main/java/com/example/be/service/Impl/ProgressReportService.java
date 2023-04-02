package com.example.be.service.Impl;

import com.example.be.model.ProgressReport;
import com.example.be.repository.IProgressReportRepository;
import com.example.be.service.IProgressReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgressReportService implements IProgressReportService {
    @Autowired
    private IProgressReportRepository progressReportRepository;

    @Override
    public List<ProgressReport> findAllProgressReport() {
        return progressReportRepository.findAllProgressReport();
    }

    @Override
    public List<ProgressReport> findAllProgressReportByProjectIdAndStageId(Long projectId, int stageId) {
        return progressReportRepository.findProgressReportByStageIdAndProjectId(projectId,stageId);
    }

    @Override
    public ProgressReport findProgressReportMaxPercentByStageIdAndProjectId(Long projectId, int stageId) {
        return progressReportRepository.findProgressReportMaxPercentByStageIdAndProjectId(projectId,stageId);
    }

    @Override
    public ProgressReport findProgressReportById(Long progressReportId) {
        return progressReportRepository.findProgressReportById(progressReportId);
    }

    @Override
    public void saveProgressReport(ProgressReport progressReport) {
        progressReportRepository.save(progressReport);
    }


}
