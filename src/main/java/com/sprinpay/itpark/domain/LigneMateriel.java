package com.sprinpay.itpark.domain;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "ligne_materiel")
public class LigneMateriel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Employes employe;
    @ManyToOne
    private Materiels materiel;

    @Column(name = "date_attribution", nullable = false)
    private Date dateAttribution;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employes getEmploye() {
        return employe;
    }

    public void setEmploye(Employes employe) {
        this.employe = employe;
    }

    public Materiels getMateriel() {
        return materiel;
    }

    public void setMateriel(Materiels materiel) {
        this.materiel = materiel;
    }

    public Date getDateAttribution() {
        return dateAttribution;
    }

    public void setDateAttribution(Date dateAttribution) {
        this.dateAttribution = dateAttribution;
    }


    @Override
    public String toString() {
        return "LigneMateriel{" +
                "id=" + id +
                ", employe=" + employe +
                ", materiel=" + materiel +
                ", dateAttribution=" + dateAttribution +
                '}';
    }
}
