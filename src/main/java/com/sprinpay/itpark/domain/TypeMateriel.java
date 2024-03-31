package com.sprinpay.itpark.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

@Entity
@Table(name = "type_materiels")
public class TypeMateriel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Champ requis")
    private String libelle;
    private Boolean mobilite;

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

    public Boolean getMobilite() {
        return mobilite;
    }

    public void setMobilite(Boolean mobilite) {
        this.mobilite = mobilite;
    }

    // Override equals() et hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        TypeMateriel that = (TypeMateriel) o;
        return Objects.equals(id, that.id) && Objects.equals(libelle, that.libelle)
                && Objects.equals(mobilite, that.mobilite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, libelle, mobilite);
    }

    @Override
    public String toString() {
        return "TypeMateriel{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                ", mobilite='" + mobilite + '\'' +
                '}';
    }

}
