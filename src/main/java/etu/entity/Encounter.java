/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etu.entity;

import etu.enums.EncounterType;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author User
 */
@Entity
public class Encounter implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    Date encounterData;
    @Temporal(javax.persistence.TemporalType.DATE)
    Date encounterTime;
    @Temporal(javax.persistence.TemporalType.DATE)
    Date encounterDateTime;
    @Enumerated(EnumType.STRING)
    EncounterType encounterType;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    Date encounterFromData;
    @Temporal(javax.persistence.TemporalType.DATE)
    Date encounterFromTime;
    @Temporal(javax.persistence.TemporalType.DATE)
    Date encounterFromDateTime;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    Date encounterToData;
    @Temporal(javax.persistence.TemporalType.DATE)
    Date encounterToTime;
    @Temporal(javax.persistence.TemporalType.DATE)
    Date encounterToDateTime;
    
    @ManyToOne
    Patient patient;
    @ManyToOne
    WebUser staf;
    @ManyToOne
    Department department;
    @ManyToOne
    Unit unit;

    public Date getEncounterData() {
        return encounterData;
    }

    public void setEncounterData(Date encounterData) {
        this.encounterData = encounterData;
    }

    public Date getEncounterTime() {
        return encounterTime;
    }

    public void setEncounterTime(Date encounterTime) {
        this.encounterTime = encounterTime;
    }

    public Date getEncounterDateTime() {
        return encounterDateTime;
    }

    public void setEncounterDateTime(Date encounterDateTime) {
        this.encounterDateTime = encounterDateTime;
    }

    public EncounterType getEncounterType() {
        return encounterType;
    }

    public void setEncounterType(EncounterType encounterType) {
        this.encounterType = encounterType;
    }

    public Date getEncounterFromData() {
        return encounterFromData;
    }

    public void setEncounterFromData(Date encounterFromData) {
        this.encounterFromData = encounterFromData;
    }

    public Date getEncounterFromTime() {
        return encounterFromTime;
    }

    public void setEncounterFromTime(Date encounterFromTime) {
        this.encounterFromTime = encounterFromTime;
    }

    public Date getEncounterFromDateTime() {
        return encounterFromDateTime;
    }

    public void setEncounterFromDateTime(Date encounterFromDateTime) {
        this.encounterFromDateTime = encounterFromDateTime;
    }

    public Date getEncounterToData() {
        return encounterToData;
    }

    public void setEncounterToData(Date encounterToData) {
        this.encounterToData = encounterToData;
    }

    public Date getEncounterToTime() {
        return encounterToTime;
    }

    public void setEncounterToTime(Date encounterToTime) {
        this.encounterToTime = encounterToTime;
    }

    public Date getEncounterToDateTime() {
        return encounterToDateTime;
    }

    public void setEncounterToDateTime(Date encounterToDateTime) {
        this.encounterToDateTime = encounterToDateTime;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public WebUser getStaf() {
        return staf;
    }

    public void setStaf(WebUser staf) {
        this.staf = staf;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
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
        if (!(object instanceof Encounter)) {
            return false;
        }
        Encounter other = (Encounter) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "etu.entity.Encounter[ id=" + id + " ]";
    }
    
}
