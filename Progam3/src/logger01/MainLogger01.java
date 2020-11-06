package logger01;


import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MainLogger01 {
	
	//Definir log
	static Logger log;
	
	public static void main(String[] args) {
		
		VentanaLogger01 ventana = new VentanaLogger01();
		
		try {
			log = Logger.getLogger( "prueba-logger" );
			log.addHandler( new FileHandler( "logger01.xml") ); //Fichero donde se guarda la información del log, sino aparece por defecto en consola
		} catch (Exception e) {
			System.out.println( "Error" + e );
		}
		log.log( Level.INFO, "Inicio Logger " + (new Date()) );
		
		ventana.setVisible( true );
		
	}
}
