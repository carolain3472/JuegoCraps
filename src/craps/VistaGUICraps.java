
/*
 * Programación Interactiva. 
 * Autor: Carolain Jimenez Bedoya - 2071368 
 * Caso 1: Juego craps.
 */

package craps;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


// TODO: Auto-generated Javadoc
/**
 * The Class VistaGUICraps.
 */
public class VistaGUICraps extends JFrame {
	//atributos
	
	//Van a ser los componentes gráficos 

	/** The dado 2. */ //Imagenes
	JLabel dado1, dado2;
	
	/** The lanzar. */ //Boton
	JButton lanzar;
	
	/** The imagen. */
	private ImageIcon imagen;     //Clase que permite cargar imagenes, solo pueden cargar imagenes los JLabel y los botones 
	
	/** The escucha. */ //Objeto de la clase escucha
	private Escucha escucha;
	
	/** The control craps. */ //Objeto de la clase ControlCraps
	private ControlCraps controlCraps;

	//metodos

	/**
	 * Instantiates a new vista GUI craps.
	 */
	public VistaGUICraps () { // Constructor

		//La ventana tiene un container y un layout 

		Container contenedor= this.getContentPane();
		contenedor.setLayout(new FlowLayout());


		//Crear pobjeto escucha, el objeto control tambien 

		escucha= new Escucha ();
		controlCraps= new ControlCraps();

		// Agregar componentes graficos 

		imagen = new ImageIcon("src/imagenes/dado.png");
		dado1= new JLabel(imagen); 
		dado2= new JLabel(imagen);


		lanzar= new JButton ("Lanzar");
		lanzar.addActionListener(escucha);

		contenedor.add(dado1); //Añade los componentes al contenedor 
		contenedor.add(dado2);
		contenedor.add(lanzar);


		//Configuraci�n por defecto de la ventana
		this.setTitle("Juego Craps");
		this.setSize(350, 210);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}


	/**
	 * The Class Escucha.
	 */
	//Se crea otra clase que tendrá los escuchas 
	
	private class Escucha implements ActionListener{

		/**
		 * Action performed.// Metodo del actionListener
		 *
		 * @param event the event
		 */
		@Override
		
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub

			if (event.getSource()==lanzar) {
				visualizarCaras();
				controlCraps.determinarJuego();

				//establecer el mensaje 

				String tiro= "El tiro fue:  " + controlCraps.getTiro()+"\n";

				//Se debe definir primero el objeto del icono 
				Icon icon;

				switch(controlCraps.getEstado()) {
				case 1: icon= new ImageIcon("src/imagenes/ganaste.png");
				JOptionPane.showMessageDialog(lanzar, tiro + "Has ganado!!", "Resultado", JOptionPane.DEFAULT_OPTION, icon);
				break;


				case 2: icon= new ImageIcon("src/imagenes/perdiste.png");
				JOptionPane.showMessageDialog(lanzar, tiro + "Has perdido!!", "Resultado", JOptionPane.DEFAULT_OPTION, icon);

				break;


				case 3: String punto = "Has establecido punto en " + controlCraps.getPunto() + " Debes volver a sacar el valor del punto para ganar"+"\n"+"pero si sacas antes 7, perderás"+"\n";

				icon= new ImageIcon("src/imagenes/punto.png");
				JOptionPane.showMessageDialog(lanzar, tiro + punto, "Resultado", JOptionPane.DEFAULT_OPTION, icon);
				break;

				}
			}


		}

	}


	/**
	 * Visualizar caras. //Que imagen corresponde a cada dado 
	 */
	private void visualizarCaras() {

		controlCraps.calcularTiro();

		imagen = new ImageIcon("src/imagenes/"+controlCraps.getCarasDados()[0]+".png");
		dado1.setIcon(imagen);

		imagen = new ImageIcon("src/imagenes/"+controlCraps.getCarasDados()[1]+".png");
		dado2.setIcon(imagen);

	}

}



