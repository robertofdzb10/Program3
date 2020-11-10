package Recursividad;

public class PruebaRecursividad {

	public int contador;
	
	public static void main(String[] args) {
		subir(1);
		//bajar(3000);
		System.out.println( factorial(7));
		//Multiplicacíon en función de la suma
		System.out.println( producto( 0, 5));
		recorrerString("Hola" , 0);
		System.out.println("\n");
		System.out.println( stringAlReves( "Hola al revés" ));
		System.out.println( fib(10) );
		System.out.println( calculoDobleces( 384400000, 0.0001, 0));
		int[] array = new int[] {1,3,4,5,8,9,12,18,19,21};
		int buscado = 2;
		int donde = buscaEnVector( buscado , array, 0,  ((array.length)-1));
		System.out.println( donde );
		System.out.println(array.length-1);
	}
	

	private static int buscaEnVector(int valor, int[] array, int ini, int fin) {
		if (ini>fin) return -1; // Caso base : no encontrando
		int mitad = (ini + fin) / 2;
		if(array[mitad] == valor) {// Caso base : encontrando
			return mitad;
		} else {
			if( array[mitad]>valor) { //A la izquieda  ( el que hay en medio es > que el buscado)
				return buscaEnVector( valor, array, ini, mitad -1);
			} else { //A la derecha ( el que hay en medio es < que el buscado)
				return buscaEnVector(valor, array, mitad +1, fin);
			}
		}
			
	}
	
	private static double calculoDobleces(int distTL, double grosor, int numDob) {
		if(grosor>= distTL) {
		return numDob;
		} else {
			return calculoDobleces(distTL, grosor*2, numDob+1);
		}
	}

	public static String stringAlReves( String string ) {
		if (string.isEmpty()) {
			return "";
		} else {
			return stringAlReves(string.substring(1)) + string.charAt(0);
		}
	}

	
	//Fibonacci: 1, 1, 2, 3, 5, 8...
	//fib(n) = fib(n-1) + fib(n-2)
	public static int fib(int n) {
		if(n==1) {
		return 1;
		
		} else if(n==2) {
		return 1;
		
		}else {
			return fib(n-1) + fib(n-2);
		}
	}
	
	private static void recorrerString( String string, int indice) {
		if (indice == string.length()) {
			return;
		} else {
			System.out.print(string.charAt(indice));//Sucede en orden directo
			recorrerString(string, indice+1);
			System.out.print(string.charAt(indice));//Sucede en orden inverso
		}
	}
	
	private static int producto(int n, int m) {
		if (m == 0) {
		return 0;
		} else {
			return n + producto(n, m-1);
		}
	}

	private static int factorial(int n) {
		if (n == 0) {
		return 1;
		} else {
			return n * factorial(n-1);
		}
	}

	private static void subir( int n) {
		if (n< 3000) { //Caso recursivo
		System.out.println( "Subiendo es " + n);
		subir(n+1);
		System.out.println( "Bajando es " + n);
		} else {
			return; //Caso base, la recursividad deja de funcionar
		}
	}
	
	private static void bajar(int n) {
		if (n > 0) {
		System.out.println( "El numero es " + n);
		bajar(n-1);
		} else {
			return;
		}
		
	}
}
