package com.lms.LmSystem.controller;

import com.lms.LmSystem.entity.*;
import com.lms.LmSystem.services.ApprovalStatusService;
import com.lms.LmSystem.services.ArtikelApprovalService;
import com.lms.LmSystem.services.ArtikelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class ArtikelApprovalController {

    @Autowired
    ArtikelApprovalService artikelApprovalService;

    @Autowired
    ArtikelService artikelService;

    @Autowired
    ApprovalStatusService approvalStatusService;

    @GetMapping("/artikelapproval")
    public String getArtikelApproval(Model model) {

//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        String email = auth.getEmail();
//        User user = userService.getEmail(email);
//
//        Integer userId = user.getUserId();
//        String name = user.getNamaUser();
//        String role = user.getRoleId().getNamaRole();
//
//        UserSession users = new UserSession(name, id, role);
//        model.addAttribute("user", users);


        Iterable<ArtikelApproval> artikelApproval = artikelApprovalService.getAll();
        model.addAttribute("artikelapprovals", artikelApproval);
        Iterable<Artikel> artikel = artikelService.getAll();
        model.addAttribute("artikels", artikel);
        Iterable<ApprovalStatus> approvalStatus = approvalStatusService.getAll();
        model.addAttribute("approvalstatuss", approvalStatus);
//pengecekan
//        for (Kategori kat : kategori) {
//            System.out.println(kat.getKategoriId());
//            System.out.println(kat.getNamaKategori());
//        }

        ArtikelApproval artikelApprovalCrud = new ArtikelApproval();
        model.addAttribute("addArtikelApproval", artikelApprovalCrud);
        model.addAttribute("editArtikelApproval", artikelApprovalCrud);
        model.addAttribute("removeArtikelApproval", artikelApprovalCrud);

        System.out.println("ini Artikel Approval");

        return "artikelapproval/v_page.html";
    }

    @RequestMapping(value = "/artikelapproval/add", method = RequestMethod.POST)
    public String addArtikelApproval(
            @RequestParam(value = "artikelApprovalId", required = false) Integer artikelApprovalId,
            @RequestParam(value = "artikelId", required = false) Integer artikelId,
            @RequestParam(value = "approvalStatusId", required = false) Integer approvalStatusId,
            @RequestParam(value = "keteranganApproval", required = false) String keteranganApproval

    ) {

        Object artikelIdObject = new Artikel(artikelId);
        Object approvalStatusIdObject = new User(approvalStatusId);

        ArtikelApproval artikelApproval = new ArtikelApproval();

        artikelApproval.setArtikelApprovalId(artikelApprovalId);
        artikelApproval.setArtikelId((Artikel) artikelIdObject);
        artikelApproval.setApprovalStatusId((ApprovalStatus) approvalStatusIdObject);
        artikelApproval.setKeteranganApproval(keteranganApproval);


        this.artikelApprovalService.save(artikelApproval);
        return "redirect:/artikelapproval";
    }

    @RequestMapping(value = "/artikelapproval/edit", method = RequestMethod.POST)
    public String editArtikelApproval(
            @RequestParam(value = "artikelApprovalId", required = false) Integer artikelApprovalId,
            @RequestParam(value = "artikelId", required = false) Integer artikelId,
            @RequestParam(value = "approvalStatusId", required = false) Integer approvalStatusId,
            @RequestParam(value = "keteranganApproval", required = false) String keteranganApproval
    ) {

        Object artikelIdObject = new Artikel(artikelId);
        Object approvalStatusIdObject = new User(approvalStatusId);

        ArtikelApproval artikelApproval = new ArtikelApproval();

        artikelApproval.setArtikelApprovalId(artikelApprovalId);
        artikelApproval.setArtikelId((Artikel) artikelIdObject);
        artikelApproval.setApprovalStatusId((ApprovalStatus) approvalStatusIdObject);
        artikelApproval.setKeteranganApproval(keteranganApproval);


        this.artikelApprovalService.save(artikelApproval);
        return "redirect:/artikelapproval";
    }
}
