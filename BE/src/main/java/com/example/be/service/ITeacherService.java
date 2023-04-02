package com.example.be.service;

import com.example.be.dto.ITeacherDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ITeacherService {
    /**
     *create by : HungPV ,
     * Date Create : 29/03/2023
     * Function : show list has paging and search
     * @param name
     * @param pageable
     * @return Page<ITeacherDto>
     */
    Page<ITeacherDto> getAllTeacher(String name, Pageable pageable);

    /**
     *create by : HungPV ,
     * Date Create : 29/03/2023
     * Function : get teacher by id
     * @param id
     * @return Optional<ITeacherDto>
     */

    Optional<ITeacherDto> findTeacherById(Long id);

    /**
     *create by : HungPV ,
     * Date Create : 29/03/2023
     * Function : delete teacher by id
     * @param id
     * @return void
     */
    void deleteTeacherById(long id);

}
