package uvsq21505126.calculatriceRPN;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MoteurRPN {
	private Map<String, SpeCommand> moteur;
    private Stack<String> pile;
    
    /**
     * Constructeur
     */
    private MoteurRPN() {
        this.moteur = new HashMap<String, SpeCommand>();
        this.pile = new Stack<String>();
    }
    
    /**
     * Ajoute une commande.
     * @param name
     * @param command
     */
    void addCommand(final String name, final SpeCommand command) {
        this.moteur.put(name, command);
    }
    
    /**
     * initialise le moteur
     * @return
     */
    
    public static MoteurRPN init_moteur() {
        MoteurRPN moteur = new MoteurRPN();
        SpeCommand plus = new Addition();
        SpeCommand moins = new Soustration();
        SpeCommand mul = new Multiplication();
        SpeCommand div = new Division();
        moteur.addCommand("+", plus);
        moteur.addCommand("-", moins);
        moteur.addCommand("*", mul);
        moteur.addCommand("/", div);
        return moteur; 
    }
    
    /**
     * methode pour ajouter 
     * @param e
     */
    void addElement(final int e) {
        pile.addElement(String.valueOf(e));
    }
    
    /**
     * Depile un élément.
     * @return string
     */
    public String depiler(){
    	
		if(this.pile.isEmpty()) {
			System.out.println("Ajoutez une operande de plus ..");
	    		throw new EmptyStackException() ;
		}
		else
		{
			return pile.pop();
		}
	
}
    
    /**
     * methode pour l'affichage
     */
    public void affiche() {
    	System.out.print("L'expression courante est:\t");
    	if(!this.pile.isEmpty()) {
    		for(int i=0;i< this.pile.size();i++){
    			System.out.print(this.pile.elementAt(i)+"\t");
    		}	
    	}
    	System.out.println("");
    }
    
    void setStack(final Stack<String> p) {
        Stack<String> pileCopie = (Stack<String>) p.clone();
        pile = pileCopie;
    }
    
    /**
     * methode pour excuter une commande
     * @param name
     */
    void execute(final String name) {
        if (this.moteur.containsKey(name) && pile.size() >= 2) {
            int b = Integer.valueOf(pile.pop());
            int a = Integer.valueOf(pile.pop());
            pile.push(String.valueOf(this.moteur.get(name).apply(a, b)));
        } else {
            System.out.println("Opérande insuffisante");
        }
    }
    
    /**
     * Retourne la pile courante.
     * @return pile
     */
    Stack<String> getStack() {
        return pile;
    }
}
