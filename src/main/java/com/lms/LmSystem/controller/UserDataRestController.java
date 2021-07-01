//package com.lms.LmSystem.controller;
//
//import com.lms.LmSystem.entity.Kategori;
//import com.lms.LmSystem.entity.Role;
//import com.lms.LmSystem.entity.User;
//import com.lms.LmSystem.repository.RoleRepositoryFix;
//import com.lms.LmSystem.repository.UserJpaRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//public class UserDataRestController {
//
//    @Autowired
//    private UserJpaRepository userJpaRepository;
//
//    @Autowired
//    private RoleRepositoryFix roleRepositoryFix;
//
//    @GetMapping("/finduser")
//    public User createFindUser(@RequestParam("userId") Integer userId, Integer roleId) {
//        User u = new User();
//        User ump = userJpaRepository.getOne(userId);
//        Role ro = new Role();
//        Role rl = roleRepositoryFix.getOne(roleId);
//
//        //Ini tipe Role
//        ro.setRoleId(rl.getRoleId());
//        ro.setNamaRole(rl.getNamaRole());
//
//        //init
//        u.setUserId(ump.getUserId());
//        u.setRoleId(ump.getRoleId());
//        u.setUsername(ump.getUsername());
//        u.setNamaUser(ump.getNamaUser());
//        u.setEmail(ump.getEmail());
//        u.setPasswords(ump.getPasswords());
//        u.setTanggalLahir(ump.getTanggalLahir());
//        u.setGender(ump.getGender());
//        u.setFotoProfil(ump.getFotoProfil());
//
//        return u;
//    }
//}
