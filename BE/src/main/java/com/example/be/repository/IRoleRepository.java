package com.example.be.repository;

import com.example.be.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
public interface IRoleRepository extends JpaRepository<Role,Integer> {
    @Query(value = "select * from role", nativeQuery = true)
    List<Role> finAllRole();
}