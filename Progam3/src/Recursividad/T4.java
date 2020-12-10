package Recursividad;

import java.awt.Color;
import java.awt.geom.Point2D;

public class T4 {
	
	private static double RADIO = 15.0;
	private static double INCREMENTO = 0.1;   // Incremento de tiempo entre prueba y prueba para el choque aproximado
	private static double T_MAXIMO = 100.0;   // Tiempo máximo de prueba para el choque aproximado
	private static double DIST_FINA = 0.0001; // Distancia de error que se quiere afinar para el choque exacto

	public static void main(String[] args) {
		dibuja();
		double tiempo = buscaChoque(0.0); //Ya se han chocado
		if (tiempo == -1.0){
			System.out.println("Las bolas 1 y 2 no chocan.");
		} else {
			System.out.println("Las bolas 1 y 2 chocan aproximadamente en el tiempo: " + tiempo +"s.");
			System.out.println("Las bolas 1 y 2 chocan exactamente en el tiempo: " + buscaChoqueExacto(0, tiempo) +"s.");
		}
		System.out.println(buscaChoqueExacto( 0.0, 50000));
		// T4
	}

	
	private static double buscaChoque(double tiempo) {
		if (tiempo >= 100.0) {
			return -1.0;
		} if (choque( tiempo ) == true){
			return tiempo;	
		} else {
			return buscaChoque( tiempo + 0.1);
		}

	}
	
	private static boolean choque(double tiempoBola) {
		boolean choque;
		if ( distancia( getBola1(tiempoBola), getBola2(tiempoBola) ) <= (2*RADIO) ) {
			choque = true;	
		} else {
			choque = false;
		}
		return choque;
	}
	
	//tIni es un tiempo en el cual todav�a no se han chocado las bolas
	//tFin es un tiempo en el cual ya se han chocado las bolas
	private static double buscaChoqueExacto( double tIni, double tFin) {
		double tMedio = (tIni+tFin) /2.0;
		if (choque(tMedio) == true) {
			if ( distancia( getBola1(tMedio), getBola2(tMedio) ) >= (2*RADIO-DIST_FINA)) {
				return tMedio;
			} else {
				//Chocan, aproximamos hacia abjo
				return buscaChoqueExacto(tIni, tMedio);
			}
		} else {
			//No chocan, aproximamos hacia arriba
			return buscaChoqueExacto(tMedio, tFin);
		}
	}



	// Distancia entre dos puntos
	public static double distancia( Point2D.Double b1, Point2D.Double b2 ) {
		return Math.sqrt( (b2.x-b1.x)*(b2.x-b1.x) + (b2.y-b1.y)*(b2.y-b1.y) );
	}

	// Ecuación de bola 1
	public static Point2D.Double getBola1( double tiempoSegs ) {
		Point2D.Double ret = new Point2D.Double( tiempoSegs*50, tiempoSegs*50 );
		return ret;
	}

	// Ecuación de bola 2
	public static Point2D.Double getBola2( double tiempoSegs ) {
		Point2D.Double ret = new Point2D.Double( 290 + 100 * Math.sin(tiempoSegs), 295 + 100 * Math.cos(tiempoSegs) );
		return ret;
	}
	
	
	// Dibuja las bolas de billar hasta que se haga click
	private static void dibuja() {
		VentanaGrafica vg = new VentanaGrafica( 800, 600, "Bolas T4" );
		vg.setDibujadoInmediato( false );
		double tiempo = 0.0;
		while (vg.getRatonPulsado()==null && !vg.estaCerrada()) {
			Point2D.Double bola1 = getBola1( tiempo );
			Point2D.Double bola2 = getBola2( tiempo );
			vg.borra();
			vg.dibujaCirculo( bola1.x, bola1.y, RADIO, 2f, Color.blue );
			vg.dibujaCirculo( bola2.x, bola2.y, RADIO, 2f, Color.green );
			vg.repaint();
			tiempo += 0.1;
			vg.espera( 100 );
		}
		vg.acaba();
	}
	
}
