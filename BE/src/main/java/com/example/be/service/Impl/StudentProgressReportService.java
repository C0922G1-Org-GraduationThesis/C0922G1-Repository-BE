package com.example.be.service.Impl;

import com.example.be.dto.IStudentProgressReportDTO;

import com.example.be.repository.IProgressReportRepository;

import com.example.be.service.IStudentProgressReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentProgressReportService implements IStudentProgressReportService{
    @Autowired
    private IProgressReportRepository progressReportRepository;
//    private IStudentProgressReportRepository studentProgressReportRepository ;

    @Override
    public List<IStudentProgressReportDTO> findStudentProgressReportProjectId(Long project_id) {

        return progressReportRepository.findStudentProgressReportProjectId(project_id);
    }

}
