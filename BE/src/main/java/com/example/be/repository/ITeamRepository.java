package com.example.be.repository;


import com.example.be.dto.ITeamDto;
import com.example.be.dto.TeacherDto;
import com.example.be.model.Teacher;
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
     *
     * @return get all list teacher
     * @param: pageable
     */
    @Query(value = "select tc.teacher_id as teacherId, tc.teacher_name as teacherName, count(t.teacher_id) as total\n" +
            "            from teacher as tc\n" +
            "            left join team as t on t.teacher_id = tc.teacher_id\n" +
            "            left join project as p on p.team_id = t.team_id\n" +
            "          group by tc.teacher_id",
            countQuery = "select tc.teacher_id as teacherId, tc.teacher_name as teacher, count(t.teacher_id) as total\n" +
                    "            from teacher as tc\n" +
                    "            left join team as t on t.teacher_id = tc.teacher_id\n" +
                    "            left join project as p on p.team_id = t.team_id\n" +
                    "          group by tc.teacher_id",
            nativeQuery = true)
    Page<TeacherDto> getAllInstructor(Pageable pageable);


//    @Query(value = " select team.team_id, team.team_name. team.student_id " +
//            "from student join team on student.team_id = team.team_id " +
//            "where student.account_id = :accountId and student.flag_leader = true",nativeQuery = true)
//    Team findTeamByAccount(@Param("accountId") Long accountId);

    /**
     * Created by: DucND
     * Date create: 29/03/2023
     * Function: find team by id
     *
     * @return the team you are looking for
     * @param: teamId
     */
    @Query(value = "select t.team_id as teamId, t.member_of_team as memberOfTeam, " +
            "t.team_name as teamName, tc.teacher_id as teacherId, tc.teacher_name as teacherName " +
            "from team as t left join teacher as tc on t.teacher_id = tc.teacher_id " +
            "where team_id = :teamId ", nativeQuery = true)
    ITeamDto findTeamById(@Param("teamId") Long teamId);


    /**
     * Created by: DucND
     * Date create: 29/03/2023
     * Function: edit team,create teacher for group
     *
     * @param: teacherId and teamId
     * @result change instructor of team
     */
    @Modifying
    @Query(value = "update team set teacher_id = :teacherId where team_id = :teamId", nativeQuery = true)
    void updateTeam(@Param("teacherId") Long teacherId, @Param("teamId") Long teamId);

}
