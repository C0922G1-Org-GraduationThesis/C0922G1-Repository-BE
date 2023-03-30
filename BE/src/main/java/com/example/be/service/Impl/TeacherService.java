package com.example.be.service.Impl;

import com.example.be.dto.ITeacherDto;
import com.example.be.repository.ITeacherRepository;
import com.example.be.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeacherService implements ITeacherService {
    @Autowired
    private ITeacherRepository teacherRepository;

    /**
     *create by : HungPV ,
     * Date Create : 29/03/2023
     * Function : show list has paging and search
     * @param name
     * @param pageable
     * @return Page<ITeacherDto>
     */
    @Override
    public Page<ITeacherDto> getAllTeacher(String name, Pageable pageable) {
        return teacherRepository.getAllTeacher(name, pageable);
    }

    /**
     *create by : HungPV ,
     * Date Create : 29/03/2023
     * Function : get teacher by id
     * @param id
     * @return Optional<ITeacherDto>
     */
    @Override
    public Optional<ITeacherDto> findTeacherById(Long id) {
        return teacherRepository.findTeacherById(id);
    }

    /**
     *create by : HungPV ,
     * Date Create : 29/03/2023
     * Function : delete teacher by id
     * @param id
     * @return void
     */
    @Override
    public void deleteTeacherById(long id) {
        teacherRepository.deleteTeacherById(id);
    }
}
