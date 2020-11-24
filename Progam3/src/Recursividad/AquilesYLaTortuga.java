package Recursividad;

public class AquilesYLaTortuga {

	public static final double VEL_AQUILES = 10;   // metros / sg
	public static final double VEL_TORTUGA = 0.05; // m/sg (0.05m/sg = 1 metro cada 20 segs) 
	public static final double INICIO_AQUILES = 0;    // Aquiles empieza en el metro 0
	public static final double INICIO_TORTUGA = 1000; // La tortuga tiene 1 km de ventaja

	
	/** Devuelve la posici�n de Aquiles en la carrera, dado el tiempo transcurrido
	 * @param t	Tiempo transcurrido de carrera (en sgs)
	 * @return	Posici�n de Aquiles (en m)
	 */
	public static double dondeEstaAquiles( double t ) {
		return INICIO_AQUILES + VEL_AQUILES * t;
	}


	/** Devuelve la posici�n de la tortuga en la carrera, dado el tiempo transcurrido
	 * @param t	Tiempo transcurrido de carrera (en sgs)
	 * @return	Posici�n de la tortuga (en m)
	 */
	public static double dondeEstaLaTortuga( double t ) {
		return INICIO_TORTUGA + VEL_TORTUGA * t;
	}

	

	// Algoritmo recursivo
	// tIni es un tiempo en el que Aquiles todav�a no ha alcanzado a la tortuga
	// tFin es un tiempo en el que Aquiles ha pasado a la tortuga
	public static double cuandoSeEncuentran( double tIni, double tFin ) {
		numLlams++; // Auxiliar para contar el n�mero de llamadas
		if (Math.abs(tIni-tFin) < 0.001) {
			return tIni;
		} else {
			double tMedio = (tIni+tFin)/2;
			double sAquiles = dondeEstaAquiles( tMedio );
			double sTortuga = dondeEstaLaTortuga( tMedio );
			System.out.println( tIni + "," + tFin );
			System.out.println( "   " + sAquiles + "," + sTortuga );
			if (sAquiles <= sTortuga) {
				return cuandoSeEncuentran( tMedio , tFin );
			} else {
				return cuandoSeEncuentran( tIni, tMedio );
			}
		}
	}

	

	private static int numLlams = 0;
	public static void main(String[] args) {
		double t = 50000;
		try {
			double tSol = cuandoSeEncuentran( 0.0, t );
			System.out.println( "Tiempo de encuentro = " + tSol );
			System.out.println( "  Distancia de encuentro = " + dondeEstaAquiles(tSol));
			System.out.println( "N�mero de llamadas: " + numLlams );
		} catch (StackOverflowError e) {
			System.out.println( "Stack overflow!! " + numLlams );
		}
	}

	

}