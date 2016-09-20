/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package etu.controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Aruna Csw
 */
@Named(value = "languageController")
@SessionScoped
public class LanguageController implements Serializable {

    String language;

    /**
     * Creates a new instance of LanguageController
     */
    public LanguageController() {
    }

    public String getLanguage() {
        if (language == null || language.equals("")) {
            language = "en";
        }
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void makeLanguageSinhala() {
        language = "si";
    }

    public void makeLanguageTamil() {
        language = "ta";
    }

    public void makeLanguageEnglish() {
        language = "en";
    }

}
