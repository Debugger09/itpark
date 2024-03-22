package com.sprinpay.itpark.domain;

import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "materiels")
public class Materiels {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String libelle;
    private String fabricant;
    private String modele;
    private String numero_serie;
    private Boolean etat_achat;
    private Boolean mobilite;

    // Champs pour les clés étrangères
    @ManyToOne
    @JoinColumn(name = "id_employes")
    private Employes employe;

    @ManyToOne
    @JoinColumn(name = "id_administrateurs")
    private Administrateurs administrateur;

    @ManyToOne
    @JoinColumn(name = "id_")
    private Type_materiels type_materiel;

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

    public String getNumero_serie() {
        return numero_serie;
    }

    public Boolean getEtat_achat() {
        return etat_achat;
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

    public void setNumero_serie(String numero_serie) {
        this.numero_serie = numero_serie;
    }

    public void setEtat_achat(Boolean etat_achat) {
        this.etat_achat = etat_achat;
    }

    public void setMobilite(Boolean mobilite) {
        this.mobilite = mobilite;
    }

    // Getter et Setter pour la relation avec la table Employes
    public Employes getEmploye() {
        return employe;
    }

    public void setEmploye(Employes employe) {
        this.employe = employe;
    }

    // Getter et Setter pour la relation avec la table Administrateurs
    public Administrateurs getAdministrateur() {
        return administrateur;
    }

    public void setAdministrateur(Administrateurs administrateur) {
        this.administrateur = administrateur;
    }

    // Getter et Setter pour la relation avec la table Type_materiels
    public Type_materiels getType_materiel() {
        return type_materiel;
    }

    public void setType_materiels(Type_materiels type_materiel) {
        this.type_materiel = type_materiel;
    }

    // override
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Materiels materiel = (Materiels) o;
        return Objects.equals(id, materiel.id) &&
                Objects.equals(libelle, materiel.libelle) &&
                Objects.equals(fabricant, materiel.fabricant) &&
                Objects.equals(modele, materiel.modele) &&
                Objects.equals(numero_serie, materiel.numero_serie) &&
                Objects.equals(etat_achat, materiel.etat_achat) &&
                Objects.equals(mobilite, materiel.mobilite) &&
                Objects.equals(employe, materiel.employe) &&
                Objects.equals(administrateur, materiel.administrateur) &&
                Objects.equals(type_materiel, materiel.type_materiel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, libelle, fabricant, modele, numero_serie, etat_achat, mobilite);
    }
}
