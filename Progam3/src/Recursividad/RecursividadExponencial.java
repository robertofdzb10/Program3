package Recursividad;

public class RecursividadExponencial {

	public static void main(String[] args) {
		sacaCadenas(3);
	}
	
	private static void sacaCadenas( int n) {
		sacaCadenas( n, "" );
	}
	
	//Saca todas las cadenas de A y B de longitud N
	//Añadir a la cadena previa de A y sacar todas las cadenas de longitud n-1
	//Añadir a la cadena previa de B y sacar todas las cadenas de longitud n-1
	//Caso base: si N=0 se saca la cadena previa a la consola
	public static void sacaCadenas(int n, String previa) {
		if (n == 0) {
			System.out.println( previa );
		} else {
			sacaCadenas( n-1,  previa+"A");
			sacaCadenas( n-1,  previa+"B");
		}
	}

}
