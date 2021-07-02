package com.lms.LmSystem.interfaces;

import com.lms.LmSystem.entity.ApprovalStatus;
import com.lms.LmSystem.entity.Kategori;

import java.util.List;
import java.util.Optional;

public interface KategoriInterface {

    Iterable<Kategori> getActiveKategori();
    Iterable<Kategori> getAll();
    Optional<Kategori> findById(String id);
    //    List<ProductCategory> getMax();
    void deleteKategoriById(String id);
    void save(Kategori kategori);
    public Kategori update(Kategori kategori);
    List<Kategori> getKategoriById(Integer id);
}
