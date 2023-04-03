package com.example.be.repository;

import com.example.be.dto.ProgressProjectDto;
import com.example.be.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


public interface IProjectRepository extends JpaRepository<Project, Long> {
    /**
     * Created by: VuLX
     * Date created: 01/04/2023
     */
    @Query(value = "select * from project where project.project_status = true and project_id = :id", nativeQuery = true)
    Project findProjectEnable(@Param("id") Long projectId);

    /**
     * Created by: VuLX
     * Date created: 01/04/2023
     */

    @Query(value = "select * from project where project.project_status = true", nativeQuery = true)
    List<Project> findProjectListEnable();

    /**
     * Created by: VuLX
     * Date created: 01/04/2023
     */
    @Transactional

    @Query(value = "select * from project where project_id = :id", nativeQuery = true)
    Optional<Project> findByAId(@Param("id") Long projectId);

    /**
     * Created by: VuLX
     * Date created: 01/04/2023
     */

    @Query(value = "select p.project_id as projectId, p.project_name as projectName," +
            " t.team_name as teamName, t.member_of_team as memberTotal, " +
            "p.project_status as status  from project p" +
            " join team t on p.team_id = t.team_id where p.project_id = :id", nativeQuery = true)
    Optional<ProgressProjectDto> findProgressDtoByProjectId(@Param("id") Long projectId);
}
