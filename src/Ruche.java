/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jruche;

/**
 *
 * @author ntaff
 */
public class Ruche {
    private String nom;
    private int poidsMiel;
    private String etat;
    private JRuche ruche;
    
    
    public Ruche(String nom, String etat, int poidsMiel){
        this.nom=nom;
        this.etat = etat;
        this.ruche = new JRuche(1, nom);
        poidsMiel=0;
    }
    
    public void poidsPlus(int poids){
        poidsMiel += poids;
        ruche.setMiel(poidsMiel);
    }
     public void poidsMoins(int poids){
        poidsMiel -= poids;
        ruche.setMiel(poidsMiel);
    }
     
   public int getPoids(){
        return poidsMiel;
    }
     
     public String getEtat(){
        return etat;
    }
     
     public void setEtat(String etat2){
        ruche.setEtat(etat2);
        etat= etat2;
    }
    
}
