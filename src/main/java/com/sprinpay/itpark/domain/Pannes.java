package com.sprinpay.itpark.domain;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "pannes")
public class Pannes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String diagnostic;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateDiagnostic;

    @ManyToOne
    @JoinColumn(name = "id_materiel")
    private Materiels materiel;

    // Getters
    public Long getId() {
        return id;
    }

    public String getDiagnostic() {
        return diagnostic;
    }



    public Materiels getMateriel() {
        return materiel;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }



    public void setMateriel(Materiels materiel) {
        this.materiel = materiel;
    }

    public Date getDateDiagnostic() {
        return dateDiagnostic;
    }

    public void setDateDiagnostic(Date dateDiagnostic) {
        this.dateDiagnostic = dateDiagnostic;
    }
    // Override des méthodes equals et hashCode

    @Override
    public String toString() {
        return "Pannes{" +
                "id=" + id +
                ", diagnostic='" + diagnostic + '\'' +
                ", dateDiagnostic=" + dateDiagnostic +
                ", materiel=" + materiel +
                '}';
    }
}
