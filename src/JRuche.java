/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jruche;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author ntaff
 */
public class JRuche extends JFrame{
     private JLabel jEtat;
     private JLabel jMiel;

    public JRuche(int num, String nom) {
        super(nom);
        //fermeture avec croix rouge
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        // creation des composants
        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        jEtat = new JLabel("Vide");
        add(jEtat);
        setEtat("Vide");
        jMiel = new JLabel("Poids de miel = 0g");
        add(jMiel);
        pack();
        setSize(300, 200);

        // nombre d'abeille logeables sur une ligne
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;

        int nb = (screenWidth - 100) / 80;
        int nbx = num % nb;
        int nby = num / nb;

        setLocation(100 + 300 * nbx, 300 + 200 * nby);
        setVisible(true);
    }

    public void setMiel(int poidsMiel) {
        jMiel.setText("poids de miel = "+poidsMiel+"g");
    }
    public void setEtat(String etat) {
        jEtat.setText(etat);
        
        if (etat.equals("Vide")) {
            getContentPane().setBackground(Color.green);
        }
        if (etat.equals("Occupé")) {
            getContentPane().setBackground(Color.red);
        }

    }
}
