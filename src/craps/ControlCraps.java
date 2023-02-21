/*
 * Programación Interactiva 
 * Autor: Carolain Jimenez Bedoya - 2071368 
 * Caso 1: Juego Craps. 
 */

package craps;

// TODO: Auto-generated Javadoc
/**
 * The Class ControlCraps. Es la clase que maneja la lógica de todo el juego. 
 */

public class ControlCraps {


	/** The dado 2. */
	private Dado dado1,dado2;


	/** The estado. */
	private int tiro, punto, estado;


	/** The lanzamiento. */
	private boolean lanzamiento;


	/** The caras dados. */
	private int[] carasDados; 

	/**
	 * Instantiates a new control craps.Es el constructor de la clase y se encarga de crear los objetos a usar. 
	 */
	public ControlCraps() {
		dado1 = new Dado();
		dado2 = new Dado();
		lanzamiento = true; // ronda de tiro inicial
		carasDados = new int [2];

	}



	/**
	 * Calcular tiro. Simula el lanzamiento de los dados y establece el valor del tiro. 
	 */
	public void calcularTiro() {
		carasDados[0] = dado1.getCaraVisible();
		carasDados[1] = dado2.getCaraVisible();
		tiro = carasDados[0] + carasDados[1];
	}



	/**
	 * Determinar juego. Determina el estado del juego: estado = 1, gana; estado =2, pierde; estado = 3,punto;
	 */

	public void determinarJuego() {
		if  (lanzamiento) {

			if (tiro==7 || tiro==11) {
				estado = 1; //ganar
			}
			else{

				if (tiro==2 || tiro==3 || tiro==12) {
					estado = 2; //perder
				}
				else {
					estado = 3; //entra a ronda del punto
					punto = tiro;
					lanzamiento = false;
				}
			}
		}else{
			rondaPunto();
		}
	} 



	/**
	 * Ronda punto. Establece el estado del juego cuando se está en la ronda punto.
	 */

	private void rondaPunto(){
		if (tiro==punto) {
			estado = 1; //gana
			lanzamiento = true; //vuelve a iniciar 
		}
		if (tiro==7) {
			estado = 2; //pierde
			lanzamiento = true;// Nueva ronda
		}
	}




	/**
	 * Sets the abandono. Establece el estado del juego si el usuario abandona la ronda de punto.
	 */
	public void setAbandono() {
		estado = 2;
		lanzamiento = true;
	}

	/**
	 * Gets the tiro. Devuelve el valor del tiro de los dados.
	 *
	 * @return the tiro. valor del tiro 2-12
	 */

	public int getTiro() {
		return tiro;
	}

	/**
	 * Gets the punto. Devuelve el valor del punto. 
	 *
	 * @return the punto, valor ente 2-12 
	 */
	public int getPunto() {
		return punto;
	}

	/**
	 * Gets the estado. Devuelve el estado en que se encuentra el juego. 
	 *
	 * @return the estado
	 */
	public int getEstado() {
		return estado;
	}

	/**
	 * Gets the caras dados. Devuelve las caras de los dados. 
	 *
	 * @return the caras dados, la cara visible de ambos dados. 
	 */
	public int[] getCarasDados() {
		return carasDados;
	}


}


