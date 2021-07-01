/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.LmSystem.services;

import com.lms.LmSystem.entity.NewUserDetail;
import com.lms.LmSystem.entity.Role;
import com.lms.LmSystem.entity.User;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author mocha
 */
@Service
public class UserDetailServiceCustome implements UserDetailsService{
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private RoleService roleService;
    
//    @Autowired
//    private RoleRepository roleRepository;
    
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        
        User user = userService.getEmail(email);
    
        
//        TblRole rolee = roleService.getRoleById(roleid);
                    
        String emails = user.getEmail();
        System.out.println("email " + emails);
        //getpasswords
        String password = user.getPassword();
         System.out.println("password " +password);
        Integer roleid = user.getRoleId().getRoleId();
        System.out.println("role " +roleid);
        
        Optional<Role> rolee = roleService.getRoleById(roleid);
        //Optional<TblRole> rolee = roleRepository.findById(roleid);
        String role = rolee.get().getNamaRole();       
        System.out.println("role " +role);
        
        //cek pemanggilan ini mungkin pakai emailS
        return new NewUserDetail(emails, password, role);
   }
    
    
    
}
