package com.lms.LmSystem.repository;

import com.lms.LmSystem.entity.Artikel;
import com.lms.LmSystem.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//Mungkin Nanti di ganti ke integer stringnya
public interface ArtikelRepository extends CrudRepository<Artikel, String> {
    //Kayanya Masih Salah
    @Query(value = "SELECT * FROM artikel JOIN kategori ON artikel.kategori_id = kategori.kategori_id WHERE artikel.nama_kategori = 'true'", nativeQuery = true)
    Iterable <Artikel> getActiveArtikel();

    @Query(value = "SELECT * FROM artikel JOIN kategori ON artikel.kategori_id = kategori.kategori_id WHERE artikel_id = :id", nativeQuery = true)
    List<Artikel> getArtikelById(@Param(value="id") Integer id);

    @Query(value = "SELECT * FROM artikel JOIN user ON artikel.user_id = user.user_id WHERE user_id = :id", nativeQuery = true)
    //Mungkin Ini idnya di ganti
    List<User> getUserById(@Param(value="id") Integer id);

}
