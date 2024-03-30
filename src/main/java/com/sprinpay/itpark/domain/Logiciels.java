package com.sprinpay.itpark.domain;

import java.util.Date;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "logiciels")
public class Logiciels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;
    private String editeur;
    private String version;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateAchat;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateExpiration;
    private String description;

    @ManyToOne
    private TypeLogiciel typeLogiciel;

    // Getters
    public Long getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public String getEditeur() {
        return editeur;
    }

    public String getVersion() {
        return version;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public Date getDateExpiration() {
        return dateExpiration;
    }

    public String getDescription() {
        return description;
    }

    public TypeLogiciel getTypeLogiciel() {
        return typeLogiciel;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setEditeur(String editeur) {
        this.editeur = editeur;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public void setDateExpiration(Date dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTypeLogiciel(TypeLogiciel typeLogiciel) {
        this.typeLogiciel = typeLogiciel;
    }

    // Override des méthodes equals et hashCode

    @Override
    public String toString() {
        return "Logiciels{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                ", editeur='" + editeur + '\'' +
                ", version='" + version + '\'' +
                ", dateAchat=" + dateAchat +
                ", dateExpiration=" + dateExpiration +
                ", description='" + description + '\'' +
                ", typeLogiciel=" + typeLogiciel +
                '}';
    }
}
