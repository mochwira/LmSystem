package com.lms.LmSystem.interfaces;

import com.lms.LmSystem.entity.Artikel;

import java.util.List;

public interface ArtikelInterface {

    Iterable<Artikel> getAll();
    Iterable <Artikel> getActiveArtikel();
    //    Optional<Artikel> getById(String id);
    void deleteArtikelById(String id);
    void save(Artikel artikel);
    List<Artikel> getArtikelById(Integer id);
//    Iterable<Artikel> getArtikelActive();
}
