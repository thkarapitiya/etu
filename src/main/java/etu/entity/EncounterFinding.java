/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etu.entity;

import etu.entity.Encounter;
import etu.entity.Patient;
import etu.enums.EncounterFindingCategory;
import etu.enums.EncounterFindingDataType;
import etu.enums.EncounterFindingType;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

/**
 *
 * @author User
 */
@Entity
public class EncounterFinding implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne
    Encounter encounter;
    @ManyToOne
    Patient patient;
    @Enumerated(EnumType.STRING)
    EncounterFindingCategory encounterFindingCategory;
    @Enumerated(EnumType.STRING)
    EncounterFindingType encounterFindingType;
    @Enumerated(EnumType.STRING)
    EncounterFindingDataType encounterFindingDataType;
    @Lob
    String longTextValue;
    String textValue;
    Long longValue;
    Double doubleValue;

    public Encounter getEncounter() {
        return encounter;
    }

    public void setEncounter(Encounter encounter) {
        this.encounter = encounter;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public EncounterFindingCategory getEncounterFindingCategory() {
        return encounterFindingCategory;
    }

    public void setEncounterFindingCategory(EncounterFindingCategory encounterFindingCategory) {
        this.encounterFindingCategory = encounterFindingCategory;
    }

    public EncounterFindingType getEncounterFindingType() {
        return encounterFindingType;
    }

    public void setEncounterFindingType(EncounterFindingType encounterFindingType) {
        this.encounterFindingType = encounterFindingType;
    }

    public EncounterFindingDataType getEncounterFindingDataType() {
        return encounterFindingDataType;
    }

    public void setEncounterFindingDataType(EncounterFindingDataType encounterFindingDataType) {
        this.encounterFindingDataType = encounterFindingDataType;
    }

    public String getLongTextValue() {
        return longTextValue;
    }

    public void setLongTextValue(String longTextValue) {
        this.longTextValue = longTextValue;
    }

    public String getTextValue() {
        return textValue;
    }

    public void setTextValue(String textValue) {
        this.textValue = textValue;
    }

    public Long getLongValue() {
        return longValue;
    }

    public void setLongValue(Long longValue) {
        this.longValue = longValue;
    }

    public Double getDoubleValue() {
        return doubleValue;
    }

    public void setDoubleValue(Double doubleValue) {
        this.doubleValue = doubleValue;
    }
    
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EncounterFinding)) {
            return false;
        }
        EncounterFinding other = (EncounterFinding) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "etu.enums.EncounterFinding[ id=" + id + " ]";
    }
    
}
