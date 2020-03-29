package uvsq21505126.calculatriceRPN;

import java.util.Scanner;

public class SaisieRPN {

    private MoteurRPN moteur;
    private Interpreter interprete;
    private Scanner sc = new Scanner(System.in);
    private Undo historique;

    public SaisieRPN() {
        this.moteur = MoteurRPN.init_moteur();
        this.historique = new Undo();
        this.interprete = Interpreter.init(historique);
    }
    
    /**
     * methode pour gèrer les entreé.
     */
    public void entree() {
        System.out.println("Veuillez saisir une action :");
        String str = sc.nextLine();
        if (str.equals("quit")) {
            interprete.executeCommand(str);
        } else if (str.equals("undo")) {
            interprete.executeCommand(str);
            moteur.setStack(historique.getPile());
            moteur.affiche();
        } else if (str.equals("-") || str.equals("*")
|| str.equals("/") || str.equals("+")) {
            moteur.execute(str);
            historique.addElement(moteur.getStack());
            moteur.affiche();
        } else {
            try {
                int nombre = Integer.parseInt(str);
                moteur.addElement(nombre);
                historique.addElement(moteur.getStack());
                moteur.affiche();
            } catch (NumberFormatException e) {
                System.out.println("Entrée est invalide");
            }
        }

    }
}
