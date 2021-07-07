package com.lms.LmSystem.controller;

import com.lms.LmSystem.entity.Role;
import com.lms.LmSystem.entity.User;
import com.lms.LmSystem.services.RoleService;
import com.lms.LmSystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
@RequestMapping
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @GetMapping("/user")
    public String getUser(Model model) {
        Iterable<User> user = userService.getAll();
        model.addAttribute("users", user);
        Iterable<Role> role = roleService.getAll();
        model.addAttribute("roler", role);
//pengecekan
        for (Role rol : role) {
            System.out.println(rol.getRoleId());
            System.out.println(rol.getNamaRole());
        }

        User userCrud = new User();
        model.addAttribute("addUser", userCrud);
        model.addAttribute("editUser", userCrud);
//      model.addAttribute("removeRole", roleCrud);

        System.out.println("ini User");

        return "user/v_page.html";
    }

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public String addUser(
            @RequestParam(value = "userId", required = false) Integer userId,
            @RequestParam(value = "roleId", required = false) Integer roleId,
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "namaUser", required = false) String namaUser,
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "password", required = false) String password
    ) {

        Object idRoleObject = new Role(roleId);

        User user = new User();
        user.setUserId(userId);
        user.setRoleId((Role) idRoleObject);
        user.setUsername(username);
        user.setNamaUser(namaUser);
        user.setEmail(email);
        user.setPassword(password);



        this.userService.save(user);
        return "redirect:/user";
    }

    @RequestMapping(value = "/user/edit", method = RequestMethod.POST)
    public String editUser(
            @RequestParam(value = "userId", required = false) Integer userId,
            @RequestParam(value = "roleId", required = false) Integer roleId,
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "namaUser", required = false) String namaUser,
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "password", required = false) String password
    ) {

        Object idRoleObject = new Role(roleId);

        User user = new User();
        user.setUserId(userId);
        user.setRoleId((Role) idRoleObject);
        user.setUsername(username);
        user.setNamaUser(namaUser);
        user.setEmail(email);
        user.setPassword(password);

        this.userService.save(user);
        return "redirect:/user";
    }
}
