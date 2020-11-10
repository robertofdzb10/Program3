package logger00;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Date;

public class MainLogger00 {

	//Definimos log 
	static PrintStream log;
	
	public static void main(String[] args) {
		
		VentanaLogger00 ventana = new VentanaLogger00();
		
		try {
			log = new PrintStream( new FileOutputStream( "logger00.log" , true) ); //Crea el fichero, y si ya existe, añade a lo que ya existiera, la nueva información
		}catch (Exception e) {
			System.out.println( "Error" + e);
		}
		log.println( "Inicio Logger "  + (new Date()) ); //Escribimos en el archivo
		
		ventana.setVisible( true );
	}

}
