/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.LmSystem.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mocha
 */
@Entity
@Table(name = "artikel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Artikel.findAll", query = "SELECT a FROM Artikel a"),
    @NamedQuery(name = "Artikel.findByArtikelId", query = "SELECT a FROM Artikel a WHERE a.artikelId = :artikelId"),
    @NamedQuery(name = "Artikel.findByNamaArtikel", query = "SELECT a FROM Artikel a WHERE a.namaArtikel = :namaArtikel"),
    @NamedQuery(name = "Artikel.findByDeskripsiArtikel", query = "SELECT a FROM Artikel a WHERE a.deskripsiArtikel = :deskripsiArtikel"),
    @NamedQuery(name = "Artikel.findBySumberArtikel", query = "SELECT a FROM Artikel a WHERE a.sumberArtikel = :sumberArtikel")})
public class Artikel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "artikel_id")
    private Integer artikelId;
    @Basic(optional = false)
    @Column(name = "nama_artikel")
    private String namaArtikel;
    @Basic(optional = false)
    @Column(name = "deskripsi_artikel")
    private String deskripsiArtikel;
    @Basic(optional = false)
    @Lob
    @Column(name = "body_artikel")
    private String bodyArtikel;
    @Column(name = "sumber_artikel")
    private String sumberArtikel;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User userId;
    @JoinColumn(name = "kategori_id", referencedColumnName = "kategori_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Kategori kategoriId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "artikelId", fetch = FetchType.LAZY)
    private List<ArtikelApproval> artikelApprovalList;

    public Artikel() {
    }

    public Artikel(Integer artikelId) {
        this.artikelId = artikelId;
    }

    public Artikel(Integer artikelId, String namaArtikel, String deskripsiArtikel, String bodyArtikel) {
        this.artikelId = artikelId;
        this.namaArtikel = namaArtikel;
        this.deskripsiArtikel = deskripsiArtikel;
        this.bodyArtikel = bodyArtikel;
    }

    public Integer getArtikelId() {
        return artikelId;
    }

    public void setArtikelId(Integer artikelId) {
        this.artikelId = artikelId;
    }

    public String getNamaArtikel() {
        return namaArtikel;
    }

    public void setNamaArtikel(String namaArtikel) {
        this.namaArtikel = namaArtikel;
    }

    public String getDeskripsiArtikel() {
        return deskripsiArtikel;
    }

    public void setDeskripsiArtikel(String deskripsiArtikel) {
        this.deskripsiArtikel = deskripsiArtikel;
    }

    public String getBodyArtikel() {
        return bodyArtikel;
    }

    public void setBodyArtikel(String bodyArtikel) {
        this.bodyArtikel = bodyArtikel;
    }

    public String getSumberArtikel() {
        return sumberArtikel;
    }

    public void setSumberArtikel(String sumberArtikel) {
        this.sumberArtikel = sumberArtikel;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Kategori getKategoriId() {
        return kategoriId;
    }

    public void setKategoriId(Kategori kategoriId) {
        this.kategoriId = kategoriId;
    }

    @XmlTransient
    public List<ArtikelApproval> getArtikelApprovalList() {
        return artikelApprovalList;
    }

    public void setArtikelApprovalList(List<ArtikelApproval> artikelApprovalList) {
        this.artikelApprovalList = artikelApprovalList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (artikelId != null ? artikelId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Artikel)) {
            return false;
        }
        Artikel other = (Artikel) object;
        if ((this.artikelId == null && other.artikelId != null) || (this.artikelId != null && !this.artikelId.equals(other.artikelId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lms.LmSystem.entity.Artikel[ artikelId=" + artikelId + " ]";
    }
    
}
