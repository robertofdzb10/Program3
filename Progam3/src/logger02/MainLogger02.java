package logger02;


import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import logger03.VentanaLogger03;


public class MainLogger02 {
	
	//Definir log
	static Logger log;
	
	public static void main(String[] args) {

		VentanaLogger02 ventana = new VentanaLogger02();
		
		try {
			log = Logger.getLogger( "prueba-logger" );
			log.setUseParentHandlers( false ); //No saca por consola el log
			Handler h = new FileHandler( "logger02.xml", true); //Por defecto se reinicia el archivo en cada ejecución ,sin embargo, si pongo true, no.
			log.addHandler( h ); //Fichero donde se guarda la información del log, sino aparece por defecto en consola
			//Por defecto solo se regista de info en adelante.
			h.setLevel(Level.FINEST); //Aqui estamos poniendo que se registre de Finest en adelante (todos).
			log.setLevel( Level.FINEST);//Aqui estamos poniendo que se registre de Finest en adelante (todos).*2
		} catch (Exception e) {
			System.out.println( "Error" + e );
		}
		log.log( Level.INFO, "Inicio Logger " + (new Date()) );
		
		ventana.setVisible( true );
	}
}
