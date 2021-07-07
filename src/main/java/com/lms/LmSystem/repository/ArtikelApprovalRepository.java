package com.lms.LmSystem.repository;

import com.lms.LmSystem.entity.Artikel;
import com.lms.LmSystem.entity.ArtikelApproval;
import com.lms.LmSystem.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtikelApprovalRepository extends CrudRepository<ArtikelApproval, Integer> {
    //Kayanya Masih Salah
    @Query(value = "SELECT * FROM artikel_approval JOIN approval_status ON artikel_approval.approval_status_id = approval_status.approval_status_id WHERE artikel_approval.status_approval = 'Pending'", nativeQuery = true)
    Iterable <ArtikelApproval> getActiveArtikelApproval();

    @Query(value = "SELECT * FROM artikel_approval JOIN approval_status ON artikel_approval.approval_status_id = approval_status.approval_status_id WHERE artikel_approval_id = :id", nativeQuery = true)
    List<ArtikelApproval> getArtikelApprovalById(@Param(value="id") Integer id);

    @Query(value = "SELECT * FROM artikel_approval JOIN artikel ON artikel_approval.artikel_id = artikel.artikel_id WHERE artikel_id = :id", nativeQuery = true)
        //Mungkin Ini idnya di ganti
    List<Artikel> getArtikelById(@Param(value="id") Integer id);
}
