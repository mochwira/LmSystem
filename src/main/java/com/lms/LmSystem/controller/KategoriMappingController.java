package com.lms.LmSystem.controller;

import com.lms.LmSystem.entity.Kategori;
import com.lms.LmSystem.repository.KategoriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class KategoriMappingController {

    @Autowired
    private KategoriRepository kategoriRepository;

    @GetMapping("/kategori")
    public String createIndex(Model model, @RequestParam(defaultValue = "0", name = "page") int page) {
        //model.addAttribute("kategoris", kategoriRepository.findAll(new PageRequest(page, 4)));
        model.addAttribute("kategoris", kategoriRepository.findAll(PageRequest.of(page, 8)));
        model.addAttribute("buatPageKategori", page);
        model.addAttribute("buatKategori", new Kategori());
        return "/kategori/kategori.html";
    }

    @PostMapping("/save")
    public String save(Kategori kategori) {
        kategoriRepository.save(kategori);

        return "redirect:/kategori";
    }

    @GetMapping("/delete")
    public String deleteKategori(@RequestParam("kategoriId") int kategoriId) {
        kategoriRepository.deleteById(kategoriId);

        return "redirect:/kategori";
    }
}
