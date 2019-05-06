package jruche;

/**
 *
 * @author ntaff
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // On créé une ruche vide
        Ruche r = new Ruche("BeeHome", "Vide", 0);

        // On créé 5 abeilles
        for (int i = 0; i < 5; i++) {
            new Abeille(i, "Abeille" + i,r).start();
        }
        new Ours("Nounours", r).start();

    }
}
