package com.sprinpay.itpark.domain;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ligne_logiciel")
public class LigneLogiciel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Materiels materiel;

    @ManyToOne
    private Logiciels logiciel;


    private Date dateInstallation;

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

    public Date getDateInstallation() {
        return dateInstallation;
    }

    public void setDateInstallation(Date dateInstallation) {
        this.dateInstallation = dateInstallation;
    }


}
