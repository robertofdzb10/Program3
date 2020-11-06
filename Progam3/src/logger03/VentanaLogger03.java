package logger03;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.logging.Level;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class VentanaLogger03 extends JFrame {
	
	private JFrame ventanaLogger;
	
	public VentanaLogger03() {
		
	ventanaLogger = new JFrame();
	//1. Configuracion de la ventana
	
	setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
	setSize(600, 400); //Tamaño ventana
	setTitle("Logger02"); //No necesita getContentPane, ya que se hace sobre la ventana
	
	
	//2. Creación de contenedores (paneles) y componenetes
	
	JPanel panel = new JPanel();
	panel.setBackground(Color.WHITE);
	JPanel botonera = new JPanel();
	botonera.setBackground(Color.LIGHT_GRAY);
	JButton bStart = new JButton( "Start");
	JButton bStop = new JButton( "Stop");
	
	
	//3.Decoraciones
	

	
	//4.Asignacion de componenetes a contenedores
	
	getContentPane().add( panel, null);
	getContentPane().add( botonera, BorderLayout.SOUTH);
	botonera.add(bStart);
	botonera.add(bStop);
	
	
	//5.Eventos
	this.addWindowListener( new WindowAdapter() {
		
		@Override
		public void windowClosed(WindowEvent e) {
			MainLogger03.log.log( Level.INFO, "Fin de programa.");
		}
	});
	
	bStart.addActionListener( new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Hola");
			MainLogger03.log.log( Level.FINER, "Se esta comenzando el juego.");
		}
	});

	bStop.addActionListener( new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			MainLogger03.log.log( Level.FINER, "Se esta terminando el juego.");
			System.out.println("Adios");
		}
	});

}}

//SEVERE: Nivel de mensaje indicando un error serio.
//WARNING: Indica un error potencial.
//INFO: Para mensajes informativos.
//CONFIG: Usado con mensajes relacionados con la configuración.
//FINE: Proporciona información de traza de la ejecución.
//FINER: Información de traza más detallada.
//FINEST: Información de traza muy detallada.
