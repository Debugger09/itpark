package com.sprinpay.itpark.services.dto;

import com.sprinpay.itpark.domain.Materiels;
import jakarta.validation.constraints.NotBlank;

public class MaterielDTO {
    private Long id;
    @NotBlank(message = "Champ requis")
    private String libelle;
    private String fabricant;
    private String modele;
    private String numeroSerie;
    private Boolean etatAchat;
    private Boolean mobilite;
    private Long typeMaterielId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getFabricant() {
        return fabricant;
    }

    public void setFabricant(String fabricant) {
        this.fabricant = fabricant;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public Boolean getEtatAchat() {
        return etatAchat;
    }

    public void setEtatAchat(Boolean etatAchat) {
        this.etatAchat = etatAchat;
    }

    public Boolean getMobilite() {
        return mobilite;
    }

    public void setMobilite(Boolean mobilite) {
        this.mobilite = mobilite;
    }

    public Long getTypeMaterielId() {
        return typeMaterielId;
    }

    public void setTypeMaterielId(Long typeMaterielId) {
        this.typeMaterielId = typeMaterielId;
    }

    @Override
    public String toString() {
        return "MaterielDTO{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                ", fabricant='" + fabricant + '\'' +
                ", modele='" + modele + '\'' +
                ", numeroSerie='" + numeroSerie + '\'' +
                ", etatAchat=" + etatAchat +
                ", mobilite=" + mobilite +
                ", typeMaterielId=" + typeMaterielId +
                '}';
    }

    public static MaterielDTO mapDTO(Materiels materiels) {
        MaterielDTO materielDTO = new MaterielDTO();
        materielDTO.setEtatAchat(materiels.getEtatAchat());
        materielDTO.setFabricant(materiels.getFabricant());
        materielDTO.setModele(materiels.getModele());
        materielDTO.setTypeMaterielId(materiels.getTypeMateriel().getId());
        materielDTO.setLibelle(materiels.getLibelle());
        materielDTO.setId(materiels.getId());
        materielDTO.setNumeroSerie(materiels.getNumeroSerie());
        return materielDTO;
    }
}
