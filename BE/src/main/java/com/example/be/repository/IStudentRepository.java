package com.example.be.repository;

import com.example.be.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IStudentRepository extends JpaRepository<Student,Long> {
    /**
     * Created by: TienP
     * Date: 29/03/2023
     * Class: findStudentByEmail
     */
    @Query(value = "select s.* from  student as s where s.email= :email", nativeQuery = true)
    Student findStudentByEmail(@Param("email") String email);
}
