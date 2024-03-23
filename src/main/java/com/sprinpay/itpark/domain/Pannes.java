package com.sprinpay.itpark.domain;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "pannes")
public class Pannes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String diagnostic;
    private Date date_diagnostic;

    @ManyToOne
    @JoinColumn(name = "id_materiel")
    private Materiel materiel;

    // Getters
    public Long getId() {
        return id;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public Date getDate_diagnostic() {
        return date_diagnostic;
    }

    public Materiel getMateriel() {
        return materiel;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public void setDateDiagnostic(Date date_diagnostic) {
        this.date_diagnostic = date_diagnostic;
    }

    public void setMateriel(Materiel materiel) {
        this.materiel = materiel;
    }

    // Override des méthodes equals et hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Pannes pannes = (Pannes) o;
        return Objects.equals(id, pannes.id) &&
                Objects.equals(diagnostic, pannes.diagnostic) &&
                Objects.equals(date_diagnostic, pannes.date_diagnostic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, diagnostic, date_diagnostic);
    }
}
