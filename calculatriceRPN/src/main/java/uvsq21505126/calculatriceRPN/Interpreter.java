package uvsq21505126.calculatriceRPN;

import java.util.*;

public final class Interpreter {
	 /**
     * Commandes quit et undo.
     */
    private Map<String, Command> commands;

    /**
     * Constructeur  de la classe interpreter
     */
    private Interpreter() {
        this.commands = new HashMap<String, Command>();
    }

    /**
     * méthode pour créer name qui excute command.
     * @param name
     * @param command
     */
    void addCommand(final String name, final Command command) {
        this.commands.put(name, command);
    }

    /**
     * méthode qui execute name.
     * @param name
     */
    void executeCommand(final String name) {
        if (this.commands.containsKey(name)) {
            this.commands.get(name).apply();
        }
    }

    /**
     * Constructeur public avec les fonctions prédéfinis.
     * @param historique
     * @return Interpreter
     */
    static Interpreter init(final Undo historique) {
        Interpreter interpreter = new Interpreter();
        Command quit = new Quit();
        interpreter.addCommand("quit", quit);
        interpreter.addCommand("undo", historique);
        return interpreter;
    }
}