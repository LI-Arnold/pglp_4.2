package uvsq21505126.calculatriceRPN;

public class Addition implements SpeCommand{
	/**
	 * methode pour l'addition
	 * @param a
	 * @param b 
	 * @return a+b 
	 */
	public int apply(final int a, final int b) {
        return a + b;
    }
}
