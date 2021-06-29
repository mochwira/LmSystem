//package com.lms.LmSystem.services;
//
//import com.lms.LmSystem.entity.Role;
//import com.lms.LmSystem.interfaces.RoleInterfacesJpa;
//import com.lms.LmSystem.repository.RoleRepositoryJpa;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class RoleServiceJpa implements RoleInterfacesJpa {
//
//    @Autowired
//    private RoleRepositoryJpa repositoryJpa;
//
//    @Override
//    public List<Role> getAllRole() {
//        return repositoryJpa.findAll();
//    }
//
//    @Override
//    public void saveRole(Role role) {
//        this.repositoryJpa.save(role);
//    }
//
//    @Override
//    public Role getRoleById(Integer roleId) {
//        Optional < Role > optional = repositoryJpa.findById(roleId);
//        Role role = null;
//        if (optional.isPresent()) {
//            role = optional.get();
//        } else {
//            throw new RuntimeException(" Employee not found for id :: " + roleId);
//        }
//        return role;
//    }
//
//    @Override
//    public void deleteRoleById(Integer roleId) {
//        this.repositoryJpa.deleteById(roleId);
//    }
//
//}
