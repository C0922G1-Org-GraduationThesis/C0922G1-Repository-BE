package com.example.be.repository;

import com.example.be.model.ProgressReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface IProgressReviewRepository extends JpaRepository<ProgressReview, Long> {
    /**
     * Created by: VuLX
     * Date created: 01/04/2023
     */
    @Query(value = "select * from  progress_review p where p.project_id = :id order by p.progress_review_date_create desc", nativeQuery = true)
    List<ProgressReview> findAllByProjectId(@Param("id") Long projectId);


    /**
     * Created by: SyVT,
     * Date created : 30/03/2023
     * Function : Find Max Percent Progress Report
     */
    @Query(value = "SELECT\n" +
            "    MAX(prv.progress_review_percent)\n" +
            "    FROM\n" +
            "    progress_review prv\n" +
            "    JOIN\n" +
            "    project p ON prv.project_id = p.project_id\n" +
            "            JOIN\n" +
            "    progress_report pr ON pr.project_id = p.project_id\n" +
            "            WHERE\n" +
            "    p.project_id = :project_id AND pr.stage_id = :stage_id",
            nativeQuery = true)
    int findMaxPercentProgressReport(@Param("project_id") Long project_id, @Param("stage_id") int stage_id);

}
