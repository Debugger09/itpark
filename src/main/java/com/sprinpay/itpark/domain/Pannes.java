package com.sprinpay.itpark.domain;

import java.util.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "pannes")
public class Pannes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String diagnostic;
    private Boolean reparable;
    private Boolean besoinPiece;
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

    public Boolean getReparable() {
        return reparable;
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

    public void setReparable(Boolean reparable) {
        this.reparable = reparable;
    }

    public Boolean getBesoinPiece() {
        return besoinPiece;
    }

    public void setBesoinPiece(Boolean besoinPiece) {
        this.besoinPiece = besoinPiece;
    }

    @Override
    public String toString() {
        return "Pannes{" +
                "id=" + id +
                ", diagnostic='" + diagnostic + '\'' +
                ", besoinPiece=" + besoinPiece +
                ", dateDiagnostic=" + dateDiagnostic +
                ", materiel=" + materiel +
                ", reparable=" + reparable +
                '}';
    }
}
