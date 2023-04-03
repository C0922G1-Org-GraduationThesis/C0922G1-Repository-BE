package com.example.be.repository;

import com.example.be.model.ProgressDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProgressDetailRepository extends JpaRepository<ProgressDetail, Long> {
    /**
     * Created by: VuLX
     * Date created: 01/04/2023
     */
    @Query(value = "select * from progress_detail p where project_id = :id ", nativeQuery = true)
    List<ProgressDetail> findProgressDetailByIdAndOrderDateCreateDesc(@Param("id") Long projectId);

    /**
     * Created by: VuLX
     * Date created: 01/04/2023
     */
    @Query(value = "select * from progress_detail where project_id = :id and progress_status = 1", nativeQuery = true)
    ProgressDetail findProgressDetailByProjectId(@Param("id") Long projectId);
}
