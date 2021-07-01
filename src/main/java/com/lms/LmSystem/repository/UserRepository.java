/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.LmSystem.repository;

import com.lms.LmSystem.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author mocha
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
    @Query(value = "SELECT * FROM user JOIN role user.role_id = role.role_id WHERE user_id = :userId", nativeQuery = true)
    List<User> getUserById(@Param(value="userId") String userId);

    @Query(value = "SELECT * FROM user WHERE email= :email", nativeQuery = true)
    public User getEmail(@Param("email") String email);

    @Query(value = "SELECT u.password FROM user u WHERE password = :password", nativeQuery = true)
    public User getPassword(@Param("password") String password);
}
