package com.lms.LmSystem.controller;


import com.lms.LmSystem.entity.Role;
import com.lms.LmSystem.repository.RoleRepositoryFix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleRestMappingController {

    @Autowired
    private RoleRepositoryFix roleRepositoryFix;

    @GetMapping("/findrole")
    public Role createFindRole(@RequestParam("roleId") Integer roleId) {
        Role r = new Role();
        Role tmp = roleRepositoryFix.getOne(roleId);

        //init
        r.setRoleId(tmp.getRoleId());
        r.setNamaRole(tmp.getNamaRole());
        r.setStatusRole(tmp.getStatusRole());

        return r;
    }
}
