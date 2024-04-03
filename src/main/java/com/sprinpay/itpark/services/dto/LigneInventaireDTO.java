package com.sprinpay.itpark.services.dto;


public class LigneInventaireDTO {
    private Long id;
    private Long inventaireId;
    private Long materielId;
    private String observation;
    private boolean etat;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInventaireId() {
        return inventaireId;
    }

    public void setInventaireId(Long inventaireId) {
        this.inventaireId = inventaireId;
    }

    public Long getMaterielId() {
        return materielId;
    }

    public void setMaterielId(Long materielId) {
        this.materielId = materielId;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public boolean getEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "LigneInventaireDTO{" +
                "id=" + id +
                ", inventaireId=" + inventaireId +
                ", materielId=" + materielId +
                ", observation='" + observation + '\'' +
                ", etat='" + etat + '\'' +
                '}';
    }
}
