package com.sprinpay.itpark.domain;

import java.sql.Date;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "inventaires")
public class Inventaires {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date datInventaire;
    @ManyToOne
    private User technicien;

    @Transient
    private Long technicienId;

    private boolean closeInventaire;

    // Getters
    public Long getId() {
        return id;
    }

    public Date getDatInventaire() {
        return datInventaire;
    }



    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setDatInventaire(Date date_inventaire) {
        this.datInventaire = date_inventaire;
    }

    public User getTechnicien() {
        return technicien;
    }

    public void setTechnicien(User technicien) {
        this.technicien = technicien;
    }

    public Long getTechnicienId() {
        return technicienId;
    }

    public void setTechnicienId(Long technicienId) {
        this.technicienId = technicienId;
    }

    public boolean isCloseInventaire() {
        return closeInventaire;
    }

    public void setCloseInventaire(boolean closeInventaire) {
        this.closeInventaire = closeInventaire;
    }

    @Override
    public String toString() {
        return "Inventaires{" +
                "id=" + id +
                ", datInventaire=" + datInventaire +
                ", technicien=" + technicien +
                ", technicienId=" + technicienId +
                ", closeInventaire=" + closeInventaire +
                '}';
    }
}
