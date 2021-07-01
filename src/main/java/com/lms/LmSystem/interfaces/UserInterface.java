/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.LmSystem.interfaces;

import com.lms.LmSystem.entity.User;

/**
 *
 * @author mocha
 */
public interface UserInterface {
    void save(User user);
    Iterable<User> getAll();

    User getEmail(String email);
    User getPassword(String password);
}
