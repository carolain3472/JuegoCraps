/*
 * Programación Interactiva
 * Autor: Carolain Jimenez Bedoya - 2071368
 * Caso 1: Juego Craps. 
 */

package craps;

import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class VistaConsola. Clase encargada de realizar las operaciones de entrada y salida por linea de comando, usando objeto Scanner.
 */
public class VistaConsola {


	private ControlCraps controlCraps;


	private String pregunta;


	private Scanner lecturaDatos;


	/**
	 * Instantiates a new vista consola. Es el constructor de la clase que inicia los objetos axiliares. controlCraps y Scanner. 
	 */
	public VistaConsola() {
		controlCraps = new ControlCraps();
		lecturaDatos = new Scanner(System.in);
	}





	/**
	 * Iniciar juego. Inicia la ronda del juego.
	 */

	public void iniciarJuego() {
		System.out.println("¿Deseea Lanzar los dados? escribe y/n" );

		pregunta = lecturaDatos.nextLine(); //Lo que leyó el escaner 

		if (pregunta.equals("y")) {
			//inicia juego

			controlCraps.calcularTiro();
			System.out.printf("Dado 1 = %d Dado 2 = %d Tiro = %d \n", controlCraps.getCarasDados()[0],
					controlCraps.getCarasDados()[1],
					controlCraps.getTiro());

			controlCraps.determinarJuego();

			switch(controlCraps.getEstado()) {

			case 1: System.out.println("Has ganado.");
			break;

			case 2: System.out.println("Has perdido.");
			break;

			case 3: System.out.printf("Has establecido punto = %d, Debes lanzar nuevamente \n", controlCraps.getPunto());

			while (controlCraps.getEstado()==3) {
				System.out.println("¿Deseea Lanzar los dados? escribe y/n" );
				pregunta = lecturaDatos.nextLine();

				if (pregunta.equals("y")) {
					controlCraps.calcularTiro();
					System.out.printf("Dado 1 = %d Dado 2 = %d Tiro = %d \n", controlCraps.getCarasDados()[0],
							controlCraps.getCarasDados()[1],
							controlCraps.getTiro());

					controlCraps.determinarJuego();	

				}
				else {

					System.out.println("Perdiste por abandonar el juego");
					controlCraps.setAbandono();

				}
			}

			if (controlCraps.getEstado()== 1) {
				System.out.println("Ganaste el punto y ganaste.");

			}
			else{
				System.out.println("Perdiste");  
			}
			break;
			}

			seguirJuego();

		}else {
			System.out.println("Adios.");	
		}
	}                                                                

	/**
	 * Seguir juego. Inicia una nueva ronda de juego. 
	 */
	private void seguirJuego() {

		System.out.println("¿Quieres volver a hacer otra ronda? escribe y/n.");
		pregunta = lecturaDatos.nextLine();

		if (pregunta.equals("y")) {
			iniciarJuego();
		}
		else {
			System.out.println("Bye.");	
		}
	}

}

