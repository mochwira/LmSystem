package com.lms.LmSystem.services;

import com.lms.LmSystem.entity.Artikel;
import com.lms.LmSystem.interfaces.ArtikelInterface;
import com.lms.LmSystem.repository.ArtikelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtikelService implements ArtikelInterface {

    @Autowired
    private ArtikelRepository artikelRepository;


    @Override
    public Iterable<Artikel> getAll() {
        return artikelRepository.findAll();
    }

    @Override
    public Iterable<Artikel> getActiveArtikel() {
        return artikelRepository.getActiveArtikel();
    }

    @Override
    public void deleteArtikelById(String id) {
        artikelRepository.deleteById(id);
    }

    @Override
    public void save(Artikel artikel) {
        artikelRepository.save(artikel);
    }

    @Override
    public List<Artikel> getArtikelById(Integer id) {
        return artikelRepository.getArtikelById(id);
    }
}
