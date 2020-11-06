package recursividad;

public class PruebaRecursividad {

	public static void main(String[] args) {
		subir(1);
		//bajar(3000);
		System.out.println( factorial(7));
		//Multiplicacíon en función de la suma
		System.out.println( producto( 0, 5));
		recorrerString("Hola" , 0);
	}
	
	private static void recorrerString( String string, int indice) {
		if (indice == string.length()) {
			return;
		} else {
			System.out.print(string.charAt(indice));
			recorrerString(string, indice+1);
			System.out.print(string.charAt(indice));
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
