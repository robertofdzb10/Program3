package logger01;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.logging.Level;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class VentanaLogger01 extends JFrame {
	
	private JFrame ventanaLogger;
	
	public VentanaLogger01() {
		
	ventanaLogger = new JFrame();
	//1. Configuracion de la ventana
	
	setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
	setSize(600, 400); //Tamaño ventana
	setTitle("Logger01"); //No necesita getContentPane, ya que se hace sobre la ventana
	
	
	//2. Creación de contenedores (paneles) y componenetes
	

	//3.Decoraciones
	
	
	//4.Asignacion de componenetes a contenedores
	
	
	//5.Eventos
	this.addWindowListener( new WindowAdapter() {
		
		@Override
		public void windowClosed(WindowEvent e) {
			MainLogger01.log.log( Level.INFO, "Fin de programa.");
		}
	});
	
}}
