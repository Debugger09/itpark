package com.sprinpay.itpark.domain;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "ligne_logiciel")
public class LigneLogiciel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_materiels")
    private Materiels materiel;

    @ManyToOne
    @JoinColumn(name = "id_logiciels")
    private Logiciels logiciel;

    @Column(name = "date_installation")
    private Date date_installation;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Materiels getMateriel() {
        return materiel;
    }

    public void setMateriel(Materiels materiel) {
        this.materiel = materiel;
    }

    public Logiciels getLogiciel() {
        return logiciel;
    }

    public void setLogiciel(Logiciels logiciel) {
        this.logiciel = logiciel;
    }

    public Date getDate_installation() {
        return date_installation;
    }

    public void setDateInstallation(Date date_installation) {
        this.date_installation = date_installation;
    }

    // Override des méthodes equals et hashCode

    @Override
    public String toString() {
        return "LigneLogiciel{" +
                "id=" + id +
                ", materiel=" + materiel +
                ", logiciel=" + logiciel +
                ", date_installation=" + date_installation +
                '}';
    }
}
