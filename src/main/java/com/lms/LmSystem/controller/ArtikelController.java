package com.lms.LmSystem.controller;

import com.lms.LmSystem.entity.*;

import com.lms.LmSystem.services.ArtikelService;
import com.lms.LmSystem.services.KategoriService;
import com.lms.LmSystem.services.RoleService;
import com.lms.LmSystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping
public class ArtikelController {

    @Autowired
    ArtikelService artikelService;

    @Autowired
    KategoriService kategoriService;

    @Autowired
    UserService userService;

    @GetMapping("/artikel")
    public String getArtikel(Model model) {

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


        Iterable<Artikel> artikel = artikelService.getAll();
        model.addAttribute("artikels", artikel);
        Iterable<Kategori> kategori = kategoriService.getAll();
        model.addAttribute("kategoris", kategori);
        Iterable<User> user = userService.getAll();
        model.addAttribute("users", user);
//pengecekan
        for (Kategori kat : kategori) {
            System.out.println(kat.getKategoriId());
            System.out.println(kat.getNamaKategori());
        }

        Artikel artikelCrud = new Artikel();
        model.addAttribute("addArtikel", artikelCrud);
        model.addAttribute("editArtikel", artikelCrud);
        model.addAttribute("removeArtikel", artikelCrud);

        System.out.println("ini Artikel");

        return "artikel/v_page.html";
    }

    @RequestMapping(value = "/artikel/add", method = RequestMethod.POST)
    public String addArtikel(
            @RequestParam(value = "artikelId", required = false) Integer artikelId,
            @RequestParam(value = "kategoriId", required = false) Integer kategoriId,
            @RequestParam(value = "userId", required = false) Integer userId,
            @RequestParam(value = "namaArtikel", required = false) String namaArtikel,
            @RequestParam(value = "deskripsiArtikel", required = false) String deskripsiArtikel,
            @RequestParam(value = "bodyArtikel", required = false) String bodyArtikel,
            @RequestParam(value = "sumberArtikel", required = false) String sumberArtikel
    ) {

        Object kategodriIdObject = new Kategori(kategoriId);
        Object userIdObject = new User(userId);

        Artikel artikel = new Artikel();
        artikel.setArtikelId(artikelId);
        artikel.setKategoriId((Kategori) kategodriIdObject);
        artikel.setUserId((User) userIdObject);
        artikel.setNamaArtikel(namaArtikel);
        artikel.setDeskripsiArtikel(deskripsiArtikel);
        artikel.setBodyArtikel(bodyArtikel);
        artikel.setSumberArtikel(sumberArtikel);



        this.artikelService.save(artikel);
        return "redirect:/artikel";
    }

    @RequestMapping(value = "/artikel/edit", method = RequestMethod.POST)
    public String editArtikel(
            @RequestParam(value = "artikelId", required = false) Integer artikelId,
            @RequestParam(value = "kategoriId", required = false) Integer kategoriId,
            @RequestParam(value = "userId", required = false) Integer userId,
            @RequestParam(value = "namaArtikel", required = false) String namaArtikel,
            @RequestParam(value = "deskripsiArtikel", required = false) String deskripsiArtikel,
            @RequestParam(value = "bodyArtikel", required = false) String bodyArtikel,
            @RequestParam(value = "sumberArtikel", required = false) String sumberArtikel
    ) {

        Object kategodriIdObject = new Kategori(kategoriId);
        Object userIdObject = new User(userId);

        Artikel artikel = new Artikel();
        artikel.setArtikelId(artikelId);
        artikel.setKategoriId((Kategori) kategodriIdObject);
        artikel.setUserId((User) userIdObject);
        artikel.setNamaArtikel(namaArtikel);
        artikel.setDeskripsiArtikel(deskripsiArtikel);
        artikel.setBodyArtikel(bodyArtikel);
        artikel.setSumberArtikel(sumberArtikel);

        this.artikelService.save(artikel);
        return "redirect:/artikel";
    }

}
