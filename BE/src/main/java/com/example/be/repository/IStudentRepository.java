package com.example.be.repository;

import com.example.be.dto.IMailStudentDto;
import com.example.be.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IStudentRepository extends JpaRepository<Student,Long> {

    /**
     * Created by: NuongHT
     * Date create: 29/03/2023
     */
    @Modifying
    @Query(value = "select s.student_id as studentId,t.team_id as teamId,p.project_id as projectId,p.project_name as projectName,t.team_name as teamName,s.student_email as email from student as s join project p on s.team_id = p.team_id join team t on p.team_id = t.team_id join teacher te on te.teacher_id = t.teacher_id where t.team_id = :teamId", nativeQuery = true)
    List<IMailStudentDto> getInfomation(@Param("teamId") Long teamId);


}
