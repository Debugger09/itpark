package com.sprinpay.itpark.domain;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "ligne_materiel")
public class LigneMateriel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_employe")
    private Employes employe;

    @ManyToOne
    @JoinColumn(name = "id_materiel")
    private Materiels materiel;

    @Column(name = "date_attribution", nullable = false)
    private Date dateAttribution;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employes getEmploye() {
        return employe;
    }

    public void setEmploye(Employes employe) {
        this.employe = employe;
    }

    public Materiels getMateriel() {
        return materiel;
    }

    public void setMateriel(Materiels materiel) {
        this.materiel = materiel;
    }

    public Date getDateAttribution() {
        return dateAttribution;
    }

    public void setDateAttribution(Date dateAttribution) {
        this.dateAttribution = dateAttribution;
    }

    // Override des méthodes equals et hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        LigneMateriel that = (LigneMateriel) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(employe, that.employe) &&
                Objects.equals(materiel, that.materiel) &&
                Objects.equals(dateAttribution, that.dateAttribution);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, employe, materiel, dateAttribution);
    }
}
