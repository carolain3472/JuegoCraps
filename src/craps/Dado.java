/*
 * Programación Interactiva. 
 * Autor: Carolain Jimenez Bedoya - 2071368 
 * Caso 1: Juego craps.
 */

package craps;
import java.util.Random;

// TODO: Auto-generated Javadoc
/**
 * The Class Dado. Esta clase simula un dado y permite ver el valor de la cara visible. 
 */

public class Dado {

	/** The cara visible. Es el valor obtenido comprendido de 1 a 6 de dicho dado. */
	private int caraVisible;

	/**
	 * Gets the cara visible.Determina el valor de la cara visible del dado.
	 *
	 * @return the cara visible, un valor comprendido entre 1 y 6.
	 */

	public int getCaraVisible() {

		Random aleatorio= new Random();
		caraVisible= aleatorio.nextInt(6) + 1;
		return caraVisible;
	}


}

