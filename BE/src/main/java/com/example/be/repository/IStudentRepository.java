package com.example.be.repository;

import com.example.be.dto.StudentDto1;
import com.example.be.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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
            "WHERE (team_id =:teamId AND flag_delete = 0)",
            nativeQuery = true)
    Page<Student> findAllByTeamId(@Param("teamId") Long teamId,
                                  Pageable pageable);

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
            "WHERE student_id =:id AND flag_delete = 0", nativeQuery = true)
    Optional<Student> findById(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query(value = "insert into student (student_name,student_code,student_date_of_birth,student_email,student_phone_number,student_gender,student_address,student_img,clazz_id) " +
            "values(:student_name,:student_code,:student_date_of_birth,:student_email,:student_phone_number,:student_gender,:student_address,:student_img,:clazz_id)",
            nativeQuery = true)
    void addStudent(@Param("student_name") String studentName,
                    @Param("student_code") String studentCode,
                    @Param("student_date_of_birth") String studentDateOfBirth,
                    @Param("student_email") String studentEmail,
                    @Param("student_phone_number") String studentPhoneNumber,
                    @Param("student_gender") boolean studentGender,
                    @Param("student_address") String studentAddress,
                    @Param("student_img") String studentImg,
                    @Param("clazz_id") Long clazzId);

    @Query(value = "select * from student where student_id= :studentId",nativeQuery = true)
    Student findById(@Param("studentId") long studentId);

    @Transactional
    @Modifying
    @Query(value = "update student set student_name = :student_name,student_code = :student_code,student_date_of_birth = :student_date_of_birth," +
            "student_email = :student_email,student_phone_number = :student_phone_number, student_gender = :student_gender," +
            "student_address = :student_address,student_img = :student_img, clazz_id = :clazz_id where student_id = :student_id", nativeQuery = true)
    void updateStudent(
            @Param("student_name") String studentName,
            @Param("student_code") String studentCode,
            @Param("student_date_of_birth") String StudentDateOfBirth,
            @Param("student_email") String studentEmail,
            @Param("student_phone_number") String studentPhoneNumber,
            @Param("student_gender") boolean studentGender,
            @Param("student_address") String studentAddress,
            @Param("student_img") String studentImg,
            @Param("clazz_id") Long clazzId,
            @Param("student_id") long studentId);

    @Query(value = "select MAX(student_id) as studentId from student",
            countQuery = "select MAX(student_id) as studentId from student"
            ,nativeQuery = true)
    Long getStudentId();

    /**
     * Create by : VinhLD
     * Date create 29/03/2023
     * Function: show list student
     *
     * @param pageable
     * @param nameSearch
     * @return json list student
     */
    @Query(value = "select `student`.student_id as studentId, `student`.student_code as studentCode,`student`.student_img as studentImg, `student`.student_name as studentName, `student`.student_email as studentEmail, `student`.student_phone_number as studentPhoneNumber, `clazz`.clazz_name as nameClazz from `student` join `clazz` on `student`.clazz_id = `clazz`.clazz_id where `student`.student_name like %:nameSearch% and `student`.flag_delete= false",
            countQuery = "select `student`.student_id as studentId, `student`.student_code as studentCode,`student`.student_img as studentImg, `student`.student_name as studentName, `student`.student_email as studentEmail, `student`.student_phone_number as studentPhoneNumber, `clazz`.clazz_name as nameClazz from `student` join `clazz` on `student`.clazz_id = `clazz`.clazz_id where `student`.student_name like %:nameSearch% and `student`.flag_delete= false", nativeQuery = true)
    Page<StudentDto1> getStudentList(Pageable pageable, @Param("nameSearch") String nameSearch);
}
