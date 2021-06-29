/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.LmSystem.interfaces;

import com.lms.LmSystem.entity.Role;
import java.util.Optional;

/**
 *
 * @author mocha
 */
public interface RoleInterface {
    void save(Role role);
    Iterable<Role> getRoleActive();
    public Optional<Role> getRoleById(Integer roleId);
}
