package com.example.be.repository;

import com.example.be.dto.TeacherDto;
import com.example.be.model.Team;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ITeamRepository extends JpaRepository<Team, Long> {
    /**
     * Created by: DucND
     * Date create: 29/03/2023
     * Function: display list teacher with column teacher_name, registration status and paging
     * @param: pageable
     * @return get all list teacher
     */
    @Query(value = "select tc.teacher_name as teacher, count(t.teacher_id) as total\n" +
            "            from teacher as tc\n" +
            "            left join team as t on t.teacher_id = tc.teacher_id\n" +
            "            left join project as p on p.team_id = t.team_id\n" +
            "where p.project_status = false or p.project_status is null\n" +
            "            group by tc.teacher_id",
            countQuery = "select tc.teacher_name as teacher, count(t.teacher_id) as total\n" +
                    "            from teacher as tc\n" +
                    "            left join team as t on t.teacher_id = tc.teacher_id\n" +
                    "            left join project as p on p.team_id = t.team_id\n" +
                    "where p.project_status = false or p.project_status is null\n" +
                    "            group by tc.teacher_id",
            nativeQuery = true)
    Page<TeacherDto> getAllInstructor(Pageable pageable);

    /**
     * Created by: DucND
     * Date create: 29/03/2023
     * Function: find team by id
     * @param: teamId
     * @return the team you are looking for
     */
    @Query(value = "select * from team where team_id = :teamId ", nativeQuery = true)
    Team findTeamById(@Param("teamId") Long teamId);

    /**
     * Created by: DucND
     * Date create: 29/03/2023
     * Function: edit team,create teacher for group
     * @param: teacherId and teamId
     * @result change instructor of team
     */
    @Modifying
    @Query(value = "update team set teacher_id = :teacherId where team_id = :teamId", nativeQuery = true)
    void updateTeam(@Param("teacherId") Long teacherId, @Param("teamId") Long teamId);
}
