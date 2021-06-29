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
@Table(name = "artikel_approval")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ArtikelApproval.findAll", query = "SELECT a FROM ArtikelApproval a"),
    @NamedQuery(name = "ArtikelApproval.findByArtikelApprovalId", query = "SELECT a FROM ArtikelApproval a WHERE a.artikelApprovalId = :artikelApprovalId"),
    @NamedQuery(name = "ArtikelApproval.findByTanggalApproval", query = "SELECT a FROM ArtikelApproval a WHERE a.tanggalApproval = :tanggalApproval")})
public class ArtikelApproval implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "artikel_approval_id")
    private Integer artikelApprovalId;
    @Basic(optional = false)
    @Column(name = "tanggal_approval")
    @Temporal(TemporalType.DATE)
    private Date tanggalApproval;
    @JoinColumn(name = "artikel_id", referencedColumnName = "artikel_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Artikel artikelId;
    @JoinColumn(name = "approval_status_id", referencedColumnName = "approval_status_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ApprovalStatus approvalStatusId;

    public ArtikelApproval() {
    }

    public ArtikelApproval(Integer artikelApprovalId) {
        this.artikelApprovalId = artikelApprovalId;
    }

    public ArtikelApproval(Integer artikelApprovalId, Date tanggalApproval) {
        this.artikelApprovalId = artikelApprovalId;
        this.tanggalApproval = tanggalApproval;
    }

    public Integer getArtikelApprovalId() {
        return artikelApprovalId;
    }

    public void setArtikelApprovalId(Integer artikelApprovalId) {
        this.artikelApprovalId = artikelApprovalId;
    }

    public Date getTanggalApproval() {
        return tanggalApproval;
    }

    public void setTanggalApproval(Date tanggalApproval) {
        this.tanggalApproval = tanggalApproval;
    }

    public Artikel getArtikelId() {
        return artikelId;
    }

    public void setArtikelId(Artikel artikelId) {
        this.artikelId = artikelId;
    }

    public ApprovalStatus getApprovalStatusId() {
        return approvalStatusId;
    }

    public void setApprovalStatusId(ApprovalStatus approvalStatusId) {
        this.approvalStatusId = approvalStatusId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (artikelApprovalId != null ? artikelApprovalId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArtikelApproval)) {
            return false;
        }
        ArtikelApproval other = (ArtikelApproval) object;
        if ((this.artikelApprovalId == null && other.artikelApprovalId != null) || (this.artikelApprovalId != null && !this.artikelApprovalId.equals(other.artikelApprovalId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lms.LmSystem.entity.ArtikelApproval[ artikelApprovalId=" + artikelApprovalId + " ]";
    }
    
}
