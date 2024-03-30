package com.sprinpay.itpark.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "materiels")
public class Materiels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String libelle;
    private String fabricant;
    private String modele;
    private String numeroSerie;
    private Boolean etatAchat;
    private Boolean mobilite;

    // Champs pour les clés étrangères

    @ManyToOne
    private TypeMateriel typeMateriel;

    // Getters
    public Long getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public String getFabricant() {
        return fabricant;
    }

    public String getModele() {
        return modele;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public Boolean getEtatAchat() {
        return etatAchat;
    }

    public Boolean getMobilite() {
        return mobilite;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setFabricant(String fabricant) {
        this.fabricant = fabricant;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public void setEtatAchat(Boolean etatAchat) {
        this.etatAchat = etatAchat;
    }

    public void setMobilite(Boolean mobilite) {
        this.mobilite = mobilite;
    }

    // Getter et Setter pour la relation avec la table TypeMateriel
    public TypeMateriel getTypeMateriel() {
        return typeMateriel;
    }

    public void setTypeMateriel(TypeMateriel typeMateriel) {
        this.typeMateriel = typeMateriel;
    }

    // override

    @Override
    public String toString() {
        return "Materiels{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                ", fabricant='" + fabricant + '\'' +
                ", modele='" + modele + '\'' +
                ", numeroSerie='" + numeroSerie + '\'' +
                ", etatAchat=" + etatAchat +
                ", mobilite=" + mobilite +
                ", typeMateriel=" + typeMateriel +
                '}';
    }
}
