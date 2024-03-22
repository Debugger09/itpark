package com.sprinpay.itpark.domain;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "ligne_logiciel")
public class Ligne_logiciel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ligne_logiciel that = (Ligne_logiciel) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(materiel, that.materiel) &&
                Objects.equals(logiciel, that.logiciel) &&
                Objects.equals(date_installation, that.date_installation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, materiel, logiciel, date_installation);
    }
}
