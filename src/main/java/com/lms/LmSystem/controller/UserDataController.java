//package com.lms.LmSystem.controller;
//
//import com.lms.LmSystem.entity.Kategori;
//import com.lms.LmSystem.entity.Role;
//import com.lms.LmSystem.entity.User;
//import com.lms.LmSystem.repository.RoleRepositoryFix;
//import com.lms.LmSystem.repository.UserJpaRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//public class UserDataController {
//
//    @Autowired
//    private UserJpaRepository userJpaRepository;
//
//    @Autowired
//    private RoleRepositoryFix roleRepositoryFix;
//
//    @GetMapping("/user")
//    public String createIndex(Model model, @RequestParam(defaultValue = "0", name = "page") int page) {
//        //model.addAttribute("kategoris", kategoriRepository.findAll(new PageRequest(page, 4)));
//        model.addAttribute("users", userJpaRepository.findAll(PageRequest.of(page, 8)));
//        model.addAttribute("buatPageUser", page);
//        model.addAttribute("buatUser", new User());
//
//        //
//        model.addAttribute("roler", roleRepositoryFix.findAll());
//
//        return "/user/userdata.html";
//    }
//
//    @PostMapping("/saveuser")
//    public String saveUser(User user, Role role) {
//        userJpaRepository.save(user);
//        roleRepositoryFix.save(role);
//
//        return "redirect:/user";
//    }
//
//    @GetMapping("/deleteuser")
//    public String deleteUser(@RequestParam("userId") int userId, int roleId) {
//        userJpaRepository.deleteById(userId);
//        roleRepositoryFix.deleteById(roleId);
//
//        return "redirect:/user";
//    }
//}
//
