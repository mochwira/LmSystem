/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.LmSystem.services;

import com.lms.LmSystem.entity.Role;
import com.lms.LmSystem.interfaces.RoleInterface;
import com.lms.LmSystem.repository.RoleRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mocha
 */
@Service
public class RoleService implements RoleInterface{

    @Autowired
    private RoleRepository roleRepository;
    
    @Override
    public void save(Role role) {
        roleRepository.save(role);
    }

    @Override
    public Iterable<Role> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public Iterable<Role> getRoleActive() {
        return roleRepository.getRoleActive();
    }

    @Override
    public Optional<Role> getRoleById(Integer roleId) {
        return roleRepository.findById(roleId);
    }
    
}
