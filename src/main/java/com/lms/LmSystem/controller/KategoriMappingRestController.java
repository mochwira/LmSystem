package com.lms.LmSystem.controller;

import com.lms.LmSystem.entity.Kategori;
import com.lms.LmSystem.repository.KategoriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KategoriMappingRestController {

    @Autowired
    private KategoriRepository kategoriRepository;

    @GetMapping("/findone")
    public Kategori createFindOne(@RequestParam("kategoriId") Integer kategoriId) {
        Kategori k = new Kategori();
        Kategori tmp = kategoriRepository.getOne(kategoriId);

        //init
        k.setKategoriId(tmp.getKategoriId());
        k.setNamaKategori(tmp.getNamaKategori());

        return k;
    }
}
