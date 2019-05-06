/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jruche;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ntaff
 */
public class Ours extends Thread {

    private final String nom;
    private final Ruche ruche;
    private final JOurs ours;
    private int poids;

    public Ours(String nom, Ruche ruche) {
        this.nom = nom;
        this.ruche = ruche;
        this.ours = new JOurs(nom);
        this.poids = 0;
    }

    @Override
    public void run() {
        Random rand = new Random();
        while (true) {
            // Je dors pendant 40sec
            try {
                System.out.println(nom + " : Je dors pendant 40sec");
                ours.setEtat("Je dors");
                    Thread.sleep(40000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Ours.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Patiente pour rentrer dans la ruche
            while ("Occupé".equals(ruche.getEtat())) {
                System.out.println(nom + " : Ruche pleine, j'attends");
                ours.setEtat("J'attends que la ruche soit libre");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Ours.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            synchronized (ruche) {
                ruche.setEtat("Occupé");;
                System.out.println(nom + " sort de la ruche");
            }
            // Je reste dans la ruche pendant 5sec
            try {
                    
                
                ours.setEtat("Je prélève le miel hmmm miam miam");
                System.out.println("Nounours prélève le miel");
                Thread.sleep(5000);
                int poidsMielOurs = ruche.getPoids()/2;
                ruche.poidsMoins(poidsMielOurs);
                ours.setChargement(poids += poidsMielOurs);
            } catch (InterruptedException ex) {
                Logger.getLogger(Ours.class.getName()).log(Level.SEVERE, null, ex);
            }
            synchronized (ruche) {
                ruche.setEtat("Vide");;
                System.out.println(nom + " sort de la ruche");
            }

        }
    }
}
