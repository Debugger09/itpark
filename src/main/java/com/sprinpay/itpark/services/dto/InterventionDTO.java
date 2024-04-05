package com.sprinpay.itpark.services.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class InterventionDTO {

    private Long id;
    private String responsable;

    private String actionRequise;
    private boolean decision;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateIntervention;

    private Long technicienId;

    private Long panneId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getActionRequise() {
        return actionRequise;
    }

    public void setActionRequise(String actionRequise) {
        this.actionRequise = actionRequise;
    }

    public boolean isDecision() {
        return decision;
    }

    public void setDecision(boolean decision) {
        this.decision = decision;
    }

    public Date getDateIntervention() {
        return dateIntervention;
    }

    public void setDateIntervention(Date dateIntervention) {
        this.dateIntervention = dateIntervention;
    }

    public Long getTechnicienId() {
        return technicienId;
    }

    public void setTechnicienId(Long technicienId) {
        this.technicienId = technicienId;
    }

    public Long getPanneId() {
        return panneId;
    }

    public void setPanneId(Long panneId) {
        this.panneId = panneId;
    }

    @Override
    public String toString() {
        return "InterventionDTO{" +
                "id=" + id +
                ", responsable='" + responsable + '\'' +
                ", actionRequise='" + actionRequise + '\'' +
                ", decision=" + decision +
                ", dateIntervention=" + dateIntervention +
                ", technicienId=" + technicienId +
                ", panneId=" + panneId +
                '}';
    }
}
