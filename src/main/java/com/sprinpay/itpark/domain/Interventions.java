package com.sprinpay.itpark.domain;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "interventions")
public class Interventions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String responsable;
    private String action_requise;
    private String decision;
    private Date date_intervention;

    @ManyToOne
    @JoinColumn(name = "id_techniciens")
    private Techniciens technicien;

    @OneToOne
    @JoinColumn(name = "id_pannes")
    private Pannes panne;

    // Getters
    public Long getId() {
        return id;
    }

    public String getResponsable() {
        return responsable;
    }

    public String getAction_requise() {
        return action_requise;
    }

    public String getDecision() {
        return decision;
    }

    public Date getDate_intervention() {
        return date_intervention;
    }

    public Techniciens getTechnicien() {
        return technicien;
    }

    public Pannes getPanne() {
        return panne;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public void setAction_requise(String action_requise) {
        this.action_requise = action_requise;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public void setDate_intervention(Date date_intervention) {
        this.date_intervention = date_intervention;
    }

    public void setTechnicien(Techniciens technicien) {
        this.technicien = technicien;
    }

    public void setPanne(Pannes panne) {
        this.panne = panne;
    }

    // Override des méthodes equals et hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Interventions intervention = (Interventions) o;
        return Objects.equals(id, intervention.id) &&
                Objects.equals(responsable, intervention.responsable) &&
                Objects.equals(action_requise, intervention.action_requise) &&
                Objects.equals(decision, intervention.decision) &&
                Objects.equals(date_intervention, intervention.date_intervention);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, responsable, action_requise, decision, date_intervention);
    }
}
