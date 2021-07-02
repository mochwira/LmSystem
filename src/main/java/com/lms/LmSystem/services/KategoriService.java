package com.lms.LmSystem.services;

import com.lms.LmSystem.entity.Kategori;
import com.lms.LmSystem.interfaces.KategoriInterface;
import com.lms.LmSystem.repository.KategoriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KategoriService implements KategoriInterface {

    @Autowired
    KategoriRepository kategoriRepository;


    @Override
    public Iterable<Kategori> getActiveKategori() {
        return kategoriRepository.getActiveKategori();
    }

    @Override
    public Iterable<Kategori> getAll() {
        return kategoriRepository.findAll();
    }

    @Override
    public Optional<Kategori> findById(String id) {
        return kategoriRepository.findById(id);
    }

    @Override
    public void deleteKategoriById(String id) {
        kategoriRepository.deleteById(id);
    }

    @Override
    public void save(Kategori kategori) {
        kategoriRepository.save(kategori);
    }

    @Override
    public Kategori update(Kategori kategori) {
        return kategoriRepository.save(kategori);
    }

    @Override
    public List<Kategori> getKategoriById(Integer id) {
        return kategoriRepository.getKategoriById(id);
    }
}
