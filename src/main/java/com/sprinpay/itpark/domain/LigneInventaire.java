package com.sprinpay.itpark.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "ligne_inventaire")
public class LigneInventaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_inventaires")
    private Inventaires inventaire;

    @ManyToOne
    @JoinColumn(name = "id_materiels")
    private Materiels materiel;

    @Column(name = "observation", length = 100)
    private String observation;

    private boolean etat;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Inventaires getInventaire() {
        return inventaire;
    }

    public void setInventaire(Inventaires inventaire) {
        this.inventaire = inventaire;
    }

    public Materiels getMateriel() {
        return materiel;
    }

    public void setMateriel(Materiels materiel) {
        this.materiel = materiel;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public boolean getEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    // Override hashCode and equals
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        LigneInventaire other = (LigneInventaire) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
