/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cse.employe;

/**
 *
 * @author Sergio.COURTOIS
 */
public class Marketteur extends Employe {
    
    public Marketteur(String nom, String prenom, String dateNaissance) {
        super(nom, prenom, dateNaissance);
        this.lvl=2;
    }
    
}
