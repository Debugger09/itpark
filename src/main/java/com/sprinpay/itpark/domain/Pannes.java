package com.sprinpay.itpark.domain;

import java.util.Date;
import jakarta.persistence.*;
import org.springframework.boot.context.properties.bind.DefaultValue;

@Entity
@Table(name = "pannes")
public class Pannes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String diagnostic;
    private Boolean reparable;

    private Boolean decision;
    private Boolean besoinPiece;
    private Date dateDiagnostic;

    private Long inventaireId;


    @ManyToOne
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

    public Long getInventaireId() {
        return inventaireId;
    }

    public void setInventaireId(Long inventaireId) {
        this.inventaireId = inventaireId;
    }

    public Boolean getDecision() {
        return decision;
    }

    public void setDecision(Boolean decision) {
        this.decision = decision;
    }

    @Override
    public String toString() {
        return "Pannes{" +
                "id=" + id +
                ", diagnostic='" + diagnostic + '\'' +
                ", reparable=" + reparable +
                ", decision=" + decision +
                ", besoinPiece=" + besoinPiece +
                ", dateDiagnostic=" + dateDiagnostic +
                ", inventaireId=" + inventaireId +
                ", materiel=" + materiel +
                '}';
    }
}
