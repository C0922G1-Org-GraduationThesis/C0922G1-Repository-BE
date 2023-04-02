package com.example.be.repository;


import com.example.be.dto.ITeacherDto;
import com.example.be.model.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import javax.transaction.Transactional;
import java.util.Optional;

public interface ITeacherRepository extends JpaRepository<Teacher, Long> {
    /**
     * create by : HungPV ,
     * Date Create : 29/03/2023
     * Function : show list has paging and search
     *
     * @param name
     * @param pageable
     * @return Page<ITeacherDto>
     */
    @Query(value = "select `teacher`.teacher_id as teacherId,`teacher`.teacher_name as teacherName\n" +
            ",`teacher`.teacher_code as teacherCode, `teacher`.teacher_img as teacherImg,`teacher`.teacher_phone_number as teacherPhoneNumber\n" +
            ",`teacher`.teacher_email as teacherEmail, `faculty`.faculty_name as faculty, `degree`.degree_name as degree from teacher\n" +
            "             join `faculty` on `faculty`.faculty_id = `teacher`.faculty_id\n" +
            "             join `degree` on `degree`.degree_id = `teacher`.degree_id\n" +
            "             where teacher.teacher_name like concat('%',:nameSearch,'%') and teacher.flag_delete=0", nativeQuery = true)
    Page<ITeacherDto> getAllTeacher(@Param("nameSearch") String name, Pageable pageable);

    /**
     * create by : HungPV ,
     * Date Create : 29/03/2023
     * Function : get teacher by id
     *
     * @param id
     * @return Optional<ITeacherDto>
     */
    @Query(value = "select `teacher`.teacher_id as teacherId,`teacher`.teacher_name as teacherName\n" +
            ",`teacher`.teacher_code as teacherCode, `teacher`.teacher_img as teacherImg,`teacher`.teacher_phone_number as teacherPhoneNumber\n" +
            ",`teacher`.teacher_email as teacherEmail,`teacher`.teacher_address as teacherAddress,`teacher`.teacher_date_of_birth as teacherDateOfBirth," +
            "`teacher`.teacher_gender as teacherGender, `faculty`.faculty_name as faculty, `degree`.degree_name as degree from teacher\n" +
            "             join `faculty` on `faculty`.faculty_id = `teacher`.faculty_id\n" +
            "             join `degree` on `degree`.degree_id = `teacher`.degree_id\n" +
            "where teacher.teacher_id = :id and teacher.flag_delete=0;", nativeQuery = true)
    Optional<ITeacherDto> findTeacherById(@Param("id") Long id);

    /**
     * create by : HungPV ,
     * Date Create : 29/03/2023
     * Function : delete teacher by id
     *
     * @param teacherId
     * @return void
     */
    @Transactional
    @Modifying
    @Query(value = "update teacher set teacher.flag_delete = 1 where teacher_id = :teacherId ", nativeQuery = true)
    void deleteTeacherById(@Param("teacherId") long teacherId);

}
