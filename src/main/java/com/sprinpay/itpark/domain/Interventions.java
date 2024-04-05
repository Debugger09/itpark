package com.sprinpay.itpark.domain;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "interventions")
public class Interventions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String responsable;

    private String actionRequise;
    private String decision;
    private Date dateIntervention;

    @ManyToOne
    private User technicien;

    @OneToOne
    private Pannes panne;

    // Getters
    public Long getId() {
        return id;
    }

    public String getResponsable() {
        return responsable;
    }

    public String getDecision() {
        return decision;
    }

    public User getTechnicien() {
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

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public void setTechnicien(User technicien) {
        this.technicien = technicien;
    }

    public void setPanne(Pannes panne) {
        this.panne = panne;
    }

    public String getActionRequise() {
        return actionRequise;
    }

    public void setActionRequise(String actionRequise) {
        this.actionRequise = actionRequise;
    }

    public Date getDateIntervention() {
        return dateIntervention;
    }

    public void setDateIntervention(Date dateIntervention) {
        this.dateIntervention = dateIntervention;
    }

    @Override
    public String toString() {
        return "Interventions{" +
                "id=" + id +
                ", responsable='" + responsable + '\'' +
                ", actionRequise='" + actionRequise + '\'' +
                ", decision='" + decision + '\'' +
                ", dateIntervention=" + dateIntervention +
                ", technicien=" + technicien +
                ", panne=" + panne +
                '}';
    }

    // Override des méthodes equals et hashCode

}
