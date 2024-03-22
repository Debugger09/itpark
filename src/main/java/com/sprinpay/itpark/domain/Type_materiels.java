package com.sprinpay.itpark.domain;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "type_materiels")
public class Type_materiels {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String libelle;

    // Getters et Setters
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

    // Override equals() et hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Type_materiels that = (Type_materiels) o;
        return Objects.equals(id, that.id) && Objects.equals(libelle, that.libelle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, libelle);
    }
}
