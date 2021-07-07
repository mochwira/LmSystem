package com.lms.LmSystem.interfaces;

import com.lms.LmSystem.entity.Artikel;
import com.lms.LmSystem.entity.ArtikelApproval;

import java.util.List;

public interface ArtikelApprovalInterface {

    Iterable<ArtikelApproval> getAll();
    Iterable <ArtikelApproval> getActiveArtikelApproval();
    //    Optional<ArtikelApproval> getById(String id);
    void deleteArtikelApprovalById(Integer id);
    void save(ArtikelApproval artikelApproval);
    List<ArtikelApproval> getArtikelApprovalById(Integer id);
//    Iterable<Artikel> getArtikelActive();
}
