package com.sprinpay.itpark.domain;

import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "employes")
public class Employes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String email;
    private String poste;
    private String accord_sortie;

    @ManyToOne
    @JoinColumn(name = "id_services")
    private Services service; // Utilisation d'une relation ManyToOne pour représenter la clé étrangère

    // Getters et Setters
    // Getters
    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public String getPoste() {
        return poste;
    }

    public String getAccord_sortie() {
        return accord_sortie;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public void setAccord_sortie(String accord_sortie) {
        this.accord_sortie = accord_sortie;
    }

    // Getter et Setter pour la relation Service
    public Services getService() {
        return service;
    }

    public void setService(Services service) {
        this.service = service;
    }

    // Override des méthodes equals et hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Employes employes = (Employes) o;
        return Objects.equals(id, employes.id) &&
                Objects.equals(nom, employes.nom) &&
                Objects.equals(email, employes.email) &&
                Objects.equals(poste, employes.poste) &&
                Objects.equals(accord_sortie, employes.accord_sortie) &&
                Objects.equals(service, employes.service);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, email, poste, accord_sortie);
    }
}
