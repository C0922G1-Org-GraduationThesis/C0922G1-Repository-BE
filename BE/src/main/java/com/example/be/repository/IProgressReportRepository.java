package com.example.be.repository;

import com.example.be.model.ProgressReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProgressReportRepository extends JpaRepository<ProgressReport, Long> {
}
