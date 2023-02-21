
/*
 * Programación Interactiva. 
 * Autor: Carolain Jimenez Bedoya - 2071368 
 * Caso 1: Juego craps.
 */

package craps;



import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import misComponentes.Titulos;

// TODO: Auto-generated Javadoc
/**
 * The Class VistaGUIGridBagLayout. Donde esta la interfaz grafica 
 */
public class VistaGUIGridBagLayout extends JFrame {

	//atributos- componentes graficos 

	/** The zona resultado. */ //Paneles dentro de la ventana
	private JPanel zonaJuego, zonaResultado; 
	
	/** The punto. */ //Las etiquetas fijas
	private JLabel dado1,dado2,tiro,punto;
	
	/** The valor punto. */ //Lugar donde se darán los resultados 
	private JTextField valorTiro, valorPunto;
	
	/** The lanzar. */ //boton
	private JButton salir, lanzar; 
	
	/** The imagen. */ //Guarda y carga imagenes 
	private ImageIcon imagen;
	
	/** The mensajes. */ //Zona de mensajes al usuario
	private JTextArea mensajes; 
	
	/** The resultados. */ 
	private Titulos titulo,resultados;
	
	/** The control craps. */ //Objeto control
	private ControlCraps controlCraps;
	
	/** The escucha. */ //Objeto escucha 
	private Escucha escucha;
	
	/** The vista grid bag layout. */
	private JFrame vistaGridBagLayout;


	//metodos 

	/**
	 * Instantiates a new vista GUI grid bag layout.
	 */
	public VistaGUIGridBagLayout() { //CONSTRUCTOR
		initGUI();  //Donde creo los componentes gráficos


		//set default window configuration 
		//this.setTitle("Juego Craps");
		//this.setSize(350, 210);
		//Para que la ventana se ajuste al tamaño 
		this.setUndecorated(true);
		this.pack();
		this.setBackground(new Color (31,160,133));
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}

	/**
	 * Inits the GUI.
	 */
	private void initGUI() {

		//Configurar contenedor y layout

		this.getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();

		//crear objeto control, escucha y cualquier otro

		escucha = new Escucha ();
		controlCraps= new ControlCraps ();
		vistaGridBagLayout= this;


		//Configurar componentes graficos y adicionarlos a la ventana 

		titulo = new Titulos("Juego Craps", 30, new Color(31,160,133)); // Color.BLACK 
		titulo.addMouseListener(escucha);
		titulo.setCursor(new Cursor(Cursor.MOVE_CURSOR));
		titulo.addMouseMotionListener(escucha);
		constraints.gridx=0;
		constraints.gridy=0;
		constraints.gridwidth=2;
		constraints.fill= GridBagConstraints.HORIZONTAL;
		add(titulo,constraints); //Lo adiciono a la ventana grafica 

		//Zona de Juego
		zonaJuego= new JPanel();
		imagen = new ImageIcon("src/imagenes/dado.png");
		dado1 = new JLabel (imagen);
		dado2 = new JLabel (imagen);
		lanzar = new JButton("Lanzar");
		lanzar.addActionListener(escucha);
		zonaJuego.add(dado1);
		zonaJuego.add(dado2);
		zonaJuego.add(lanzar);
		zonaJuego.setBackground(new Color(26,123,61));
		zonaJuego.setPreferredSize(new Dimension(310,180));
		zonaJuego.setBorder(new TitledBorder("Zona Juego"));
		constraints.gridx=0;
		constraints.gridy=1;
		constraints.gridwidth=1;
		constraints.gridheight=3;
		constraints.fill= GridBagConstraints.NONE;

		add(zonaJuego,constraints);


		//Boton salir 

		salir=new JButton("Salir");
		salir.addActionListener(escucha);
		salir.setCursor(new Cursor(Cursor.HAND_CURSOR)); //Cambiar lo de la forma del cursor 
		constraints.gridx=0;
		constraints.gridy=4;
		constraints.gridwidth=1;
		constraints.gridheight=1;
		constraints.fill= GridBagConstraints.NONE;
		constraints.anchor=GridBagConstraints.LAST_LINE_END;
		add(salir,constraints);

		//Resultados - titulo

		resultados= new Titulos("Resultados", 24, new Color(72,191,115));
		constraints.gridx=1;
		constraints.gridy=1;
		constraints.gridwidth=1;
		constraints.gridheight=1;
		constraints.fill= GridBagConstraints.HORIZONTAL;
		constraints.anchor=GridBagConstraints.CENTER;

		add(resultados,constraints);

		//Zona de resultados
		zonaResultado= new JPanel();
		imagen = new ImageIcon("src/imagenes/dado.png");
		zonaResultado.setLayout(new GridLayout(2,2));
		tiro = new JLabel("Tiro");
		punto= new JLabel("Punto");
		valorTiro= new JTextField(2);
		valorTiro.setEditable(false); //Para que el ususario no pueda editarlo 

		valorPunto= new JTextField(2);
		valorPunto.setEditable(false);

		zonaResultado.add(tiro);
		zonaResultado.add(valorTiro);
		zonaResultado.add(punto);
		zonaResultado.add(valorPunto);
		zonaResultado.setBackground(new Color (29,173,81));

		constraints.gridx=1;
		constraints.gridy=2;
		constraints.gridwidth=1;
		constraints.gridheight=1;
		constraints.fill= GridBagConstraints.NONE;
		constraints.anchor=GridBagConstraints.CENTER;

		add(zonaResultado,constraints);


		//Area de texto
		mensajes= new JTextArea(10,20);
		mensajes.setText("Lanza los dados para iniciar el juego. \n");
		mensajes.setEditable(false);
		JScrollPane scroll = new JScrollPane(mensajes); //para poder moverme de forma vertical y horizontal 
		mensajes.setBackground(new Color (31,160,133));

		constraints.gridx=1;
		constraints.gridy=3;
		constraints.gridwidth=1;
		constraints.gridheight=2;
		constraints.fill= GridBagConstraints.VERTICAL;
		constraints.anchor=GridBagConstraints.CENTER;


		//se adiciona el scroll, porque es quien contiene el area de texto 
		add(scroll,constraints);


	}

