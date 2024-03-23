package com.sprinpay.itpark.domain;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "logiciels")
public class Logiciels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;
    private String editeur;
    private String version;
    private Date dateAchat;
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

    public void setDateExpiration(Date date_expiration) {
        this.dateExpiration = date_expiration;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTypeLogiciel(TypeLogiciel typeLogiciel) {
        this.typeLogiciel = typeLogiciel;
    }

    // Override des méthodes equals et hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Logiciels logiciels = (Logiciels) o;
        return Objects.equals(id, logiciels.id) &&
                Objects.equals(libelle, logiciels.libelle) &&
                Objects.equals(editeur, logiciels.editeur) &&
                Objects.equals(version, logiciels.version) &&
                Objects.equals(dateAchat, logiciels.dateAchat) &&
                Objects.equals(dateExpiration, logiciels.dateExpiration) &&
                Objects.equals(description, logiciels.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, libelle, editeur, version, dateAchat, dateExpiration, description);
    }
}
