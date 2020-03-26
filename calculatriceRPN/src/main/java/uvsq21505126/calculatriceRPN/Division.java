package uvsq21505126.calculatriceRPN;

public class Division implements SpeCommand {
	/**
	 * methode pour la division
	 * @param a
	 * @param b 
	 * @return a/b 
	 */
	public int apply(final int a, final int b) {
        return a / b;
    }
}
