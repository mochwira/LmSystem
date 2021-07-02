package com.lms.LmSystem.repository;

import com.lms.LmSystem.entity.ApprovalStatus;
import com.lms.LmSystem.entity.Kategori;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KategoriRepository extends CrudRepository<Kategori, String> {

    @Query(value = "SELECT * FROM kategori WHERE nama_kategori = 'true'", nativeQuery = true)
    List<Kategori> getActiveKategori();

    @Query(value = "SELECT * FROM kategori WHERE kategori_id = :id", nativeQuery = true)
    List <Kategori> getKategoriById(@Param(value="id") Integer id);

//    @Query(value = "SELECT * FROM product_category", nativeQuery = true)
//    List <ProductCategory>  getMax();
}
