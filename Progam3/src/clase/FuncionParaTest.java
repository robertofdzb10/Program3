package clase;



/** Funci�n de ejemplo a testar

 * @author andoni.eguiluz @ ingenieria.deusto.es

 */

public class FuncionParaTest {

	

	/** Devuelve el factorial de un n�mero (producto de ese n�mero por todos los anteriores hasta 1). El factorial de 0 es 1.

	 * @param x	Valor del que calcular el factorial

	 * @return	Resultado del factorial

	 * @throws ArithmeticException	Lanzada cuando se intenta un factorial inviable (negativo) o cuando el resultado es incorrecto

	 */

	public static int factorial( int x ) throws ArithmeticException {
		
		if (x<0) throw new ArithmeticException( "Factorial de negativo es incorrecto"); //"Cazar" excepciones.
		if (x>12) throw new ArithmeticException( "Factorial no cabe en un int"); 
		int fact = 1;

		for (int i=1; i<=x; i++) {

			fact *= i;

			if (fact<0) throw new ArithmeticException( "Factorial no cabe en un int" );

		}

		return fact;

	}

	

}
