package com.sprinpay.itpark.domain;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "logiciels")
public class Logiciels {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String libelle;
    private String editeur;
    private String version;
    private Date date_achat;
    private Date date_expiration;
    private String description;

    @ManyToOne
    @JoinColumn(name = "id_type_logiciel")
    private Type_logiciels type_logiciel;

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

    public Date getDate_achat() {
        return date_achat;
    }

    public Date getDate_expiration() {
        return date_expiration;
    }

    public String getDescription() {
        return description;
    }

    public Type_logiciels getType_logiciel() {
        return type_logiciel;
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

    public void setDate_achat(Date date_achat) {
        this.date_achat = date_achat;
    }

    public void setDateExpiration(Date date_expiration) {
        this.date_expiration = date_expiration;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType_logiciel(Type_logiciels type_logiciel) {
        this.type_logiciel = type_logiciel;
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
                Objects.equals(date_achat, logiciels.date_achat) &&
                Objects.equals(date_expiration, logiciels.date_expiration) &&
                Objects.equals(description, logiciels.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, libelle, editeur, version, date_achat, date_expiration, description);
    }
}
