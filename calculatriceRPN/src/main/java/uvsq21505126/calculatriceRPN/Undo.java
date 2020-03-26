package uvsq21505126.calculatriceRPN;

import java.util.Stack;

/**
 * 
 * supprime la dernière commande
 *
 */
public class Undo implements Command{
	/**
	 * pile qui va contenir l'historique de la calculatrice
	 */
	private static Stack<Stack<String>> Pile;

/**
 * Constructeur.
 */
public Undo() {
    Pile = new Stack<Stack<String>>();
}

/**
 * Retourne le dernier élément de la pile.
 * @return pile
 */
public Stack<String> getPile() {
    if (!Pile.isEmpty()) {
        return Pile.lastElement();
    } else {
        return new Stack<String>();
    }
}
 /**
  * ajoute un action a la pile 
  * @param element
  */
public void addElement(Stack<String> element) {
    Pile.push(element);
}

/**
 * revien à l'etat d'avant
 */
public void apply() {
    if (!Pile.isEmpty()) {
        Pile.pop();
    } else {
        System.out.println("Undo impossible car il y a aucune action précédente");
    }
}
}

