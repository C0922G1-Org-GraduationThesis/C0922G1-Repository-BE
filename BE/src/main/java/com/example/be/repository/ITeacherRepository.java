package com.example.be.repository;

import com.example.be.dto.ITeacherDto;
import com.example.be.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ITeacherRepository extends JpaRepository<Teacher, Long> {

    @Query(value = "select t.teacher_id as teacherId, t.teacher_name as teacherName " +
            ",t.teacher_code as teacherCode, t.teacher_img as teacherImg,t.teacher_phone_number as teacherPhoneNumber " +
            ",t.teacher_email as teacherEmail, t.teacher_address as teacherAddress, t.teacher_date_of_birth as teacherDateOfBirth " +
            ",t.teacher_gender as teacherGender, f.faculty_name as faculty, d.degree_name as degree from teacher as t " +
            "             join faculty as f on f.faculty_id = t.faculty_id\n" +
            "             join degree as d on d.degree_id = t.degree_id\n" +
            "where t.teacher_id = :id and t.flag_delete = 0;", nativeQuery = true)
    Optional<ITeacherDto> findTeacherById(@Param("id") Long id);
}
