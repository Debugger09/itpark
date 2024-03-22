package com.sprinpay.itpark.domain;

import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "type_logiciels")
public class Type_logiciels {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String libelle;

    // Getters
    public Long getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    // Override des méthodes equals et hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Type_logiciels type_logiciel = (Type_logiciels) o;
        return Objects.equals(id, type_logiciel.id) &&
                Objects.equals(libelle, type_logiciel.libelle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, libelle);
    }
}
