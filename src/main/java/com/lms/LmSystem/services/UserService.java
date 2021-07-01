/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.LmSystem.services;

import com.lms.LmSystem.entity.User;
import com.lms.LmSystem.interfaces.UserInterface;
import com.lms.LmSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mocha
 */
@Service
public class UserService implements UserInterface{

    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public Iterable<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getEmail(String email) {
        return userRepository.getEmail(email);
    }

    @Override
    public User getPassword(String password) {
        return userRepository.getPassword(password);
   }

}
