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
public class Abeille extends Thread {

    private final String nom;
    private final Ruche ruche;
    private final JAbeille abeille;
    private int poids;

    public Abeille(int num, String nom, Ruche ruche) {
        this.nom = nom;
        this.ruche = ruche;
        this.abeille = new JAbeille(num, nom);
        this.poids = 0;
    }

    @Override
    public void run() {
        Random rand = new Random();
        while (true) {
            // Butine dans la campagne un temps aléatoire (entre 10 et 15s)
            int t = rand.nextInt(5) + 10;
            try {
                System.out.println(nom + " : Je butine pendant " + t + " sec");
                abeille.setEtat("Je butine");
                for(int i = 0 ; i < t ; i++) {
                    abeille.setChargement(i);
                    poids++;
                    Thread.sleep(1000);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Abeille.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Patiente pour rentrer dans la ruche
            while ("Occupé".equals(ruche.getEtat())) {
                System.out.println(nom + " : Ruche pleine, j'attends");
                abeille.setEtat("J'attends à l'entrée de la ruche");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Abeille.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            
            synchronized (ruche) {
                ruche.setEtat("Occupé");;
                System.out.println(nom + " rentre dans la ruche");
            }
            // Je reste dans la ruche un temps aléatoire (entre 1 et 3s)
            int t1 = rand.nextInt(3) + 1;
            try {
                
                ruche.poidsPlus(t);
                
                System.out.println("Poids miel ruche = "+ ruche.getPoids() +"g");
                abeille.setEtat("Je me repose dans la ruche");
                System.out.println(nom + " : je me repose pendant " + t1 + " s");
                Thread.sleep(t1 * 1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Abeille.class.getName()).log(Level.SEVERE, null, ex);
            }
            
              synchronized (ruche) {
                ruche.setEtat("Vide");;
                System.out.println(nom + " sort de la ruche");
            }
        }
    }
}
