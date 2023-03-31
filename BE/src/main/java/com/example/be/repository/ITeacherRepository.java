package com.example.be.repository;

import com.example.be.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ITeacherRepository extends JpaRepository<Teacher, Long> {

    /**
     * Created by: TienP
     * Date: 29/03/2023
     * function: findTeacherByEmail
     */
    @Query(value = "select * from teacher where teacher_email= :email", nativeQuery = true)
    Teacher findTeacherByEmail(@Param("email") String email);

    Teacher findTeacherByTeacherId(Long id);

    /**
     * Created by:TienP
     * Date: 29/03/2023
     * function: updateTeacherRoleAdmin
     */
    @Modifying
    @Query(nativeQuery = true, value = " update teacher as t" +
            " set t.teacher_name= :teacherName," +
            " t.teacher_email=:email," +
            " t.teacher_phone_number= :phoneNumber," +
            " t.teacher_address= :teacherAddress," +
            " where t.teacher_id= :id")
    void updateTeacherRoleAdmin(
            @Param("teacherName") String teacherName,
            @Param("email") String email,
            @Param("phoneNumber") String phoneNumber,
            @Param("teacherAddress") String teacherAddress,
            @Param("id") Long id);
}
