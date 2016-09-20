/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etu.controller;

import etu.enums.CategoryType;
import etu.enums.Gender;
import etu.enums.Investigation;
import etu.enums.Outcome;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Aruna Csw
 */
@Named(value = "enumController")
@SessionScoped
public class EnumController implements Serializable {

    /**
     * Creates a new instance of EnumController
     */
    public EnumController() {
    }

    public Gender[] getGenderValues() {
        return Gender.values();
    }

    public CategoryType[] getCategoryValues() {
        return CategoryType.values();
    }

    public CategoryType[] getCategoryValuesWithoutTriage() {
        CategoryType[] cats = new CategoryType[]{CategoryType.Area,CategoryType.PatientCondition,CategoryType.WorkingDiagnosis};
        return cats;
    }

    public Outcome[] getPatientsOutcomes() {
        return Outcome.values();
    }

    public Investigation[] getPatientsInvestigations() {
        return Investigation.values();
    }

}
