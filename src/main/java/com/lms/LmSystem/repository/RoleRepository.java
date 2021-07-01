/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.LmSystem.repository;

import com.lms.LmSystem.entity.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mocha
 */
@Repository
public interface RoleRepository extends CrudRepository<Role, Integer>{
    @Query(value = "SELECT * FROM role WHERE role.status_role = 1", nativeQuery = true)
    public Iterable<Role> getRoleActive();
//    public Iterable<Role> getAll();
}
