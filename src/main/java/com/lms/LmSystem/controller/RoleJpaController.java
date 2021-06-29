//package com.lms.LmSystem.controller;
//
//import com.lms.LmSystem.entity.Role;
//import com.lms.LmSystem.services.RoleServiceJpa;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//
//@Controller
//public class RoleJpaController {
//
//    @Autowired
//    private RoleServiceJpa roleServiceJpa;
//
//    // display list of employees
//    @GetMapping("/role")
//    public String viewHomePage(Model model) {
//        model.addAttribute("listRole", roleServiceJpa.getAllRole());
//        return "/role/role.html";
//    }
//
//    @GetMapping("/shownewrole")
//    public String showNewRole(Model model) {
//        // create model attribute to bind form data
//        Role role = new Role();
//        model.addAttribute("roles", role);
//        return "role/new_role.html";
//    }
//
//    @PostMapping("/saverole")
//    public String saveRole(@ModelAttribute("id") Role role) {
//        // save employee to database
//        roleServiceJpa.saveRole(role);
//        return "redirect:/role";
//    }
//
//    //Mungkin Nanti ada yang belum bener bagian "roleid"
//    @GetMapping("/showupdate/{roleId}")
//    public String showupdate(@PathVariable(value = "roleId") Integer roleId, Model model) {
//
//        // get employee from the service
//        Role role = roleServiceJpa.getRoleById(roleId);
//
//        // set employee as a model attribute to pre-populate the form
//        model.addAttribute("roles", role);
//        return "/role/update_role.html";
//    }
//
//    @GetMapping("/deleterole/{roleId}")
//    public String deleteRole(@PathVariable(value = "roleId") Integer roleId) {
//
//        // call delete employee method
//        this.roleServiceJpa.deleteRoleById(roleId);
//        return "redirect:/role";
//    }
//}
