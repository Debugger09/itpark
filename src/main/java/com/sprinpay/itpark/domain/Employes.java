package com.sprinpay.itpark.domain;

import java.util.Objects;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "employes")
public class Employes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Champ requis")
    private String nom;
    @NotBlank(message = "Champ requis")
    private String email;
    @NotBlank(message = "Champ requis")
    private String poste;
    private boolean accordSortie;

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

    public boolean getAccordSortie() {
        return accordSortie;
    }

    public void setAccordSortie(boolean accordSortie) {
        this.accordSortie = accordSortie;
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
                Objects.equals(accordSortie, employes.accordSortie) &&
                Objects.equals(service, employes.service);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, email, poste, accordSortie);
    }

    @Override
    public String toString() {
        return "Employes{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", poste='" + poste + '\'' +
                ", accordSortie='" + accordSortie + '\'' +
                ", service=" + service +
                '}';
    }
}
