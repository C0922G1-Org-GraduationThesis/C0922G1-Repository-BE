package com.example.be.repository;


import com.example.be.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IStudentRepository extends JpaRepository<Student, Long> {
    /**
     * Create by: HauNN
     * Date create: 29/03/2023
     * Function: find all student by name containing or code containing
     *
     * @Param: searchStr, pageable
     */
    @Query(value = "" +
            "SELECT " +
            "student_id," +
            "student_date_of_birth," +
            "student_name," +
            "student_code," +
            "student_email," +
            "account_id," +
            "clazz_id," +
            "team_id," +
            "flag_delete," +
            "flag_leader," +
            "question_id," +
            "student_address," +
            "student_gender," +
            "student_img," +
            "student_phone_number " +
            "FROM " +
            "`student` " +
            "WHERE (" +
            "student_name LIKE CONCAT('%',:searchStr,'%') " +
            "OR " +
            "student_code LIKE CONCAT('%',:searchStr,'%')) " +
            "AND flag_delete = 0 ",
            nativeQuery = true)
    Page<Student> findAllByNameOrStudentCode(@Param("searchStr") String searchStr, Pageable pageable);


    /**
     * Create by: HauNN
     * Date create: 29/03/2023
     * Function: find all student by team id
     *
     * @Param: teamId, pageable
     */
    @Query(value = "" +
            "SELECT " +
            "student_id," +
            "student_date_of_birth," +
            "student_name," +
            "student_code," +
            "student_email," +
            "account_id," +
            "clazz_id," +
            "team_id," +
            "flag_delete," +
            "flag_leader," +
            "question_id," +
            "student_address," +
            "student_gender," +
            "student_img," +
            "student_phone_number " +
            "FROM student " +
            "WHERE team_id =:teamId AND flag_delete = 0", nativeQuery = true)
    Page<Student> findAllByTeamId(@Param("teamId") Long teamId,
                                  Pageable pageable);
}

