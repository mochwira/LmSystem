package com.lms.LmSystem.controller;

import com.lms.LmSystem.entity.Kategori;
import com.lms.LmSystem.entity.Role;
import com.lms.LmSystem.repository.RoleRepositoryFix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RoleMappingController {

    @Autowired

    private RoleRepositoryFix roleRepositoryFix;

    @GetMapping("/role")
    public String createIndexRole(Model model, @RequestParam(defaultValue = "0", name = "page") int page) {
        //model.addAttribute("kategoris", kategoriRepository.findAll(new PageRequest(page, 4)));
        model.addAttribute("roles", roleRepositoryFix.findAll(PageRequest.of(page, 8)));
        model.addAttribute("buatPageRole", page);
        model.addAttribute("buatRole", new Role());
        return "/role/role_baru.html";
    }

    @PostMapping("/saverole")
    public String saveRole(Role role) {
        roleRepositoryFix.save(role);

        return "redirect:/role";
    }

    @GetMapping("/deleterole")
    public String deleteRole(@RequestParam("roleId") int roleId) {
        roleRepositoryFix.deleteById(roleId);

        return "redirect:/role";
    }
}
