package com.sprinpay.itpark.services.dto;

import com.sprinpay.itpark.domain.Materiels;
import com.sprinpay.itpark.domain.Pannes;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class PanneDTO {

    private Long id;
    private String diagnostic;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateDiagnostic;
    private Long materielId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public Date getDateDiagnostic() {
        return dateDiagnostic;
    }

    public void setDateDiagnostic(Date dateDiagnostic) {
        this.dateDiagnostic = dateDiagnostic;
    }

    public Long getMaterielId() {
        return materielId;
    }

    public void setMaterielId(Long materielId) {
        this.materielId = materielId;
    }

    @Override
    public String toString() {
        return "PanneDTO{" +
                "id=" + id +
                ", diagnostic='" + diagnostic + '\'' +
                ", dateDiagnostic=" + dateDiagnostic +
                ", materielId=" + materielId +
                '}';
    }

    public static PanneDTO mapDTO(Pannes pannes){
        PanneDTO panneDTO=  new PanneDTO();
        panneDTO.setDateDiagnostic(pannes.getDateDiagnostic());
        panneDTO.setId(pannes.getId());
        panneDTO.setDiagnostic(pannes.getDiagnostic());
        panneDTO.setMaterielId(pannes.getMateriel().getId());
        return  panneDTO  ;
    }
}
