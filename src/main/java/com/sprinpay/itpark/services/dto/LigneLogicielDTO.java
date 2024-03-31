package com.sprinpay.itpark.services.dto;

import com.sprinpay.itpark.domain.Logiciels;
import com.sprinpay.itpark.domain.Materiels;
import jakarta.validation.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class LigneLogicielDTO {

    private Long id;



    private Long materielId;

    private Long logicielId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date dateInstallation;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }





    public Date getDateInstallation() {
        return dateInstallation;
    }

    public void setDateInstallation(Date dateInstallation) {
        this.dateInstallation = dateInstallation;
    }

    public Long getMaterielId() {
        return materielId;
    }

    public void setMaterielId(Long materielId) {
        this.materielId = materielId;
    }

    public Long getLogicielId() {
        return logicielId;
    }

    public void setLogicielId(Long logicielId) {
        this.logicielId = logicielId;
    }

    @Override
    public String toString() {
        return "LigneLogicielDTO{" +
                "id=" + id +
                ", materielId=" + materielId +
                ", logicielId=" + logicielId +
                ", dateInstallation=" + dateInstallation +
                '}';
    }
}
