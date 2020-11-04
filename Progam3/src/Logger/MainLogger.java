package Logger;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Date;

public class MainLogger {

	//Definimos log 
	static PrintStream log;
	
	public static void main(String[] args) {
		
		VentanaLogger ventana = new VentanaLogger();
		
		try {
			log = new PrintStream( new FileOutputStream( "logger.log" , true) ); //Crea el fichero, y si ya existe, añade a lo que ya existiera, la nueva información
		}catch (Exception e) {
			System.out.println( "Error" + e);
		}
		log.println( "Inicio Logger "  + (new Date()) );
		
		
		ventana.setVisible( true );
	}

}
