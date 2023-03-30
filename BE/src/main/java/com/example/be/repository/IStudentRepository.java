package com.example.be.repository;

import com.example.be.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IStudentRepository extends JpaRepository<Student,Long> {
    @Transactional
    @Modifying
    @Query(value = "insert into student (student_name,student_code,student_date_of_birth,student_email,student_phone_number,student_gender,student_address,student_img,clazz_id) " +
            "values(:student_name,:student_code,:student_date_of_birth,:student_email,:student_phone_number,:student_gender,:student_address,:student_img,:clazz_id)",
            nativeQuery = true)
    void addStudent(@Param("student_name") String studentName,
                    @Param("student_code") String studentCode,
                    @Param("student_date_of_birth") String studentDateOfBirth,
                    @Param("student_email") String studentEmail,
                    @Param("student_phone_number") String student_phone_number,
                    @Param("student_gender") boolean studentGender,
                    @Param("student_address") String studentAddress,
                    @Param("student_img") String studentImg,
                    @Param("clazz_id") Long clazzId);

}
