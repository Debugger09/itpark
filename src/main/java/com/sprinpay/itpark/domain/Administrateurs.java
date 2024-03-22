package com.sprinpay.itpark.domain;

import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "administrateurs")
public class Administrateurs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String user_name;
    private String user_password;
    private String user_mail;
    private boolean statut;

    // GETTERS
    /*
     * Un getter est une méthode qui permet de récupérer la valeur d'un champ privé
     * d'une classe depuis l'extérieur de cette classe.
     */
    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public String getUser_mail() {
        return user_mail;
    }

    public boolean getStatut() {
        return statut;
    }

    // SETTERS
    /*
     * Un setter est une méthode qui permet de modifier la valeur d'un champ privé
     * d'une classe depuis l'extérieur de cette classe.
     */
    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public void setUser_mail(String user_mail) {
        this.user_mail = user_mail;
    }

    public void setStatut(Boolean statut) {
        this.statut = statut;
    }

    // override
    /* */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Administrateurs admin = (Administrateurs) o;
        return statut == admin.statut && Objects.equals(id, admin.id) && Objects.equals(nom, admin.nom)
                && Objects.equals(user_name, admin.user_name) && Objects.equals(user_password, admin.user_password)
                && Objects.equals(user_mail, admin.user_mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, user_name, user_password, user_mail, statut);
    }
}
