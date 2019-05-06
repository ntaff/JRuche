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
public class JOurs extends JFrame{
     private final JLabel jEtat;
     private final JLabel jChargement;

    public JOurs(String nom) {
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
        setSize(280, 90);
        
                // nombre d'abeille logeables sur une ligne
        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;

        int nb = (screenWidth - 100) / 80;
        int nbx = 1 % nb;
        int nby = 1 / nb;

        setLocation(100 + 600 * nbx, 600 + 200 * nby);
        setVisible(true);

    }

    public void setChargement(int chargement) {
        jChargement.setText("Chargement = "+chargement+"g");
    }
    public void setEtat(String etat) {
        jEtat.setText(etat);
        if (etat.equals("Je dors")) {
            getContentPane().setBackground(Color.red);
        }
        if (etat.equals("J'attends que la ruche soit libre")) {
            getContentPane().setBackground(Color.orange);
        }
        if (etat.equals("Je prélève le miel hmmm miam miam")) {
            getContentPane().setBackground(Color.green);
        }

    }

}
