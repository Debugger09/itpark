package com.sprinpay.itpark.domain;

import java.sql.Date;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "inventaires")
public class Inventaires {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date date_inventaire;
    private String responsable;

    @ManyToOne
    @JoinColumn(name = "id_techniciens")
    private Techniciens technicien;

    // Getters
    public Long getId() {
        return id;
    }

    public Date getDate_inventaire() {
        return date_inventaire;
    }

    public String getResponsable() {
        return responsable;
    }

    public Techniciens getTechnicien() {
        return technicien;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setDate_inventaire(Date date_inventaire) {
        this.date_inventaire = date_inventaire;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public void setTechnicien(Techniciens technicien) {
        this.technicien = technicien;
    }

    // override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Inventaires inventaire = (Inventaires) o;
        return Objects.equals(id, inventaire.id) &&
                Objects.equals(date_inventaire, inventaire.date_inventaire) &&
                Objects.equals(responsable, inventaire.responsable) &&
                Objects.equals(technicien, inventaire.technicien);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date_inventaire, responsable, technicien);
    }

}
