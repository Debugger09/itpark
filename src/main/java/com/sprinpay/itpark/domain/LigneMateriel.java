package com.sprinpay.itpark.domain;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

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

    private String attribueA;

    @ManyToOne
    private Services services;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_attribution", nullable = false)
    private Date dateAttribution;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateRestitution;

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

    public String getAttribueA() {
        return attribueA;
    }

    public void setAttribueA(String attribueA) {
        this.attribueA = attribueA;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    public Date getDateRestitution() {
        return dateRestitution;
    }

    public void setDateRestitution(Date dateRestitution) {
        this.dateRestitution = dateRestitution;
    }

    @Override
    public String toString() {
        return "LigneMateriel{" +
                "id=" + id +
                ", employe=" + employe +
                ", materiel=" + materiel +
                ", attribueA='" + attribueA + '\'' +
                ", services=" + services +
                ", dateAttribution=" + dateAttribution +
                ", dateRestitution=" + dateRestitution +
                '}';
    }
}
