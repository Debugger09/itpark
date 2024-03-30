package com.sprinpay.itpark.services.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class LigneMaterielDTO {

    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateAttribution;
    private Long employeId;
    private Long materielId;

    public Long getEmployeId() {
        return employeId;
    }

    public void setEmployeId(Long employeId) {
        this.employeId = employeId;
    }

    public Long getMaterielId() {
        return materielId;
    }

    public void setMaterielId(Long materielId) {
        this.materielId = materielId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateAttribution() {
        return dateAttribution;
    }

    public void setDateAttribution(Date dateAttribution) {
        this.dateAttribution = dateAttribution;
    }

    @Override
    public String toString() {
        return "LigneMaterielDTO{" +
                "id=" + id +
                ", dateAttribution=" + dateAttribution +
                ", employeId=" + employeId +
                ", materielId=" + materielId +
                '}';
    }
}