	/**
	 * The Class Escucha. //Donde se estableceran todos los escuchas del programa 
	 */
	private class Escucha implements ActionListener, MouseListener, MouseMotionListener{ //Cuando se dio click o enter 


		/** The y. */
 private int x,y ;

		/**
		 * Action performed.
		 *
		 * @param eventAction the event action
		 */
		@Override
		public void actionPerformed(ActionEvent eventAction) {
			// TODO Auto-generated method stub
			if (eventAction.getSource()==salir) {

				System.exit(0); //Se corta la ejecución 

			}else {
				//visualizacion grafica de los dados

				controlCraps.calcularTiro();
				imagen= new ImageIcon("src/imagenes/"+controlCraps.getCarasDados()[0]+".png");
				dado1.setIcon(imagen);
				imagen= new ImageIcon("src/imagenes/"+controlCraps.getCarasDados()[1]+".png");
				dado2.setIcon(imagen);

				controlCraps.determinarJuego();
				valorTiro.setText(String.valueOf(controlCraps.getTiro()));


				switch(controlCraps.getEstado()) {

				case 1://gano
					mensajes.append("Has ganado !! \n");
					break;

				case 2://perdio
					mensajes.append("Has perdido !! \n");
					break;


				case 3: //punto
					valorPunto.setText(String.valueOf(controlCraps.getPunto()));
					String mensaje = "Estás en punto!! \nDebes seguir lanzando \n"+       
							"Ganas si sacas nuevamente"+String.valueOf(controlCraps.getPunto())+
							"\npierdes si antes sacas 7 \n ";
					mensajes.append(mensaje);
 
					break;


				}
			}
		}

		/**
		 * Mouse clicked.
		 *
		 * @param eventMouse the event mouse
		 */
		@Override
		public void mouseClicked(MouseEvent eventMouse) { //Algo es clickeado 
			// TODO Auto-generated method stub
			//zonaResultado.setBackground(Color.pink);

		}

		/**
		 * Mouse pressed.
		 *
		 * @param eventMouse the event mouse
		 */
		@Override
		public void mousePressed(MouseEvent eventMouse) { //Presiona en algo 
			// TODO Auto-generated method stub
			//lanzar.setBackground(Color.CYAN);

			x= eventMouse.getX();
			y= eventMouse.getY();
			System.out.println("x="+x);
			System.out.println("y="+y);
		}

		/**
		 * Mouse released.
		 *
		 * @param eventMouse the event mouse
		 */
		@Override
		public void mouseReleased(MouseEvent eventMouse) { //Sueltas algo 
			// TODO Auto-generated method stub
			//salir.setBackground(Color.orange);

		}

		/**
		 * Mouse entered.
		 *
		 * @param eventMouse the event mouse
		 */
		@Override
		public void mouseEntered(MouseEvent eventMouse) { //Mouse se situa en el componente grafico
			// TODO Auto-generated method stub

			//salir.setBackground(Color.blue);
		}

		/**
		 * Mouse exited.
		 *
		 * @param eventMouse the event mouse
		 */
		@Override
		public void mouseExited(MouseEvent eventMouse  ) { //Mouse sale del componente grafico, todo queda normal despues
			// TODO Auto-generated method stub

			//salir.setBackground(Color.GREEN);

		}

		/**
		 * Mouse dragged.
		 *
		 * @param eventMouseMotion the event mouse motion
		 */
		@Override
		public void mouseDragged(MouseEvent eventMouseMotion) {
			// TODO Auto-generated method stub
			//System.out.println("Mouse Motion Dragged"+ eventMouseMotion.getX()); //Observar coordenadas y ver que pasaba


			setLocation(vistaGridBagLayout.getLocation().x+eventMouseMotion.getX()-x,
					vistaGridBagLayout.getLocation().y+eventMouseMotion.getY()-y); //Pinta la ventana en las nuevas coordenadas  


			//posicion final- inicial, para saber cuantos x se mueve el puntero y asi repintar la ventana a medida que se mueve.

		}

		/**
		 * Mouse moved.
		 *
		 * @param eventMouseMotion the event mouse motion
		 */
		@Override
		public void mouseMoved(MouseEvent eventMouseMotion) {
			// TODO Auto-generated method stub
			//System.out.println("Mouse Motion Moved"+ eventMouseMotion.getX());
		}

	}

}
