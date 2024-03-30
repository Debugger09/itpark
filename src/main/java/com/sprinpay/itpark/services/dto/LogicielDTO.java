package com.sprinpay.itpark.services.dto;

import com.sprinpay.itpark.domain.Logiciels;
import com.sprinpay.itpark.domain.Materiels;
import com.sprinpay.itpark.domain.TypeLogiciel;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Formatter;


public class LogicielDTO {
    private Long id;
    @NotBlank(message = "Champ requis")
    private String libelle;
    private String editeur;
    private String version;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateAchat;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateExpiration;
    private String description;
    private Long typeLogicielId;

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

    public String getEditeur() {
        return editeur;
    }

    public void setEditeur(String editeur) {
        this.editeur = editeur;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public Date getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(Date dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getTypeLogicielId() {
        return typeLogicielId;
    }

    public void setTypeLogicielId(Long typeLogicielId) {
        this.typeLogicielId = typeLogicielId;
    }

    @Override
    public String toString() {
        return "LogicielDTO{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                ", editeur='" + editeur + '\'' +
                ", version='" + version + '\'' +
                ", dateAchat=" + dateAchat +
                ", dateExpiration=" + dateExpiration +
                ", description='" + description + '\'' +
                ", typeLogicielId=" + typeLogicielId +
                '}';
    }

    public static LogicielDTO mapDTO(Logiciels logiciels){
       LogicielDTO logicielDTO=  new LogicielDTO();
      logicielDTO.setId(logiciels.getId());
        logicielDTO.setDateAchat(logiciels.getDateAchat());
        logicielDTO.setDateExpiration(logiciels.getDateExpiration());
        logicielDTO.setEditeur(logiciels.getEditeur());
       logicielDTO.setDescription(logiciels.getDescription());
       logicielDTO.setTypeLogicielId(logiciels.getTypeLogiciel().getId());
       logicielDTO.setLibelle(logiciels.getLibelle());
       logicielDTO.setVersion(logiciels.getVersion());
        System.out.println(logicielDTO.toString());
        return  logicielDTO  ;
    }

    public static Logiciels mapEntity(LogicielDTO logicielDTO){
        Logiciels logiciels=  new Logiciels();
        logiciels.setId(logicielDTO.getId());
        logiciels.setDateAchat(logicielDTO.getDateAchat());
        logiciels.setDateExpiration(logicielDTO.getDateExpiration());
        logiciels.setEditeur(logicielDTO.getEditeur());
        logiciels.setDescription(logicielDTO.getDescription());
        logiciels.setLibelle(logicielDTO.getLibelle());
        logiciels.setVersion(logicielDTO.getVersion());
        return  logiciels  ;
    }
}
