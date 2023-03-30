package com.example.be.service.Impl;

import com.example.be.model.Role;
import com.example.be.repository.IRoleRepository;
import com.example.be.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleService implements IRoleService {
    @Autowired
    private IRoleRepository roleRepository;
    /**
     * Created by: Phạm Tiến
     * Date: 29/03/2023
     * Function: findAllRole()
     * Return: List<Role>
     */
    @Override
    public List<Role> findAllRole() {
        return roleRepository.finAllRole();
    }
}
