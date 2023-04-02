package com.example.be.repository;

import com.example.be.dto.StudentDto;
import com.example.be.dto.StudentInfo;
import com.example.be.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IStudentRepository extends JpaRepository<Student,Long> {

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
    Page<StudentDto> getStudentList(Pageable pageable, @Param("nameSearch") String nameSearch);



    /**
     * Create by : VinhLD
     * Date create 29/03/2023
     * Function: show the instructor's list of students
     *
     * @param pageable
     * @param nameSearch
     * @param idTeacher
     * @return json the instructor's list of students
     */
    @Query(value = "select `student`.student_id as idStudent, `student`.student_code as codeStudent,`student`.student_name as nameStudent,`student`.student_email as emailStudent, `student`.student_phone_number as phoneNumberStudent,`student`.student_img as imgStudent, `clazz`.clazz_name as nameClazz, `teacher`.teacher_name as nameTeacher from `student` join `clazz` on `student`.clazz_id=`clazz`.clazz_id join `team` on `student`.team_id= `team`.team_id join `teacher` on `team`.teacher_id= teacher.teacher_id where `student`.student_name like %:nameSearch% and `student`.flag_delete =false and `teacher`.teacher_id= :idTeacher",
            countQuery = "select `student`.student_id as idStudent, `student`.student_code as codeStudent,`student`.student_name as nameStudent,`student`.email as emailStudent, `student`.phone_number as phoneNumberStudent,`student`.img as imgStudent, `clazz`.clazz_name as nameClazz, `teacher`.teacher_name as nameTeacher from `student` join `clazz` on `student`.clazz_id=`clazz`.clazz_id join `team` on `student`.team_id= `team`.team_id join `teacher` on `team`.teacher_id= teacher.teacher_id where `student`.student_name like %:nameSearch% and `student`.flag_delete =false and `teacher`.teacher_id= :idTeacher", nativeQuery = true)
    Page<StudentInfo> findAllStudent(Pageable pageable, @Param("nameSearch") String nameSearch, @Param("idTeacher") Long idTeacher);



}
