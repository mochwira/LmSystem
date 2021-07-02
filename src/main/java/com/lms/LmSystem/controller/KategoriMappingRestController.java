package com.lms.LmSystem.controller;

import com.lms.LmSystem.entity.Kategori;
import com.lms.LmSystem.repository.KategoriRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KategoriMappingRestController {

    @Autowired
    private KategoriRepositoryJpa kategoriRepositoryJpa;

    @GetMapping("/findone")
    public Kategori createFindOne(@RequestParam("kategoriId") Integer kategoriId) {
        Kategori k = new Kategori();
        Kategori tmp = kategoriRepositoryJpa.getOne(kategoriId);

        //init
        k.setKategoriId(tmp.getKategoriId());
        k.setNamaKategori(tmp.getNamaKategori());

        return k;
    }
}
