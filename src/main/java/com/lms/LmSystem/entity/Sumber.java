/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms.LmSystem.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mocha
 */
@Entity
@Table(name = "sumber")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sumber.findAll", query = "SELECT s FROM Sumber s"),
    @NamedQuery(name = "Sumber.findBySumberId", query = "SELECT s FROM Sumber s WHERE s.sumberId = :sumberId"),
    @NamedQuery(name = "Sumber.findByNamaSumber", query = "SELECT s FROM Sumber s WHERE s.namaSumber = :namaSumber"),
    @NamedQuery(name = "Sumber.findByAuthor", query = "SELECT s FROM Sumber s WHERE s.author = :author"),
    @NamedQuery(name = "Sumber.findByTahun", query = "SELECT s FROM Sumber s WHERE s.tahun = :tahun")})
public class Sumber implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sumber_id")
    private Integer sumberId;
    @Basic(optional = false)
    @Column(name = "nama_sumber")
    private String namaSumber;
    @Basic(optional = false)
    @Column(name = "author")
    private String author;
    @Basic(optional = false)
    @Column(name = "tahun")
    @Temporal(TemporalType.DATE)
    private Date tahun;
    @JoinColumn(name = "artikel_id", referencedColumnName = "artikel_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Artikel artikelId;

    public Sumber() {
    }

    public Sumber(Integer sumberId) {
        this.sumberId = sumberId;
    }

    public Sumber(Integer sumberId, String namaSumber, String author, Date tahun) {
        this.sumberId = sumberId;
        this.namaSumber = namaSumber;
        this.author = author;
        this.tahun = tahun;
    }

    public Integer getSumberId() {
        return sumberId;
    }

    public void setSumberId(Integer sumberId) {
        this.sumberId = sumberId;
    }

    public String getNamaSumber() {
        return namaSumber;
    }

    public void setNamaSumber(String namaSumber) {
        this.namaSumber = namaSumber;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getTahun() {
        return tahun;
    }

    public void setTahun(Date tahun) {
        this.tahun = tahun;
    }

    public Artikel getArtikelId() {
        return artikelId;
    }

    public void setArtikelId(Artikel artikelId) {
        this.artikelId = artikelId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sumberId != null ? sumberId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sumber)) {
            return false;
        }
        Sumber other = (Sumber) object;
        if ((this.sumberId == null && other.sumberId != null) || (this.sumberId != null && !this.sumberId.equals(other.sumberId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lms.LmSystem.entity.Sumber[ sumberId=" + sumberId + " ]";
    }
    
}
