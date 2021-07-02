package com.lms.LmSystem.controller;

import com.lms.LmSystem.entity.*;
import com.lms.LmSystem.services.ArtikelService;
import com.lms.LmSystem.services.KategoriService;
import com.lms.LmSystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    SupportModalCrud supportModalCrud;

    @GetMapping("/artikel")
    public String getArtikel(Model model) {
        Iterable<Artikel> artikel = artikelService.getAll();
        model.addAttribute("artikels", artikel);
        Iterable<Kategori> kategori = kategoriService.getAll();
        model.addAttribute("kategoris", kategori);
//pengecekan
        for (Kategori kat : kategori) {
            System.out.println(kat.getKategoriId());
            System.out.println(kat.getNamaKategori());
        }

        Artikel artikelCrud = new Artikel();
        model.addAttribute("addArtikel", artikelCrud);
        model.addAttribute("editArtikel", artikelCrud);
//      model.addAttribute("removeRole", roleCrud);

        System.out.println("ini Artikel");

        return "artikel/v_page.html";
    }

    @RequestMapping(value = "/artikel/add", method = RequestMethod.POST)
    public String addArtikel(
            @RequestParam(value = "artikelId", required = false) Integer artikelId,
            @RequestParam(value = "kategoriId", required = false) Integer kategoriId,
            @RequestParam(value = "namaArtikel", required = false) String namaArtikel,
            @RequestParam(value = "deskripsiArtikel", required = false) String deskripsiArtikel,
            @RequestParam(value = "lastUpdate", required = false) Date lastUpdate
    ) {



        int kategoriIdInt = Integer.parseInt(String.valueOf(kategoriId));
        Object kategoriIdObject = new Kategori(kategoriIdInt);

        Artikel artikel = new Artikel(artikelId, kategoriIdObject, namaArtikel, deskripsiArtikel, lastUpdate);

        artikel.setArtikelId(artikelId);
        artikel.setKategoriId((String) kategoriIdObject);
        artikel.setNamaArtikel(namaArtikel);
        artikel.setDeskripsiArtkel(deskripsiArtikel);
        artikel.setLastUpdate(lastUpdate);

        this.artikelService.save(artikel);
        return "redirect:/artikel";
    }

    @RequestMapping(value = "/artikel/edit", method = RequestMethod.POST)
    public String editArtikel(
            @RequestParam(value = "artikelId", required = false) Integer artikelId,
            @RequestParam(value = "kategoriId", required = false) Integer kategoriId,
            @RequestParam(value = "namaArtikel", required = false) String namaArtikel,
            @RequestParam(value = "deskripsiArtikel", required = false) String deskripsiArtikel,
            @RequestParam(value = "lastUpdate", required = false) Date lastUpdate
    ) {

        //String activeArtikel = "true";
        int kategoriIdInt = Integer.parseInt(String.valueOf(kategoriId));
        Object kategoriIdObject = new Kategori(kategoriIdInt);

        Artikel artikel = new Artikel(artikelId, kategoriIdObject, namaArtikel, deskripsiArtikel, lastUpdate);

        artikel.setArtikelId(artikelId);
        artikel.setKategoriId(String.valueOf((Kategori) kategoriIdObject));
        artikel.setNamaArtikel(namaArtikel);
        artikel.setDeskripsiArtkel(deskripsiArtikel);
        artikel.setLastUpdate(lastUpdate);

        this.artikelService.save(artikel);
        return "redirect:/artikel";
    }

    @RequestMapping(value = "/artikel/remove", method = RequestMethod.POST)
    public String removeArtikel(
            @RequestParam(value = "artikel_id_remove", required = false) Integer artikelId
    ){

        //int artikelId = "";
        //String activeArtikel = "false";
        int kategoriId = 0;
        String namaArtikel = "";
        String deskripsiArtikel = "";
        String kategoriIdObject = "";
        //Date lastUpdate = "";

        List<Artikel> artikelDetail = artikelService.getArtikelById(artikelId);
        System.out.println(artikelDetail);
        for (Artikel i : artikelDetail) {
            namaArtikel = i.getNamaArtikel();
        }


//        int kategoriIdInt = Integer.parseInt(String.valueOf(kategoriId));
//        Object kategoriIdObject = new Kategori(kategoriIdInt);


        Artikel artikel = new Artikel(artikelId, kategoriIdObject, namaArtikel, deskripsiArtikel);

        artikel.setArtikelId(artikelId);
        artikel.setKategoriId(kategoriIdObject);
        artikel.setNamaArtikel(namaArtikel);
        artikel.setDeskripsiArtkel(deskripsiArtikel);
        //artikel.setLastUpdate(lastUpdate);

        this.artikelService.save(artikel);
        return "redirect:/artikel";
    }

}
