/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etu.entity;

import etu.enums.EncounterFindingCategory;
import etu.enums.EncounterFindingDataType;
import etu.enums.EncounterFindingType;
import etu.enums.Gender;
import etu.enums.Investigation;
import etu.enums.Outcome;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
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
 * @author Aruna Csw
 */
@Entity
public class Patient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String sname;
    private String tname;
    private String ename;
    private String bhtNo;

    private int age;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private boolean active;
    @ManyToOne
    private Category area;
    @ManyToOne
    private Category patientCondition;
    @ManyToOne
    private Category triageCategory;
    @OneToOne
    private Department department;
    @ManyToOne
    private Unit unit;
    @Enumerated(EnumType.STRING)
    private Outcome outcome;
    @Enumerated(EnumType.STRING)
    private Investigation investigation;

    @OneToOne(cascade = CascadeType.ALL)
    Encounter initialEncounter;
    @OneToOne(cascade = CascadeType.ALL)
    EncounterFinding sbp;
    @OneToOne(cascade = CascadeType.ALL)
    EncounterFinding dbp;
    @OneToOne(cascade = CascadeType.ALL)
    EncounterFinding pr;
    @OneToOne(cascade = CascadeType.ALL)
    EncounterFinding rr;
    @OneToOne(cascade = CascadeType.ALL)
    EncounterFinding gcs;
    @OneToOne(cascade = CascadeType.ALL)
    EncounterFinding saturation;
    @OneToOne(cascade = CascadeType.ALL)
    EncounterFinding admissionDetails;

    @Temporal(javax.persistence.TemporalType.DATE)
    Date dob;

    public Encounter getInitialEncounter() {
        if (initialEncounter == null) {
            initialEncounter = new Encounter();
            initialEncounter.setPatient(this);
        }
        return initialEncounter;
    }

    public void setInitialEncounter(Encounter initialEncounter) {
        this.initialEncounter = initialEncounter;
    }

    public EncounterFinding getSbp() {
        if (sbp == null) {
            sbp = new EncounterFinding();
            sbp.setEncounter(this.getInitialEncounter());
            sbp.setEncounterFindingCategory(EncounterFindingCategory.examination);
            sbp.setEncounterFindingDataType(EncounterFindingDataType.doubleData);
            sbp.setEncounterFindingType(EncounterFindingType.sbp);
        }
        return sbp;
    }

    public void setSbp(EncounterFinding sbp) {
        this.sbp = sbp;
    }

    public EncounterFinding getDbp() {
        if (dbp == null) {
            dbp = new EncounterFinding();
            dbp.setEncounter(this.getInitialEncounter());
            dbp.setEncounterFindingCategory(EncounterFindingCategory.examination);
            dbp.setEncounterFindingDataType(EncounterFindingDataType.doubleData);
            dbp.setEncounterFindingType(EncounterFindingType.dbp);
        }
        return dbp;
    }

    public void setDbp(EncounterFinding dbp) {
        this.dbp = dbp;
    }

    public EncounterFinding getPr() {
        if (pr == null) {
            pr = new EncounterFinding();
            pr.setEncounter(this.getInitialEncounter());
            pr.setEncounterFindingCategory(EncounterFindingCategory.examination);
            pr.setEncounterFindingDataType(EncounterFindingDataType.doubleData);
            pr.setEncounterFindingType(EncounterFindingType.pr);
        }
        return pr;
    }

    public void setPr(EncounterFinding pr) {
        this.pr = pr;
    }

    public EncounterFinding getRr() {
        if (rr == null) {
            rr = new EncounterFinding();
            rr.setEncounter(this.getInitialEncounter());
            rr.setEncounterFindingCategory(EncounterFindingCategory.examination);
            rr.setEncounterFindingDataType(EncounterFindingDataType.doubleData);
            rr.setEncounterFindingType(EncounterFindingType.rr);
        }
        return rr;
    }

    public void setRr(EncounterFinding rr) {
        this.rr = rr;
    }

    public EncounterFinding getGcs() {
        if (gcs == null) {
            gcs = new EncounterFinding();
            gcs.setEncounter(this.getInitialEncounter());
            gcs.setEncounterFindingCategory(EncounterFindingCategory.examination);
            gcs.setEncounterFindingDataType(EncounterFindingDataType.doubleData);
            gcs.setEncounterFindingType(EncounterFindingType.gcs);
        }
        return gcs;
    }

    public void setGcs(EncounterFinding gcs) {
        this.gcs = gcs;
    }

    public EncounterFinding getSaturation() {
        if (saturation == null) {
            saturation = new EncounterFinding();
            saturation.setEncounter(this.getInitialEncounter());
            saturation.setEncounterFindingCategory(EncounterFindingCategory.investigation);
            saturation.setEncounterFindingDataType(EncounterFindingDataType.doubleData);
            saturation.setEncounterFindingType(EncounterFindingType.saturation);
        }
        return saturation;
    }

    public void setSaturation(EncounterFinding saturation) {
        this.saturation = saturation;
    }

    public EncounterFinding getAdmissionDetails() {
        if (admissionDetails == null) {
            admissionDetails = new EncounterFinding();
            admissionDetails.setEncounter(this.getInitialEncounter());
            admissionDetails.setEncounterFindingCategory(EncounterFindingCategory.history);
            admissionDetails.setEncounterFindingDataType(EncounterFindingDataType.textData);
            admissionDetails.setEncounterFindingType(EncounterFindingType.other);
        }
        return admissionDetails;
    }

    public void setAdmissionDetails(EncounterFinding admissionDetails) {
        this.admissionDetails = admissionDetails;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
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
        if (!(object instanceof Patient)) {
            return false;
        }
        Patient other = (Patient) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "etu.entity.Patient[ id=" + id + " ]";
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getBhtNo() {
        return bhtNo;
    }

    public void setBhtNo(String bhtNo) {
        this.bhtNo = bhtNo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Category getArea() {
        return area;
    }

    public void setArea(Category area) {
        this.area = area;
    }

    public Category getPatientCondition() {
        return patientCondition;
    }

    public void setPatientCondition(Category patientCondition) {
        this.patientCondition = patientCondition;
    }

    public Category getTriageCategory() {
        return triageCategory;
    }

    public void setTriageCategory(Category triageCategory) {
        this.triageCategory = triageCategory;
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

    public Outcome getOutcome() {
        return outcome;
    }

    public void setOutcome(Outcome outcome) {
        this.outcome = outcome;
    }

    public Investigation getInvestigation() {
        return investigation;
    }

    public void setInvestigation(Investigation investigation) {
        this.investigation = investigation;
    }

}
