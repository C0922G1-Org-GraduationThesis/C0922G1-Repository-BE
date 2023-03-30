package com.example.be.service;

import com.example.be.model.ProgressReport;

import java.util.List;

public interface IProgressReportService {
    /**
     * Created by: SyVT,
     * Date created : 29/03/2023
     * Function : FindAll
     */
    List<ProgressReport> findAllProgressReport();

    /**
     * Created by: SyVT,
     * Date created : 29/03/2023
     * Function : FindById
     */
    ProgressReport findProgressReportById(Long progressReportId);


    /**
     * Created by: SyVT,
     * Date created : 29/03/2023
     * Function : Save
     */
    void saveProgressReport(ProgressReport progressReport);
}
