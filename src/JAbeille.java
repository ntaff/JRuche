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
public class JAbeille extends JFrame{
     private JLabel jEtat;
     private JLabel jChargement;

    public JAbeille(int num, String nom) {
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

        jEtat = new JLabel("");
        add(jEtat);
        jChargement = new JLabel("Chargement = 0g");
        add(jChargement);
        pack();
        setSize(260, 90);

        // nombre de voiture logeables sur une ligne
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;

        int nb = (screenWidth - 100) / 270;
        int nbx = num % nb;
        int nby = num / nb;

        setLocation(100 + 270 * nbx, 100 + 100 * nby);
        setVisible(true);
    }

    public void setChargement(int chargement) {
        jChargement.setText("Chargement = "+chargement+"g");
    }
    public void setEtat(String etat) {
        jEtat.setText(etat);
        if (etat.equals("Je butine")) {
            getContentPane().setBackground(Color.blue);
        }
        if (etat.equals("Je me repose dans la ruche")) {
            getContentPane().setBackground(Color.green);
        }
        if (etat.equals("J'attends à l'entrée de la ruche")) {
            getContentPane().setBackground(Color.red);
        }

    }

}
