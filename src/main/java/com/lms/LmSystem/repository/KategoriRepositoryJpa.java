package com.lms.LmSystem.repository;

import com.lms.LmSystem.entity.Kategori;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KategoriRepositoryJpa extends JpaRepository<Kategori, Integer> {
}
