package com.lms.LmSystem.services;

import com.lms.LmSystem.entity.ArtikelApproval;
import com.lms.LmSystem.interfaces.ArtikelApprovalInterface;
import com.lms.LmSystem.repository.ArtikelApprovalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtikelApprovalService implements ArtikelApprovalInterface {

    @Autowired
    private ArtikelApprovalRepository artikelApprovalRepository;


    @Override
    public Iterable<ArtikelApproval> getAll() {
        return artikelApprovalRepository.findAll();
    }

    @Override
    public Iterable<ArtikelApproval> getActiveArtikelApproval() {
        return artikelApprovalRepository.getActiveArtikelApproval();
    }

    @Override
    public void deleteArtikelApprovalById(Integer id) {
        artikelApprovalRepository.deleteById(id);
    }

    @Override
    public void save(ArtikelApproval artikelApproval) {
        artikelApprovalRepository.save(artikelApproval);
    }

    @Override
    public List<ArtikelApproval> getArtikelApprovalById(Integer id) {
        return artikelApprovalRepository.getArtikelApprovalById(id);
    }
}
